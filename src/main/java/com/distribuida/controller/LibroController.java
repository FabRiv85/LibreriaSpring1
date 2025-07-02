package com.distribuida.controller;

import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findAll(){
        List<Libro> libro1 = libroService.findAll();
        return ResponseEntity.ok(libro1);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Libro> findOne(@PathVariable int id){
        Libro libro= libroService.findOne(id);
        if (libro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> save (@RequestBody Libro libro){
        Libro libro1 = libroService.save(libro);
        return ResponseEntity.ok(libro1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro>update(@PathVariable int id, @RequestBody Libro libro){
        Libro libro2= libroService.update(id, libro);
        if (libro2 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro2);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
