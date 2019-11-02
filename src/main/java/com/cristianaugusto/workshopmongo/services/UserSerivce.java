package com.cristianaugusto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianaugusto.workshopmongo.domain.User;
import com.cristianaugusto.workshopmongo.dto.UserDTO;
import com.cristianaugusto.workshopmongo.repository.UserRepository;
import com.cristianaugusto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserSerivce {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isPresent()) {
			return user.get();	
		}
		throw new ObjectNotFoundException("Objeto não encontrado");
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
