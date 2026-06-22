package com.example.Backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doc {
    @Id
    private String id;

    @NotBlank(message="User ID is needed")
    @Field("userId")
    private String userId;

    @NotBlank(message = "Please give a document title")
    @Field("title")
    private String title;

    @NotBlank(message = "Filename is needed")
    @Field("filename")
    private String filename;

    @NotBlank(message = "filepath is needed")
    @Field("filepath")
    private String filepath;

    @NotBlank(message = "filesize is needed")
    @Positive(message="Always positive")
    @Field("filesize")
    private Long filesize;

    @Field("extrectedText")
    @Builder.Default
    private String extrectedText="";


}
