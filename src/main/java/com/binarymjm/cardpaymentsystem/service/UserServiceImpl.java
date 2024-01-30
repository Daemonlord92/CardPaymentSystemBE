package com.binarymjm.cardpaymentsystem.service;

import com.binarymjm.cardpaymentsystem.dto.PostNewUser;
import com.binarymjm.cardpaymentsystem.dto.PostUpdateUser;
import com.binarymjm.cardpaymentsystem.dto.UserInfo;
import com.binarymjm.cardpaymentsystem.entity.User;
import com.binarymjm.cardpaymentsystem.repository.UserRepository;
import com.binarymjm.cardpaymentsystem.shared.MessageResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MessageResponse createUser(PostNewUser postNewUser) {
        User user = new User();
        user.setId(new Random().nextLong(900000));
        user.setUsername(postNewUser.username());
        user.setPassword(postNewUser.password());
        userRepository.insert(user);
        return new MessageResponse("User Created");
    }

    @Override
    public MessageResponse updateUser(PostUpdateUser postUpdateUser) {
        User user = userRepository.findById(postUpdateUser.id()).orElseThrow();
        if(!user.getUsername().equals(postUpdateUser.username())) user.setUsername(postUpdateUser.username());
        if(!user.getPassword().equals(postUpdateUser.password())) user.setPassword(postUpdateUser.password());
        userRepository.insert(user);
        return new MessageResponse("User Updated");
    }

    @Override
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll().stream().map(x ->
                new UserInfo(
                        x.getId(),
                        x.getUsername()
                )
                ).toList();
    }

    @Override
    public UserInfo getUser(Long id) {
        return userRepository.findById(id).map(x ->
                new UserInfo(
                        x.getId(),
                        x.getUsername()
                )
                ).orElseThrow();
    }

    @Override
    public MessageResponse deleteUser(Long id) {
        userRepository.deleteById(id);
        return new MessageResponse("User Deleted");
    }
}
