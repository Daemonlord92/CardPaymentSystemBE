package com.binarymjm.cardpaymentsystem.service;

import com.binarymjm.cardpaymentsystem.dto.PostNewUser;
import com.binarymjm.cardpaymentsystem.dto.PostUpdateUser;
import com.binarymjm.cardpaymentsystem.dto.UserInfo;
import com.binarymjm.cardpaymentsystem.shared.MessageResponse;

import java.util.List;

public interface UserService {
    MessageResponse createUser(PostNewUser postNewUser);
    MessageResponse updateUser(PostUpdateUser postUpdateUser);
    List<UserInfo> getAllUsers();
    UserInfo getUser(Long id);
    MessageResponse deleteUser(Long id);
}
