package com.aston.esport_equipes.Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collection = "equipe")
public class Team {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String tag;
    private List<String> membres;
}
