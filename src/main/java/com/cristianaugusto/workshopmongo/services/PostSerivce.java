package com.cristianaugusto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristianaugusto.workshopmongo.domain.Post;
import com.cristianaugusto.workshopmongo.repository.PostRepository;
import com.cristianaugusto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostSerivce {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post.isPresent()) {
			return post.get();	
		}
		throw new ObjectNotFoundException("Objeto não encontrado");
	}
	
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	
}
