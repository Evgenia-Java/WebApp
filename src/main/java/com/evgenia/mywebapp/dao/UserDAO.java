package com.evgenia.mywebapp.dao;

import com.evgenia.mywebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    public User findByUserName (String userName);
}
