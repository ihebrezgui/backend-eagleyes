package com.telcotec.eagleye.dao.repository;

import com.telcotec.eagleye.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserName(String userName);
}
