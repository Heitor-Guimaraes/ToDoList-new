package com.List.ToDo.service;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto criarUsuario(UsuarioDto dto){
        Usuario user = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        usuarioRepository.save(user);
        return dto;
    }

    public List<UsuarioDto> listarUsuario(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }

    public UsuarioDto buscarPorId(Long id) {
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(id);
        return usuarioExiste.map(UsuarioDto::new).orElse(null);
    }

    public String deletar(Long id) {

        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Excluído com sucesso!";
        } else {
            return "Esse ID não existe";
        }
    }

    public String atualizar(Long id) {

        Optional<Usuario> UsuarioExiste = usuarioRepository.findById(id);
        if (UsuarioExiste.isPresent()) {
            Usuario usuario = UsuarioExiste.get();
            usuario.setNome(usuario.getNome());
            usuario.setSenha(usuario.getSenha());
            usuarioRepository.save(usuario);
            UsuarioDto teste = new UsuarioDto(usuario);
            return "Usuario atualizado";
        } else {
            return "Esse ID não existe";
        }
    }
}
