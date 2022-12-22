package com.internetlove.cats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internetlove.cats.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

}
