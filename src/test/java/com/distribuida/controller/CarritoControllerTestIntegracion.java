package com.distribuida.controller;


import com.distribuida.model.Carrito;
import com.distribuida.model.CarritoItem;
import com.distribuida.service.CarritoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

@SuppressWarnings("removal")
@WebMvcTest(CarritoGuestController.class)
public class CarritoControllerTestIntegracion {

    private static final Logger log = LoggerFactory.getLogger(CarritoControllerTestIntegracion.class);
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarritoService carritoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCarrito()throws Exception{
        Carrito carrito = new Carrito(1,"1",134.20,20.45,23.44,133.89);
        Mockito.when(carritoService.getByToken("1"));
        mockMvc.perform(get("api/guest/cart"))
                .andExpect(status().isOk());
    }

    public void  testDeleteCarrito()throws Exception{
    mockMvc.perform(delete("api/guest/cart"))
            .andExpect(status().isNoContent());
    }

}
