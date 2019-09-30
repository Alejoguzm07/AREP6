package edu.eci.arep.subjects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arep.subjects.repository.Repository;

@RestController
@RequestMapping(value = "/subjects")
public class Controller {

	@Autowired
	Repository repository;
	
	@GetMapping()
	public ResponseEntity<?> getAllSubjects(){
	    try {
	        return new ResponseEntity<>(repository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
	    }
    }
}