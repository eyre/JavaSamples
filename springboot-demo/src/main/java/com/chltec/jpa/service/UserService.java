package com.chltec.jpa.service;

import com.chltec.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author joker
 * Created on 2017/11/21.
 * Description
 */
public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User getUser(Long userId);

    List<User> getUsers();

    Page<User> getUsersWithPage(Integer page, Integer per_page);
}
