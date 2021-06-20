package com.sharaf.tweets.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import com.sharaf.tweets.models.User;
import com.sharaf.tweets.services.TweetService;
import com.sharaf.tweets.services.UserService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Users {
    @Autowired
    private UserService userService;
    @Autowired
    private TweetService tweetService;

    @GetMapping("/home") 
    public String getAllTweets(Model model, HttpSession session) {
        model.addAttribute("allTweets", tweetService.all());
        Long sessionId = (Long) session.getAttribute("userId");
        if (sessionId != null) {
            session.invalidate();
        }
        // session.invalidate();
        return "index.jsp";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if (findUser == null) return "redirect:/registration";
        // boolean isAuthenticated = userService.authenticateUser(email, password);
        // User findUser = userService.searchByEmail(email);
        // if (isAuthenticated) {
        //     session.setAttribute("userId", findUser.getId());
        //     return "redirect:/dashboard";
        // }
        // if (!isAuthenticated) model.addAttribute("error", "Invalid credentials. Please try again");
        // return "loginPage.jsp";

        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User userFound = userService.searchByEmail(email);
            session.setAttribute("userId", userFound.getId());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again");
            return "loginPage.jsp";
        }


    }
    @GetMapping("/logout")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User foundUser = userService.findById((Long) session.getAttribute("userId"));
        if (foundUser == null) return "redirect:/";
        model.addAttribute("loggedUser", foundUser);
        model.addAttribute("userTweets", foundUser.getTweets());
        return "dashboard.jsp";
    }

    @GetMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        return "registerPage.jsp";
    }
    @PostMapping("/registration")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            return "registerPage.jsp";
        }
        User newUser = userService.createUser(user);
        session.setAttribute("userId", newUser.getId());
        // User checkUser = (User) userService.searchByEmail(user.getEmail());
        // if (checkUser != null) {
        //     // result.rejectValue("user", "Match", "User already exit");
        //     System.out.println("User exits");
        //     return "redirect:/login";
        // }
        // String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        // user.setPassword(hashed);
        // userService.createUser(user);
        
        // System.out.println(user.getEmail() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getPassword() + " confirm " + user.getPasswordConfirmation());
        return "redirect:/dashboard";
    }
}
