package com.List.ToDo.controller;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.service.TarefaService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<?> criarTarefa(@PathVariable Long id, @Valid @RequestBody TarefaDto dto){
        Tarefa tarefa = tarefaService.criarTarefa(id, dto);
        if (tarefa == null) {
            return ResponseEntity.status(404).body("Usuario não encontrado");
        }
        return ResponseEntity.ok(tarefa);
    }

    @GetMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<?> listarPorUsuario(@PathVariable Long id) {
        List<Tarefa> tarefas = tarefaService.listarPorUsuario(id);
        if (tarefas == null) {
            return ResponseEntity.status(404).body("Usuario não encontrado");
        }
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        boolean deletada = tarefaService.deletarTarefa(id);
        if (!deletada) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }
        return ResponseEntity.ok("Tarefa deletada com sucesso");
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody TarefaDto dto) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);

        if (tarefaAtualizada == null) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }

        return ResponseEntity.ok(tarefaAtualizada);
    }

}
