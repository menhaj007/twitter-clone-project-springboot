package com.sharaf.tweets.services;

import java.util.List;
import java.util.Optional;

import com.sharaf.tweets.models.Tweet;
import com.sharaf.tweets.repositories.TweetRepository;
import com.sharaf.tweets.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;


    public List<Tweet> all() {
        return tweetRepository.findAll();
    }

    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    public Optional<Tweet> findATweet(Long id) {
        Optional<Tweet> findTweet = tweetRepository.findById(id);
        return findTweet.isPresent()? findTweet: null;
    }
    public Tweet updateTweet(Tweet tweet) {
        return createTweet(tweet);
    }
    public void destroy(Long id) {
        if (findATweet(id).get() != null) {
            tweetRepository.deleteById(id);
        }
    }



    
}
