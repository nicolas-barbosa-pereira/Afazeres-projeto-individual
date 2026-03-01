package school.sptech.projetoindividual.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projetoindividual.DTO.LoginRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioRequestDTO;
import school.sptech.projetoindividual.DTO.UsuarioResponseDTO;
import school.sptech.projetoindividual.Service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final UsuarioService service;
    String[] escolaridades={"Ensino Fundamental incompleto",
            "Ensino Fundamental completo",
            "Ensino Médio incompleto",
            "Ensino Médio completo",
            "Ensino Técnico",
            "Ensino Superior incompleto",
            "Ensino Superior completo",
            "Pós-graduação"};

    public UserController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<String> criar(@RequestBody UsuarioRequestDTO req){
        service.cadastrar(req);
        return ResponseEntity.status(201).body("usuario cadastrado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginRequestDTO login){
        var usuario = service.autenticar(login);
        return ResponseEntity.status(200).body(usuario);
    }
}
