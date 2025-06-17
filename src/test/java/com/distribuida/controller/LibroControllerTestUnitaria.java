package com.distribuida.controller;

import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LibroControllerTestUnitaria {
    
    @InjectMocks
    private LibroController libroController;
    
    @Mock
    private LibroService libroService;
    private Libro libro;
    
    @BeforeEach
    public void  setUp(){
        MockitoAnnotations.openMocks(this);

        libro= new Libro();
        libro.setIdLibro(1);
        libro.setTituLibro("Programacion de C++");
        libro.setEditoLibro("ISMAC");
        libro.setPagLibro(100);
        libro.setEdicLibro("Octava");
        libro.setIdioLibro("Latin");
        libro.setFecPubLibro(new Date());
        libro.setDescLibro("entendiendo la lógica de la progrmación");
        libro.setPastLibro("Rígida");
        libro.setIsbnLibro("1249EEC3EF2CASD21");
        libro.setNumEjeLibro(250);
        libro.setPortLibro("Colores");
        libro.setPreseLibro("Libro que indica la programación");
        libro.setPrecLibro(43.21);
    }
    @Test
    public void testFinAll(){
        when(libroService.findAll()).thenReturn(List.of(libro));
        ResponseEntity<List<Libro>> respuesta = libroController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(libroService, times(1)).findAll();
    }
    @Test
    public void testFindOne(){
        when(libroService.findOne(1)).thenReturn(libro);
        ResponseEntity<Libro> respuesta = libroController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(libro.getTituLibro(), respuesta.getBody().getTituLibro());
    }

    @Test
    public void testFindOneNoExistente(){
        when(libroService.findOne(2)).thenReturn(null);
        ResponseEntity<Libro> respuesta= libroController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(libroService.save(libro)).thenReturn(libro);
        ResponseEntity<Libro> respuesta= libroController.save(libro);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Programacion de C++", respuesta.getBody().getTituLibro());
    }

    @Test
    public void testUpdateExistente(){
        when(libroService.update(1, libro)).thenReturn(libro);
        ResponseEntity<Libro> respuesta= libroController.update(1, libro);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    //Revisar
    public void testUpdateNoExiste(){
        when(libroService.update(eq(2), any(Libro.class))).thenReturn(null);
        ResponseEntity<Libro> respuesta = libroController.update(2, libro);
        assertEquals(404, respuesta.getStatusCodeValue());
    }
    @Test
    public void testDelete(){
       doNothing().when(libroService).delete(1);
       ResponseEntity<Void> respuesta = libroController.delete(1);
       assertEquals(204, respuesta.getStatusCodeValue());
       verify(libroService, times(1)).delete(1);
    }
}
