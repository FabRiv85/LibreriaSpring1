package com.distribuida.controller;
import com.distribuida.model.Autor;
import com.distribuida.service.AutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("removal")
@WebMvcTest(AutorController.class)
public class AutorControllerTestIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutorService autorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAutor()throws Exception{
        Autor autor = new Autor(1,"Pablito","Perez","España","Lejos de aquí","0943023322","pablito.perez@perez.com");
        Mockito.when(autorService.findAll()).thenReturn(List.of(autor));
        mockMvc.perform(get("/api/autores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomAutor").value("Pablito"));

    }
    @Test
    public void testPostAutor() throws Exception {
        Autor autor = new Autor(1,"Pablito","Perez","España","Lejos de aquí","0943023322","pablito.perez@perez.com");
        Mockito.when(autorService.save(any(Autor.class))).thenReturn(autor);
        mockMvc.perform(post("/api/autores")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(autor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomAutor").value("Pablito"));
    }
    @Test
    public void testDeleteAutor() throws Exception  {
        mockMvc.perform(delete("/api/autores/1"))
                .andExpect(status().isNoContent());
    }
}
