package school.sptech.projetoindividual.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoindividual.DTO.LoginRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioResponseDTO;
import school.sptech.projetoindividual.Repository.UsuarioRepository;
import school.sptech.projetoindividual.model.UsuarioModel;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(UsuarioRequestDTO dados){
            if(repo.existePorEmail(dados.email())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
            }

        UsuarioModel user = new UsuarioModel();
        user.setNome(dados.nome());
        user.setEmail(dados.email());
        user.setSenha(dados.senha());
        user.setCorDosOlhos(dados.corDosOlhos());
        user.setSexo(dados.sexo());
        user.setDtNascimento(dados.dtNascimento());
        user.setEscolaridade(dados.escolaridade());
        repo.salvar(user);
    }


    public UsuarioResponseDTO autenticar(LoginRequestDTO dados){
        UsuarioModel user= repo.existeEmailSenha(dados.email(), dados.senha());
                if(user ==null){
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos");
                }

                return new UsuarioResponseDTO(
                        user.getId(),
                        user.getNome(),
                        user.getEmail(),
                        user.getCorDosOlhos(),
                        user.getSexo(),
                        user.getDtNascimento(),
                        user.getEscolaridade()
                );
    }
}
