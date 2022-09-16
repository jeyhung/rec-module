package com.example.rec.migration;

import com.example.rec.service.JsonImportService;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog(order = "001")
public class InitChangeLog {
    @ChangeSet(order = "001", id = "init_data", author = "jeyhung")
    public void init(JsonImportService jsonImportService) {
        jsonImportService.importJsons();
    }
}
