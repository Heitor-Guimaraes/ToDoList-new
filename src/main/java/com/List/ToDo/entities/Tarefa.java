package com.List.ToDo.entities;

import jakarta.persistence.*;
import com.List.ToDo.dto.TarefaDto;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

//    public Tarefa(long id, String nome, String descricao, Status status, LocalDate dtInicio, LocalDate dtFim) {
//        this.id = id;
//        this.nome = nome;
//        this.descricao = descricao;
//        this.status = status;
//        this.dtInicio = dtInicio;
//        this.dtFim = dtFim;
//    }
//
//    public Tarefa(LocalDate dtFim, LocalDate dtInicio, Status status, String descricao, String nome) {
//        this.dtFim = dtFim;
//        this.dtInicio = dtInicio;
//        this.status = status;
//        this.descricao = descricao;
//        this.nome = nome;
//    }

    public Tarefa(TarefaDto dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.dtInicio = LocalDate.now();
        this.dtFim = dto.getDtFim();
    }

    public Tarefa(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
