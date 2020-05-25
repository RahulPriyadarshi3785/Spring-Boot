package com.starter.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.starter.demo.model.Client;

@Service
public interface ClientService {

	public List<Client> getAllClients();
	
}
