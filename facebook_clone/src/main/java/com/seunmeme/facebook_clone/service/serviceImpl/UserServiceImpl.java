package com.seunmeme.facebook_clone.service.serviceImpl;

import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.repository.UserRepository;
import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
