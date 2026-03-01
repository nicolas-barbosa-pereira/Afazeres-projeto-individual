package school.sptech.projetoindividual.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetoindividual.DTO.TarefaRequestDTO;
import school.sptech.projetoindividual.DTO.TarefaResponseDTO;
import school.sptech.projetoindividual.Repository.TarefaRepository;
import school.sptech.projetoindividual.enums.StatusTarefa;
import school.sptech.projetoindividual.model.TarefaModel;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repo;

    public TarefaService(TarefaRepository repo) {
        this.repo = repo;
    }

    public List<TarefaResponseDTO> buscarTarefas(Long idUsuario) {
        if (!repo.verificarSeExiste(idUsuario)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID de usuário inválido");
        }
        return repo.buscarPorUsuario(idUsuario).stream()
                .map(this::mapToResponse).toList();
    }

    public TarefaResponseDTO salvar(TarefaRequestDTO t) {
        if (!repo.verificarSeExiste(t.fkUsuario())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existe");
        }
        TarefaModel tarefa = new TarefaModel();
        tarefa.setTitulo(t.titulo());
        tarefa.setDescricao(t.descricao());
        tarefa.setPrioridade(t.prioridade());
        tarefa.setStatus(StatusTarefa.PENDENTE);
        tarefa.setFkUsuario(t.fkUsuario());

        repo.salvar(tarefa);

        List<TarefaModel> lista = repo.buscarPorUsuario(t.fkUsuario());
        return mapToResponse(lista.get(lista.size() - 1));
    }

    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO t) {
        if (!repo.tarefaExiste(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }
        TarefaModel tarefa = repo.buscarPorId(id);
        tarefa.setTitulo(t.titulo());
        tarefa.setDescricao(t.descricao());
        tarefa.setPrioridade(t.prioridade());
        tarefa.setStatus(t.status());

        repo.atualizar(id, tarefa);
        return mapToResponse(repo.buscarPorId(id));
    }

    public void deletar(Long id) {
        if (!repo.tarefaExiste(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repo.deletar(id);
    }

    private TarefaResponseDTO mapToResponse(TarefaModel t) {
        return new TarefaResponseDTO(
                t.getId(), t.getTitulo(), t.getDescricao(),
                t.getStatus().name(), t.getPrioridade(), t.getDataCriacao()
        );
    }
}