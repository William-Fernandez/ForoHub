package com.williamfernandez.foro_hub.controller;

import com.williamfernandez.foro_hub.model.Topico;
import com.williamfernandez.foro_hub.service.TopicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@Validated
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    // Crear tópico (POST)
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        Topico creado = service.crearTopico(topico);
        return ResponseEntity.ok(creado);
    }

    // Listar todos los tópicos (GET)
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = service.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/paged")
    public Page<Topico> listarTopicosPaginados(@PageableDefault(size = 10) Pageable pageable) {
        return service.listarTopicos(pageable);
    }

    // Obtener un tópico por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un tópico completamente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        return service.actualizarTopico(id, topico)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualización parcial (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Topico> actualizarParcialTopico(@PathVariable Long id, @RequestBody Topico topico) {
        return service.actualizarParcialTopico(id, topico)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un tópico (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        service.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}