package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;
    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        List<Autor> autor1 = autorService.findAll();
        return ResponseEntity.ok(autor1);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Autor> findOne(@PathVariable int id){
        Autor autor1= autorService.findOne(id);
        if (autor1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor1);
    }

    @PostMapping
    public ResponseEntity<Autor> save (@RequestBody Autor autor){
        Autor autor2 = autorService.save(autor);
        return ResponseEntity.ok(autor2);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor>update(@PathVariable int id, @RequestBody Autor autor){
        Autor autor3= autorService.save(autor);
        if (autor3 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor3);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
