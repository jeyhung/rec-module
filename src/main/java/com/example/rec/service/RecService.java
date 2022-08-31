package com.example.rec.service;

import com.example.rec.dto.RecDto;
import com.example.rec.dto.RecFilterDto;

import java.util.List;

public interface RecService {
    List<RecDto> getAll(RecFilterDto recFilterDto);
}
