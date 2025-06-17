package com.distribuida.service;

import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //es un bean de logica de negocio
public class LibroServiceImpl implements LibroService{
    @Autowired //Anotacion para inyeccion de dependencias
    private LibroRepository libroRepository;
    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findOne(int id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.orElse(null);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        Libro libroExistente = findOne(id);
        if (libroExistente == null){
            return null;
        }
        libroExistente.setTituLibro(libro.getTituLibro());
        libroExistente.setEditoLibro(libro.getEditoLibro());
        libroExistente.setPagLibro(libro.getPagLibro());
        libroExistente.setEdicLibro(libro.getEdicLibro());
        libroExistente.setIdioLibro(libro.getIdioLibro());
        libroExistente.setFecPubLibro(libro.getFecPubLibro());
        libroExistente.setDescLibro(libro.getDescLibro());
        libroExistente.setPastLibro(libro.getPastLibro());
        libroExistente.setIsbnLibro(libro.getIsbnLibro());
        libroExistente.setNumEjeLibro(libro.getNumEjeLibro());
        libroExistente.setPortLibro(libro.getPortLibro());
        libroExistente.setPreseLibro(libro.getPreseLibro());
        libroExistente.setPrecLibro(libro.getPrecLibro());
        libroExistente.setCategoria(libro.getCategoria());
        libroExistente.setAutor(libro.getAutor());

        return libroRepository.save(libroExistente);
    }

    @Override
    public void delete(int id) {
        if (libroRepository.existsById(id)){
            libroRepository.deleteById(id);
        }
    }
}
