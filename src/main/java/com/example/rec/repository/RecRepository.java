package com.example.rec.repository;

import com.example.rec.entity.Rec;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecRepository extends MongoRepository<Rec, String> {
    @Query(value = "db.case_not_life_premiums.aggregate([ " +
            "    { " +
            "        $lookup: { " +
            "            from: \"branches\", " +
            "            localField: \"branches_id\", " +
            "            foreignField: \"_id\", " +
            "            as: \"branch\" " +
            "        }, " +
            "        $lookup: { " +
            "            from: \"cedants\", " +
            "            localField: \"cedants_id\", " +
            "            foreignField: \"_id\", " +
            "            as: \"cedant\" " +
            "        } " +
            "    } " +
            "]);", fields = "{'branch': 0, 'cedant': 1}")
    List<Rec> findAll();

    @Query(value = "db.branches.count({name: 'AUTOMOBILE'})")
    long count();
}
