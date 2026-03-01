    package school.sptech.projetoindividual.DTO;

    import java.time.LocalDateTime;

    public record TarefaResponseDTO(
            Long id,
            String titulo,
            String descricao,
            String status,
            Integer prioridade,
            LocalDateTime dataCriacao
    ) {}