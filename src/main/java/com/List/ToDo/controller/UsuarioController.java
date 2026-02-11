package com.List.ToDo.controller;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("criar")
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDto dto) {

        return ResponseEntity.ok(usuarioService.criarUsuario(dto));

    }

    @GetMapping("list")
    public ResponseEntity<?> listarUsuario() {
        return ResponseEntity.ok(usuarioService.listarUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        UsuarioDto usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuario não encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deletado = usuarioService.deletar(id);
        if (!deletado) {
            return ResponseEntity.status(404).body("Usuario não encontrado");
        }
        return ResponseEntity.ok("Excluído com sucesso!");
    }
}
