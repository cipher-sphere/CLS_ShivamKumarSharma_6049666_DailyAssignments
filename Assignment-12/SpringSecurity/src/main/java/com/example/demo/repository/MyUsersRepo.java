package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Myusers;

public interface MyUsersRepo extends JpaRepository<Myusers,String> {
 
}
