package com.example.rec.service;

import com.example.rec.dto.RecDto;
import com.example.rec.dto.RecFilterDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecServiceImpl implements RecService {
    @Override
    public List<RecDto> getAll(RecFilterDto recFilterDto) {
        return new ArrayList<>();
    }
}