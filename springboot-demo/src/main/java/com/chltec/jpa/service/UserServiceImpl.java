package com.chltec.jpa.service;

import com.alibaba.fastjson.annotation.JSONField;
import com.chltec.jpa.model.User;
import com.chltec.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author joker
 * Created on 2017/11/21.
 * Description
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        User userUpdate = userRepository.findOne(user.getId());
        if(userUpdate == null){
           userUpdate = userRepository.save(user);
        }else{
            update(userUpdate, user);

            userRepository.save(userUpdate);
        }
        return userUpdate;
    }

    private Object update(Object original, Object updated) {
        Field[] fields = original.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object fieldValue = field.get(updated);
                if(fieldValue != null) {
                    field.set(original, fieldValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return original;
    }

    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }

    public User getUser(Long userId){
        return userRepository.findOne(userId);
    }

    public List<User> getUsers(){
        List<User> userList = userRepository.findByPhoneNumberStartingWith("159");
        List<User> userList2 = userRepository.findByNameContaining("joker");
        List<User> userList3 = userRepository.findByNameIsNotNullOrderByPhoneNumberDesc();
        System.out.println(userList);
        System.out.println(userList2);
        System.out.println(userList3);

        return userRepository.findAll();
    }

    @Override
    public Page<User> getUsersWithPage(Integer page, Integer per_page) {
        return userRepository.findByNameIsNotNull(new PageRequest(page, per_page));
    }
}
