package school.sptech.projetoindividual.DTO;

import school.sptech.projetoindividual.enums.StatusTarefa;

public record TarefaRequestDTO(
        String titulo,
        String descricao,
        Integer prioridade,
        StatusTarefa status,
        long fkUsuario
        ) {
}
