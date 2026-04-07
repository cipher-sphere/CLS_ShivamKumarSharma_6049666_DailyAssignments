package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Myusers {
	@Id
   private 	String username;
   private String password;
   private String role;
   public String getUsername() {
	return username;
}
   public void setUsername(String username) {
	this.username = username;
   }
   public String getPassword() {
	return password;
   }
   public void setPassword(String password) {
	this.password = password;
   }
   public String getRole() {
	return role;
   }
   public void setRole(String role) {
	this.role = role;
   }
   public boolean isActive() {
	return active;
   }
   public void setActive(boolean active) {
	this.active = active;
   }
   private boolean active;
}
