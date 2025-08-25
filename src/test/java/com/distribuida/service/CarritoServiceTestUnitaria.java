package com.distribuida.service;

import com.distribuida.dao.CarritoRepository;
import com.distribuida.model.Carrito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class CarritoServiceTestUnitaria {
    @Mock
    private CarritoRepository carritoRepository;

    @InjectMocks
    private CarritoServiceImpl carritoServiceImpl;

    private Carrito carrito;

    @BeforeEach
    public void setup(){
        carrito= new Carrito();
        carrito.setIdCarrito(1L);
        carrito.setSubtotal(BigDecimal.valueOf(154.22));
        carrito.setDescuento(BigDecimal.valueOf(15.33));
        carrito.setImpuestos(BigDecimal.valueOf(28.33));
        carrito.setTotal(BigDecimal.valueOf(167.67));
    }

    @Test
    public void testgetByToken(){
        when(carritoRepository.findByToken("1")).thenReturn(Optional.empty());
        Carrito carritos= carritoServiceImpl.getByToken("1");
    }

    @Test
    public void testUpdateItem(){
        Carrito carritoActualizado = new Carrito();
        carritoActualizado.setSubtotal(BigDecimal.valueOf(134.20));
        carritoActualizado.setDescuento(BigDecimal.valueOf(20.45));
        carritoActualizado.setImpuestos(BigDecimal.valueOf(23.44));
        carritoActualizado.setTotal(BigDecimal.valueOf(133.89));
        when(carritoRepository.findById(1)).thenReturn(Optional.ofNullable(carrito));
        when(carritoRepository.save(carritoActualizado));
    }

    @Test
    public void testClearItemByClient(){
        when(carritoRepository.existsById(1L)).thenReturn(true);
        carritoServiceImpl.clear(1);
        verify(carritoRepository, never()).deleteById((long) anyInt());
    }
}
