package com.sharaf.tweets.repositories;

import java.util.List;
import java.util.Optional;

import com.sharaf.tweets.models.Tweet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAll();
    // Tweet findByTweet (String name);
    Optional<Tweet> findById(Long id);
    
}
