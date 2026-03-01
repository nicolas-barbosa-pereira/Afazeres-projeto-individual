package school.sptech.projetoindividual.model;

import school.sptech.projetoindividual.enums.StatusTarefa;

import java.time.LocalDateTime;

public class TarefaModel {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer prioridade;
    private StatusTarefa status;
    private LocalDateTime dataCriacao;
   // private LocalDateTime dataConclusao;
    private Long fkUsuario;

    public TarefaModel() {
    }

    public TarefaModel(Long id, String titulo, String descricao, Integer prioridade, StatusTarefa status, LocalDateTime dataCriacao, LocalDateTime dataConclusao, Long fkUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataCriacao = dataCriacao;
        //this.dataConclusao = dataConclusao;
        this.fkUsuario = fkUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
/*
    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
*/
    public Long getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Long fkUsuario) {
        this.fkUsuario = fkUsuario;
    }
}
