package com.anilized.fullstackrest.service;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anilized.fullstackrest.dao.UserDao;
import com.anilized.fullstackrest.entity.UserEntity;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao dao;
	
	public List<UserEntity> listAll(){
		return dao.findAll();
	}
	
	public UserEntity saveUser(UserEntity user) {
		UserEntity u = dao.save(user);
		System.out.println(u);
		return u;
	}
	
	public UserEntity getUser(Long id) {
		return dao.getById(id);
	}
	
	public void deleteUser(Long id) {
		dao.deleteById(id);
	}
	
	public void registerUser(String username, String email, String password, String passwordConfirm) throws Exception {
		if(password.equals(passwordConfirm)) {
			dao.save(new UserEntity(username, email, password));
		} else {
			throw new IllegalArgumentException("Passwords does not match!");
		}
	}

}
