package com.example.rec.repository;

import com.example.rec.entity.Cedant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CedantRepository extends MongoRepository<Cedant, UUID> {
}
