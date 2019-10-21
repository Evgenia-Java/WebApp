package com.evgenia.mywebapp.service;

import com.evgenia.mywebapp.model.User;

public interface UserService  {

    void save(User user);
    public User findByUserName(String userName);
}
