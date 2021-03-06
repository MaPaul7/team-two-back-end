package com.agora.services;

import com.agora.models.LoginTemplate;
import com.agora.models.User;
import com.agora.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {


    UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Set<User> findAll() {
        return userDAO.findAll();
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public User findUserById(int id) { return userDAO.findUserById(id); }
    public void delete(User user) {  userDAO.delete(user); }

    public Boolean checkUsername(LoginTemplate loginTemplate) {
        User u = userDAO.findByUsername(loginTemplate.getUserName());

        if(u == null) {
            return false;
        } else {
            return true;
        }
    }

    public User findByUserName(LoginTemplate loginTemplate){
        return userDAO.findByUsername(loginTemplate.getUserName());
    }

}