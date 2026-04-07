package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class SecuredController {
	
	 
      @GetMapping("/publicEndPoint")
      public String forPublic() {
    	  return "This is the Open Endpoint for public";
      }
      @GetMapping("/securedUserEndPoint")
      @PreAuthorize("hasAnyRole('USER','ADMIN')")
      public String forUsers() {
    	  return "This is the secured Endpoint for users only";
      }
      @GetMapping("/securedAdminEndPoint")
      @PreAuthorize("hasRole('ADMIN')")
      public String forAdmin() {
    	  return "This is the secured Endpoint for Admin only";
      }
}
