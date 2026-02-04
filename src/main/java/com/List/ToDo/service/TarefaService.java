package com.List.ToDo.service;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.TarefaRepository;
import com.List.ToDo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Tarefa criarTarefa(Long usuarioId, TarefaDto dto){
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        if (usuario == null) {
            return null;
        }
        Tarefa task = new Tarefa(dto);
        task.setUsuario(usuario);
        tarefaRepository.save(task);
        return task;
    }

    public List<Tarefa> listarPorUsuario(Long usuarioId) {
        if (!usuarioRepository.existsById(usuarioId)) {
            return null;
        }
        return tarefaRepository.findByUsuarioId(usuarioId);
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }


    public Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }


    public Tarefa atualizarTarefa(Long id, TarefaDto dto) {

        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

        if (tarefa == null) {
            return null;
        }
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDtFim(dto.getDtFim());
        return tarefaRepository.save(tarefa);
    }



}
