package com.example.rec.repository;

import com.example.rec.entity.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BranchRepository extends MongoRepository<Branch, UUID> {
}
