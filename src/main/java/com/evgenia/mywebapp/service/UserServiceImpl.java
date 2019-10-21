package com.evgenia.mywebapp.service;

import com.evgenia.mywebapp.dao.RoleDAO;
import com.evgenia.mywebapp.dao.UserDAO;
import com.evgenia.mywebapp.model.Role;
import com.evgenia.mywebapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne((long) 1));
        user.setRoles(roles);
        userDAO.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }
}
