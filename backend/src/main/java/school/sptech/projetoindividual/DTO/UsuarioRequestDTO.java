package school.sptech.projetoindividual.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        String corDosOlhos,
        char sexo,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dtNascimento,
        String escolaridade
) {}