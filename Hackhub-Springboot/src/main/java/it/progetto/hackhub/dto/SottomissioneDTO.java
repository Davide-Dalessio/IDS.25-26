package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SottomissioneDTO {
    private int sottomissioneId;
    private int teamId;
    private int hackathonId;
    private String link;
}
