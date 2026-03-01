package school.sptech.projetoindividual.DTO;

public record UsuarioRequestDTO(String nome, String email, String senha) {}
public record UsuarioResponseDTO(Long id, String nome, String email) {}