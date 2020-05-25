package com.starter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.demo.model.Client;
import com.starter.demo.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients() {
		return ResponseEntity.ok(clientService.getAllClients());
	}
}
