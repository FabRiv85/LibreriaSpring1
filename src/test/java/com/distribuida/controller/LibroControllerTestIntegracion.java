package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Date;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("removal")
@WebMvcTest(LibroController.class)
public class LibroControllerTestIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetLibro()throws Exception{
        Libro libro = new Libro(1,"Programacion de C++","ISMAC",100,"Octava","Latin",new Date(),"entendiendo la lógica de la progrmación","Rígida","1249EEC3EF2CASD21",250,"Colores","Libro que indica la programación",43.21,new Autor(), new Categoria());
        Mockito.when(libroService.findAll()).thenReturn(List.of(libro));
        mockMvc.perform(get("/api/libros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tituLibro").value("Programacion de C++"));

    }
    @Test
    public void testPostLibro() throws Exception {
        Libro libro = new Libro(1,"Programacion de C++","ISMAC",100,"Octava","Latin",new Date(),"entendiendo la lógica de la progrmación","Rígida","1249EEC3EF2CASD21",250,"Colores","Libro que indica la programación",43.21,new Autor(), new Categoria());

        Mockito.when(libroService.save(any(Libro.class))).thenReturn(libro);
        mockMvc.perform(post("/api/libros")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(libro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tituLibro").value("Programacion de C++"));
    }
    @Test
    public void testDeleteLibro() throws Exception  {
        mockMvc.perform(delete("/api/libros/1"))
                .andExpect(status().isNoContent());
    }
}
