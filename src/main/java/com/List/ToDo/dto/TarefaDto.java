package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TarefaDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    public TarefaDto() {

    }

    public TarefaDto(LocalDate dtFim, LocalDate dtInicio, Status status, String descricao, String nome) {
        this.dtFim = dtFim;
        this.dtInicio = dtInicio;
        this.status = status;
        this.descricao = descricao;
        this.nome = nome;
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
}
