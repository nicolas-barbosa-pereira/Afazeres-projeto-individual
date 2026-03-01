package school.sptech.projetoindividual.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public class UsuarioModel {
    private long id;
    private String nome, email, senha, corDosOlhos;
    private char sexo;
    @JsonFormat(pattern = "yyyy-MM-dd ")
    private LocalDate dtNascimento;
    private String escolaridade;



    public UsuarioModel() {
    }

    public UsuarioModel(long id, String nome, String email, String senha, String corDosOlhos, char sexo, LocalDate dtNascimento, String escolaridade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.corDosOlhos = corDosOlhos;
        this.sexo = sexo;
        this.dtNascimento = dtNascimento;
        this.escolaridade = escolaridade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }



}
