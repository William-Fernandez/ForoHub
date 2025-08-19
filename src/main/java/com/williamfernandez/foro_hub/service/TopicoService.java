package com.williamfernandez.foro_hub.service;

import com.williamfernandez.foro_hub.model.Topico;
import com.williamfernandez.foro_hub.repository.TopicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public Topico crearTopico(Topico topico) {
        if (topicoRepository.existsByTituloAndMensaje(topico.getTitulo(), topico.getMensaje())) {
            throw new RuntimeException("Ya existe un tópico con el mismo título y mensaje");
        }
        return topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Page<Topico> listarTopicos(Pageable pageable) {
        return topicoRepository.findAll(pageable);
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Optional<Topico> actualizarTopico(Long id, Topico topicoActualizado) {
        return topicoRepository.findById(id).map(topico -> {
            topico.setTitulo(topicoActualizado.getTitulo());
            topico.setMensaje(topicoActualizado.getMensaje());
            topico.setStatus(topicoActualizado.getStatus());
            topico.setAutor(topicoActualizado.getAutor());
            topico.setCurso(topicoActualizado.getCurso());
            return topicoRepository.save(topico);
        });
    }

    public Optional<Topico> actualizarParcialTopico(Long id, Topico topicoParcial) {
        return topicoRepository.findById(id).map(topico -> {
            if (topicoParcial.getTitulo() != null) topico.setTitulo(topicoParcial.getTitulo());
            if (topicoParcial.getMensaje() != null) topico.setMensaje(topicoParcial.getMensaje());
            if (topicoParcial.getStatus() != null) topico.setStatus(topicoParcial.getStatus());
            if (topicoParcial.getAutor() != null) topico.setAutor(topicoParcial.getAutor());
            if (topicoParcial.getCurso() != null) topico.setCurso(topicoParcial.getCurso());
            return topicoRepository.save(topico);
        });
    }

    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new RuntimeException("El tópico no existe");
        }
        topicoRepository.deleteById(id);
    }
}