package com.evgenia.mywebapp.service;

public interface SecurityService {

    String findLoggedInUserName();

    void autoLogin(String userName, String userPassword);
}
