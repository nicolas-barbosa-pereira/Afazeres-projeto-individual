package school.sptech.projetoindividual.Repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.sptech.projetoindividual.model.TarefaModel;

import java.util.List;

@Repository
public class TarefaRepository {

    private final JdbcTemplate jdbcTemplate;

    public TarefaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TarefaModel> buscarPorUsuario(Long idUsuario) {
        String sql = "SELECT * FROM tarefa WHERE fk_usuario = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TarefaModel.class), idUsuario);
    }

    public void salvar(TarefaModel t) {
        String sql = "INSERT INTO tarefa(titulo, descricao, prioridade, status, fk_usuario) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, t.getTitulo(), t.getDescricao(), t.getPrioridade(), t.getStatus().name(), t.getFkUsuario());
    }

    public TarefaModel buscarPorId(Long id) {
        String sql = "SELECT * FROM tarefa WHERE id = ?";
        List<TarefaModel> tarefas = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TarefaModel.class), id);
        return tarefas.isEmpty() ? null : tarefas.get(0);
    }

    public void atualizar(Long id, TarefaModel t) {
        String sql = "UPDATE tarefa SET titulo = ?, descricao = ?, prioridade = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, t.getTitulo(), t.getDescricao(), t.getPrioridade(), t.getStatus().name(), id);
    }

    public void deletar(Long id) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public boolean verificarSeExiste(Long id) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE id = ?";
        Integer quantidade = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return quantidade != null && quantidade > 0;
    }

    public boolean tarefaExiste(Long id) {
        String sql = "SELECT COUNT(*) FROM tarefa WHERE id = ?";
        Integer quantidade = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return quantidade != null && quantidade > 0;
    }
}