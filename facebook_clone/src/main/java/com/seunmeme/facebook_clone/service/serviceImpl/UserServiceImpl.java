package com.seunmeme.facebook_clone.service.serviceImpl;

import com.seunmeme.facebook_clone.model.User;
import com.seunmeme.facebook_clone.repository.UserRepository;
import com.seunmeme.facebook_clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String register() {
        return "null";
    }
}
