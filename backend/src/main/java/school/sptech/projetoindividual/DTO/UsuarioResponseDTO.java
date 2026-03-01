package school.sptech.projetoindividual.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public record UsuarioResponseDTO(
        long id,
        String nome,
        String email,
        String corDosOlhos,
        char sexo,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dtNascimento,
        String escolaridade
) {}
