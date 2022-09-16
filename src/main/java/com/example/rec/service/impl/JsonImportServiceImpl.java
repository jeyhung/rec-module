package com.example.rec.service.impl;

import com.example.rec.service.JsonImportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonImportServiceImpl implements JsonImportService {
    private final String FILE_BASE_URL = "classpath:";
    private final MongoTemplate mongoTemplate;

    public JsonImportServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void importJsons() {
        mongoTemplate.getCollection("branches")
                .insertMany(generateDocs("branches.json", null));

        mongoTemplate.getCollection("regions")
                .insertMany(generateDocs("region.json", null));

        mongoTemplate.getCollection("group_cedants")
                .insertMany(generateDocs("groups_cedants.json", null));

        mongoTemplate.getCollection("cedants")
                .insertMany(generateDocs("cedants.json", null));

        mongoTemplate.getCollection("countries")
                .insertMany(generateDocs("countries.json", null));

        mongoTemplate.getCollection("case_not_life_premiums")
                .insertMany(generateDocs("case_not_life_premium.json", null));

        mongoTemplate.getCollection("slips_premiums")
                .insertMany(generateDocs("slips_premium.json", null));
    }

    private <T> List<Document> generateDocs(String fileName, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        List<Document> docs = new ArrayList<>();

        try {
            File file = ResourceUtils.getFile(FILE_BASE_URL + fileName);
            String jsonLines = new String(Files.readAllBytes(Path.of(file.getPath())));
            JSONArray jsonArray = new JSONArray(jsonLines);

            for (int i = 0; i < jsonArray.length(); i++) {
                String jsonLine = jsonArray.getJSONObject(i).toString();

                if (type != null) {
                    T v = mapper.readValue(jsonLine, type);
                    jsonLine = mapper.writeValueAsString(v);
                }
                docs.add(Document.parse(jsonLine));
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

        return docs;
    }
}
