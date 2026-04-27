package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitoRequest {
    private int mittenteID;
    private int utenteID;
}
