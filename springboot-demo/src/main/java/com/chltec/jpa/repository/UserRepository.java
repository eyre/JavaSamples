package com.chltec.jpa.repository;

import com.chltec.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author joker
 * Created on 2017/11/21.
 * Description
 */
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByPhoneNumberStartingWith(String phone_start);
    List<User> findByNameContaining(String keywords);
    List<User> findByNameIsNotNullOrderByPhoneNumberDesc();
//    List<User> findByNameIsNotNull(Sort sort);
    Page<User> findByNameIsNotNull(Pageable pageable);
}
