package com.example.Connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Connect4.dto.Connect4DTO;
import com.example.Connect4.service.Connect4Service;

@Controller
@CrossOrigin(origins = "*")
public class Connect4Controller {
	@Autowired
	public Connect4Service connect4Service;
	
	@GetMapping("/get/connect4")
	public ResponseEntity<Connect4DTO> get()
	{
		return ResponseEntity.ok(connect4Service.get());
	}
	
	@PostMapping("/reset")
	public ResponseEntity<Connect4DTO> reset()
	{
		connect4Service.reset();
		return ResponseEntity.ok(connect4Service.get());
	}
	
	@PostMapping("/run/row/{row}/col/{col}")
	public ResponseEntity<Connect4DTO> run(@PathVariable int row, @PathVariable int col)
	{
		connect4Service.run(row, col);
		return ResponseEntity.ok(connect4Service.get());
	}
}
