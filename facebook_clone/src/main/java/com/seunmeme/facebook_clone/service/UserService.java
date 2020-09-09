package com.seunmeme.facebook_clone.service;

import com.seunmeme.facebook_clone.model.User;

public interface UserService {
    public void register(User user);
    public User findByEmail(String email);

}
