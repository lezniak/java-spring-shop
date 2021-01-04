package com.example.shop.respositories;

import com.example.shop.object.User;
import org.springframework.data.repository.CrudRepository;

import com.example.shop.object.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}