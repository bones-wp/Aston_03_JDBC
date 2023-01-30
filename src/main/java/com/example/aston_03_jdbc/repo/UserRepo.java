package com.example.aston_03_jdbc.repo;


import com.example.aston_03_jdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, Long> {
}
