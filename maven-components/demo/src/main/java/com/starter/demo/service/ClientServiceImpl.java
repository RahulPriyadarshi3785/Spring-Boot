package com.starter.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.demo.model.Client;
import com.starter.demo.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository; 
	
	@Override
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
}
