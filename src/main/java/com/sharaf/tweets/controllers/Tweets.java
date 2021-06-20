package com.sharaf.tweets.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.sharaf.tweets.models.Tweet;
import com.sharaf.tweets.models.User;
import com.sharaf.tweets.repositories.TweetRepository;
import com.sharaf.tweets.services.TweetService;
import com.sharaf.tweets.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Tweets {
    @Autowired
    private TweetService tweetService;
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showAllTweets(Model model, HttpSession session) {
        model.addAttribute("allTweets", tweetService.all());
        Long sessionId = (Long) session.getAttribute("userId");
        if (sessionId != null) {
            session.invalidate();
        }
        return "index.jsp";
    }
    @GetMapping("/newtweet")
    public String newTweet(@Valid @ModelAttribute("tweet") Tweet tweet, BindingResult result, Model model) {
        return "newTweet.jsp";
    }

    @PostMapping("/newtweet")
    public String postTweet(@Valid @ModelAttribute("tweet") Tweet tweet, BindingResult result, Model model, HttpSession session) {
        // System.out.println(tweet.getTweet());
        if (result.hasErrors()) {
            return "newTweet.jsp";
        }
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        tweet.setUser(user);
        tweetService.createTweet(tweet);
        return "redirect:/dashboard";
    }

}
