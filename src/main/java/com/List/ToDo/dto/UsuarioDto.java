package com.List.ToDo.dto;

import com.List.ToDo.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {


    @NotBlank(message = "Digite um nome válido")
    private String nome;


    private String email;


    private String senha;

    public  UsuarioDto(){

    }

    public UsuarioDto(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
    }

    public UsuarioDto( String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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
}
