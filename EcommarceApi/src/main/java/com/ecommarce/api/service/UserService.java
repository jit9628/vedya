package com.ecommarce.api.service;

import com.ecommarce.api.entity.User;

public interface UserService{

public User getAllUser();

public String forgotPassword(String email);
public String resetPassword(String token, String password);
}
