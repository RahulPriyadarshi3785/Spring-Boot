package com.starter.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.starter.demo.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Integer> {

}