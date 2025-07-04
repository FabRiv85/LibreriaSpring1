package com.distribuida.controller;

import com.distribuida.model.Cliente;
import com.distribuida.service.ClienteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
@SuppressWarnings("removal")
@WebMvcTest(ClienteController.class)
public class ClienteControllerTestIntegracion {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCliente()throws Exception{
        Cliente cliente = new Cliente(1,"1719232023","Perico","De los Palotes","Lejos de aquí","0943023322","perico.delospalotes@delospalotes.com");
        Mockito.when(clienteService.findAll()).thenReturn(List.of(cliente));
        mockMvc.perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Perico"));

    }
    @Test
    public void testPostCliente() throws Exception {
       Cliente cliente = new Cliente(0,"1719232023","Perico","De los Palotes","Lejos de aquí","0943023322","perico.delospalotes@delospalotes.com");

        Mockito.when(clienteService.save(any(Cliente.class))).thenReturn(cliente);
        mockMvc.perform(post("/api/clientes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Perico"));
    }
    @Test
    public void testDeleteCliente() throws Exception  {
        mockMvc.perform(delete("/api/clientes/1"))
                .andExpect(status().isNoContent());
    }
}
