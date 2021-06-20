package com.sharaf.tweets.repositories;

import java.util.List;
import java.util.Optional;

import com.sharaf.tweets.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    User findByEmail(String email);

    User findByFirstName(String firstName);
    User findByLastName(String lastName);
    
    
}
