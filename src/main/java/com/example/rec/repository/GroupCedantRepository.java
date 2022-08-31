package com.example.rec.repository;

import com.example.rec.entity.GroupCedant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GroupCedantRepository extends MongoRepository<GroupCedant, UUID> {
}
