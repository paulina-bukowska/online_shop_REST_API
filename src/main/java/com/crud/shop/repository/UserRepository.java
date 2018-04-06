package com.crud.shop.repository;

import com.crud.shop.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    User findOne(Integer integer);
}