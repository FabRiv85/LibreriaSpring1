package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaRepositoryTestIntegracion {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Test
    public void findAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria item:categorias){
            System.out.println(item.toString());
        }
    }
    @Test
    public void findOne(){
        Optional<Categoria> categoria= categoriaRepository.findById(44);
        assertTrue(categoria.isPresent());
        System.out.println(categoria.toString());
    }
    @Test
    public void save(){
        Categoria categoria= new Categoria(0,"Programacion C++","Esta categoria es para libros sobre la programación en C++");
        Categoria categoriaGuardado= categoriaRepository.save(categoria);
        assertNotNull(categoriaGuardado);
        assertEquals("Programacion C++", categoriaGuardado.getcategoria());
        assertEquals("Esta categoria es para libros sobre la programación en C++", categoriaGuardado.getDescripcion());
    }
    @Test
    public void update(){
        Optional<Categoria>categoria=categoriaRepository.findById(58);
        categoria.orElse(null).setCategoria("C--");
        categoria.orElse(null).setDescripcion("Programacion en C--");
        Categoria categoriaActualizado=  categoriaRepository.save(categoria.orElse(null));
        assertNotNull(categoriaActualizado);
        assertEquals("C--", categoriaActualizado.getcategoria());
        assertEquals("Programacion en C--", categoriaActualizado.getDescripcion());
    }
    @Test
    public void delete(){
        if (categoriaRepository.existsById(58)){
            categoriaRepository.deleteById(58);
        }
        assertFalse(categoriaRepository.existsById(58), "El id=58 debia haberse eliminado");
    }
}
