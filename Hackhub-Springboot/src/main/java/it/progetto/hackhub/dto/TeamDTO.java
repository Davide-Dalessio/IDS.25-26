package it.progetto.hackhub.dto;

import it.progetto.hackhub.model.Utente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    private int id;
    private String nome;
    private List<Utente> membri;
}
