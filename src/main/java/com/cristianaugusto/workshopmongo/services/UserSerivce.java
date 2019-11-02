package com.cristianaugusto.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianaugusto.workshopmongo.domain.User;
import com.cristianaugusto.workshopmongo.repository.UserRepository;

@Service
public class UserSerivce {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
