package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SottomissioneRequest {
    private int teamId;
    private int hackathonId;
    private String link;
}
