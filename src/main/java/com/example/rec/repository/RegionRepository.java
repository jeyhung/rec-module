package com.example.rec.repository;

import com.example.rec.entity.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RegionRepository extends MongoRepository<Region, UUID> {
}
