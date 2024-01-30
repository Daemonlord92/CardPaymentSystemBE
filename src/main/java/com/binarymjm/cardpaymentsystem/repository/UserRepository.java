package com.binarymjm.cardpaymentsystem.repository;

import com.binarymjm.cardpaymentsystem.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
