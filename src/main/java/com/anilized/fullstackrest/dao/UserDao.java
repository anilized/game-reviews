package com.anilized.fullstackrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anilized.fullstackrest.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>{

}
