package com.example.rec.repository;

import com.example.rec.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CountryRepository extends MongoRepository<Country, UUID> {

}