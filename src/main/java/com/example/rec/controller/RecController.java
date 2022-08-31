package com.example.rec.controller;

import com.example.rec.dto.RecDto;
import com.example.rec.dto.RecFilterDto;
import com.example.rec.service.RecService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "rec")
@RestController
@RequestMapping(value = "/rec")
public class RecController {
    private final RecService recService;

    public RecController(RecService recService) {
        this.recService = recService;
    }

    @GetMapping(path = "/get-all")
    public List<RecDto> getAll(RecFilterDto recFilterDto) {
        return recService.getAll(recFilterDto);
    }
}
