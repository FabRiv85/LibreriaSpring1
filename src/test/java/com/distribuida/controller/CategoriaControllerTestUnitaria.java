package com.distribuida.controller;

import com.distribuida.model.Categoria;
import com.distribuida.service.CategoriaService;
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

public class CategoriaControllerTestUnitaria {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaService;
    private Categoria categoria;

    @BeforeEach
    public void  setUp() {
        MockitoAnnotations.openMocks(this);
        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setCategoria("Drama");
        categoria.setDescripcion("La programación no es para cualquiera");
    }

    @Test
    public void testFinAll(){
        when(categoriaService.findAll()).thenReturn(List.of(categoria));
        ResponseEntity<List<Categoria>> respuesta = categoriaController.findAll();
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(1, respuesta.getBody().size());
        verify(categoriaService, times(1)).findAll();
    }
    @Test
    public void testFindOne(){
        when(categoriaService.findOne(1)).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta = categoriaController.findOne(1);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(categoria.getcategoria(), respuesta.getBody().getcategoria());
    }
    @Test
    public void testFindOneNoExistente(){
        when(categoriaService.findOne(2)).thenReturn(null);
        ResponseEntity<Categoria> respuesta= categoriaController.findOne(2);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testSave(){
        when(categoriaService.save(categoria)).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta= categoriaController.save(categoria);
        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals("Drama", respuesta.getBody().getcategoria());
    }

    @Test
    public void testUpdateExistente(){
        when(categoriaService.update(1, categoria)).thenReturn(categoria);
        ResponseEntity<Categoria> respuesta= categoriaController.update(1, categoria);
        assertEquals(200, respuesta.getStatusCodeValue());
    }

    @Test
    //Revisar
    public void testUpdateNoExiste(){
        when(categoriaService.update(eq(2), any(Categoria.class))).thenReturn(null);
        ResponseEntity<Categoria> respuesta = categoriaController.update(2, categoria);
        assertEquals(404, respuesta.getStatusCodeValue());
    }

    @Test
    public void testDelete(){
        doNothing().when(categoriaService).delete(1);
        ResponseEntity<Void> respuesta = categoriaController.delete(1);
        assertEquals(204, respuesta.getStatusCodeValue());
        verify(categoriaService, Mockito.times(1)).delete(1);
    }
}
