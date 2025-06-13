package com.distribuida.dao;

import com.distribuida.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class LibroRepositoryTestIntegracion {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private  AutorRepository autorRepository;
    @Test
    public void findAll(){
        List<Libro> libros = libroRepository.findAll();
        assertNotNull(libros);
        assertTrue(libros.size()>0);
        for (Libro item:libros){
            System.out.println(item.toString());
        }
    }
    @Test
    public void findOne(){
        Optional<Libro> libro= libroRepository.findById(1);
        assertNotNull(libro);
        assertEquals("Spring in Action", libro.orElse(null).getTituLibro());
        System.out.println(libro.toString());
    }
    @Test
    public void save(){
        Optional<Categoria> categoria= categoriaRepository.findById(43);
        assertTrue(categoria.isPresent());
        Optional<Autor> autor= autorRepository.findById(10);
        assertTrue(autor.isPresent());
        Libro libro=new Libro();
        libro.setIdLibro(0);
        libro.setTituLibro("Programacion para  Dummies");
        libro.setEditoLibro("Ismac");
        libro.setEdicLibro("Sexta");
        libro.setIdioLibro("Español");
        libro.setFecPubLibro(new Date());
        libro.setDescLibro("Como aprender a programar sin perder la cabeza");
        libro.setPastLibro("Pasta dura");
        libro.setIsbnLibro("894-1244412123567");
        libro.setNumEjeLibro(100);
        libro.setPortLibro("Azul y negro");
        libro.setPreseLibro("físico");
        libro.setPrecLibro(45.32);
        libro.setCategoria(categoria.orElse(null));
        libro.setAutor(autor.orElse(null));
        Libro libroGuardado = libroRepository.save(libro);
        assertNotNull(libroGuardado);
        assertEquals("Programacion para  Dummies", libroGuardado.getTituLibro());
        assertEquals(45.32, libroGuardado.getPrecLibro());
    }
    @Test
    public void update(){
        Optional <Libro> libroExistente = libroRepository.findById(80);
        Optional <Categoria> categoriaExistente = categoriaRepository.findById(13);
        Optional <Autor> autorExistente = autorRepository.findById(6);
        assertNotNull(libroExistente);
        assertNotNull(categoriaExistente);
        assertNotNull(autorExistente);
        libroExistente.orElse(null).setTituLibro("Rompiendo cabezas en programación");
        libroExistente.orElse(null).setEditoLibro("Personal");
        libroExistente.orElse(null).setIdioLibro("Ebreo");
        libroExistente.orElse(null).setFecPubLibro(new Date());
        libroExistente.orElse(null).setDescLibro("Programación pura");
        libroExistente.orElse(null).setPastLibro("Pasta blanda");
        libroExistente.orElse(null).setIsbnLibro("894-1244412100021");
        libroExistente.orElse(null).setPagLibro(350);
        libroExistente.orElse(null).setNumEjeLibro(150);
        libroExistente.orElse(null).setPortLibro("Azul y negro");
        libroExistente.orElse(null).setPreseLibro("virtual");
        libroExistente.orElse(null).setPrecLibro(40.10);
        libroExistente.orElse(null).setCategoria(categoriaExistente.orElse(null));
        libroExistente.orElse(null).setAutor(autorExistente.orElse(null));
        Libro libroActualizada = libroRepository.save(libroExistente.orElse(null));
        assertNotNull(libroActualizada);
        assertEquals("Rompiendo cabezas en programación", libroActualizada.getTituLibro());
    }
    @Test
    public void delete() {
        if (libroRepository.existsById(79)){
            libroRepository.deleteById(79);
        }
        assertFalse(libroRepository.existsById(79));
    }
}
