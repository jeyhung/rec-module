package com.example.rec.service.impl;

import com.example.rec.dto.RecDto;
import com.example.rec.dto.RecFilterDto;
import com.example.rec.entity.Rec;
import com.example.rec.repository.RecRepository;
import com.example.rec.service.RecService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecServiceImpl implements RecService {
    private final RecRepository recRepository;

    public RecServiceImpl(RecRepository recRepository) {
        this.recRepository = recRepository;
    }

    @Override
    public List<RecDto> getAll(RecFilterDto recFilterDto) {
        //recRepository.count();
        List<Rec> recs = recRepository.findAll();
        return new ArrayList<>();
    }
}