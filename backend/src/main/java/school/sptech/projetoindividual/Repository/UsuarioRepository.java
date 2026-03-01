package school.sptech.projetoindividual.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import school.sptech.projetoindividual.model.UsuarioModel;

@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public UsuarioRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void salvar(UsuarioModel usuario){
        String sql= "INSERT INTO usuario(nome, email, senha, cor_dos_olhos,sexo,dt_nascimento,escolaridade) VALUES(?,?,?,?,?,?,?)";
        jdbc.update(sql, usuario.getNome(),usuario.getEmail(),usuario.getSenha(),usuario.getCorDosOlhos(),String.valueOf(usuario.getSexo()),usuario.getDtNascimento(),usuario.getEscolaridade());
    }

    public boolean existePorEmail(String email){
        String sql= "SELECT COUNT(*) FROM usuario where email = ?";
        Integer count= jdbc.queryForObject(sql,Integer.class,email);
        return count!=null&&count>0;
    }

    public UsuarioModel existeEmailSenha(String email, String senha){
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";

        try{
            return jdbc.queryForObject(sql, (rs, rowNum) -> {
                UsuarioModel user = new UsuarioModel();
                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setCorDosOlhos(rs.getString("cor_dos_olhos"));
                user.setSexo(rs.getString("sexo").charAt(0));
                user.setDtNascimento(rs.getDate("dt_nascimento").toLocalDate());                user.setEscolaridade(rs.getString("escolaridade"));
                return user;
            }, email,senha);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
