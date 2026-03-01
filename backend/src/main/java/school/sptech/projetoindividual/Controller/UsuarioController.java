package school.sptech.projetoindividual.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoindividual.DTO.LoginRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioResponseDTO;
import school.sptech.projetoindividual.Service.UsuarioService;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;
    String[] escolaridades={"Ensino Fundamental incompleto",
            "Ensino Fundamental completo",
            "Ensino Médio incompleto",
            "Ensino Médio completo",
            "Ensino Técnico",
            "Ensino Superior incompleto",
            "Ensino Superior completo",
            "Pós-graduação"};

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/escolaridades")
    public ResponseEntity<String[]> getEscolaridades() {
        return ResponseEntity.status(200).body(escolaridades);
    }




    @PostMapping
    public ResponseEntity<String> criar(@RequestBody UsuarioRequestDTO req){
        if (req.nome() == null || req.nome().isBlank()) {
            return ResponseEntity.status(400).body("Erro: O nome não pode estar vazio.");
        }

        if (req.email() == null || !req.email().contains("@")) {
            return ResponseEntity.status(400).body("Erro: Formato de e-mail inválido.");
        }

        if (req.senha() == null || req.senha().length() < 6) {
            return ResponseEntity.status(400).body("Erro: A senha deve ter pelo menos 6 caracteres.");
        }
        boolean escolaridadeValida = Arrays.asList(escolaridades).contains(req.escolaridade());
        if (!escolaridadeValida) {
            return ResponseEntity.status(400).body("Erro: Escolaridade inválida.");
        }
        service.cadastrar(req);
        return ResponseEntity.status(201).body("usuario cadastrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginRequestDTO login){
        var usuario = service.autenticar(login);
        return ResponseEntity.status(200).body(usuario);
    }
}
