package com.sharaf.tweets.services;

import java.util.Optional;

import com.sharaf.tweets.models.User;
import com.sharaf.tweets.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) {
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
     return userRepository.save(newUser);
    }
    public User searchUser(User user) {
        Optional<User> findTheUser = userRepository.findById(user.getId());
        if (findTheUser.isPresent()) {
            return findTheUser.get();
        }
        return null;
    }
    public User searchByEmail(String email) {
        User foundUser = (User) userRepository.findByEmail(email);
        // return foundUser != null? foundUser: null;
        return foundUser;
    }
    public boolean authenticateUser(String email, String password) {
        User foundUser = userRepository.findByEmail(email);
        if (foundUser == null) return false;
        if (BCrypt.checkpw(password, foundUser.getPassword())) return true;
        else return false;
    }
    public User findById(Long id) {
        User foundUser = userRepository.findById(id).get();
        if (foundUser != null)
            return foundUser;
        return null;
    }



    // authenticate user
    // public boolean authenticateUser(String email, String password) {
    //     // first find the user by email
    //     User user = userRepository.findByEmail(email);
    //     // if we can't find it by email, return false
    //     if(user == null) {
    //         return false;
    //     } else {
    //         // if the passwords match, return true, else, return false
    //         if(BCrypt.checkpw(password, user.getPassword())) {
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }
    // }


    // public User registerUser(User user) {
    //     String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    //     user.setPassword(hashed);
    //     return userRepository.save(user);
    // }
     // find user by email
    //  public User findByEmail(String email) {
    //     return userRepository.findByEmail(email);
    // }
    
    // // find user by id
    // public User findUserById(Long id) {
    // 	Optional<User> u = userRepository.findById(id);
    	
    // 	if(u.isPresent()) {
    //         return u.get();
    // 	} else {
    // 	    return null;
    // 	}
    // }
    
    
}
