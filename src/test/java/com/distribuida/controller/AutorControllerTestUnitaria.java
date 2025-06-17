package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AutorControllerTestUnitaria {

    @InjectMocks
    private AutorController autorController;

    @Mock
    private AutorService autorService;
    private Autor autor;

    @BeforeEach
    public void  setUp() {
        MockitoAnnotations.openMocks(this);
        autor = new Autor();
        autor.setIdAutor(1);
        autor.setNomAutor("Julian");
        autor.setApeAutor("Milanesa");
        autor.setPaisAutor("Guyana");
        autor.setDirAutor("Muy muy lejano");
        autor.setFonoAutor("0949392094");
        autor.setCorreoAutor("julina.milanesa@milanesa.com");
    }

    @Test
    public void testFinAll(){
        when(autorService.findAll()).thenReturn(List.of(autor));
        ResponseEntity<List<Autor>> respuesta = autorController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(autorService, times(1)).findAll();
    }
    @Test
    public void testFindOne(){
        when(autorService.findOne(1)).thenReturn(autor);
        ResponseEntity<Autor> respuesta = autorController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(autor.getNomAutor(), respuesta.getBody().getNomAutor());
    }
    @Test
    public void testFindOneNoExistente(){
        when(autorService.findOne(2)).thenReturn(null);
        ResponseEntity<Autor> respuesta= autorController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(autorService.save(autor)).thenReturn(autor);
        ResponseEntity<Autor> respuesta= autorController.save(autor);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Julian", respuesta.getBody().getNomAutor());
    }

    @Test
    public void testUpdateExistente(){
        when(autorService.update(1, autor)).thenReturn(autor);
        ResponseEntity<Autor> respuesta= autorController.update(1, autor);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    //Revisar
    public void testUpdateNoExiste(){
        when(autorService.update(eq(2), any(Autor.class))).thenReturn(null);
        ResponseEntity<Autor> respuesta = autorController.update(2, autor);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(autorService).delete(1);
        ResponseEntity<Void> respuesta = autorController.delete(1);
        assertEquals(204, respuesta.getStatusCodeValue());
        verify(autorService, Mockito.times(1)).delete(1);
    }
}
