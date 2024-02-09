package com.uma.linkdlen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.linkdlen.entity.Connections;
import com.uma.linkdlen.repo.ConnectionRepository;

@RestController
@RequestMapping("/user")
public class ConnectionController {

	@Autowired
	private ConnectionRepository connectionRepository;
	
	@PostMapping("/new/connection")
	public Connections newUser(@RequestBody Connections newUser) {
		return connectionRepository.save(newUser);
	}

	@GetMapping("/connections")
	public List<Connections> getAllUsers() {
		return connectionRepository.findAll();
	}

	
	@GetMapping("/connection/{id}")
	
	 public Optional<Connections> getUserByabout(@PathVariable Long id) {
		return connectionRepository.findById(id);
	}
	
	@PutMapping("/connection/{id}")
	String updateUser(@RequestBody Connections newUser, @PathVariable Long id) {
		Connections user =connectionRepository.findById(id).get();
			user.setName(newUser.getName());
			user.setDestination(newUser.getDestination());
			user.setLocation(newUser.getLocation());
			user.setTotalConnections(newUser.getTotalConnections());
		
			 connectionRepository.save(user);
		return "updated..";
	}

	@DeleteMapping("/connection/delete/{id}")
	String deleteUser(@PathVariable Long id) {
		connectionRepository.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}
	@GetMapping("/connection")
public String getPage() {
		return "Welcome...";
}
	
}

