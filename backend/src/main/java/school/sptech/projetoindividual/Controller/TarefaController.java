package school.sptech.projetoindividual.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoindividual.DTO.TarefaRequestDTO;
import school.sptech.projetoindividual.DTO.TarefaResponseDTO;
import school.sptech.projetoindividual.Service.TarefaService;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefasPorId(@RequestParam long id) {
        return ResponseEntity.status(200).body(service.buscarTarefas(id));
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> cadastrar(@RequestBody TarefaRequestDTO t) {
        if (validar(t)) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(service.salvar(t));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @RequestBody TarefaRequestDTO t) {
        if (validar(t)) return ResponseEntity.badRequest().build();
        return ResponseEntity.status(200).body(service.atualizar(id, t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(204).build();
    }

    private boolean validar(TarefaRequestDTO t) {
        return t.titulo() == null || t.titulo().isBlank() || t.prioridade() == null || t.prioridade() < 1 || t.prioridade() > 3;
    }
}