package com.example.rec.entity;

import com.example.rec.constant.BranchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "branches")
public class Branch {
    @Id
    private String id;
    private String parentId;
    private String code;
    private String name;
    private int status;
    private BranchType type;
    private List<String> alias;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
