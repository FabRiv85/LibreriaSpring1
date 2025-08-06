package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoItemTestUnitaria {

    private CarritoItem carritoItem;
    @BeforeEach
    public void setup(){
        carritoItem = new CarritoItem();
    }
    @Test
    public void testCarritoItemConstructorandGetters(){
        assertAll( "Validar items de carrito de compras",
          () -> assertEquals(1, carritoItem.getIdCarritoItem()),
          () -> assertEquals(2, carritoItem.getCantidad()),
          () -> assertEquals(12.80, carritoItem.getPrecioUnitario()),
          () -> assertEquals(25.60, carritoItem.getTotal())
        );
    }

    public void  testCarritoItemSetters(){
        carritoItem = new CarritoItem();
        carritoItem.setIdCarritoItem(1L);
        carritoItem.setCantidad(2);
        carritoItem.setPrecioUnitario(BigDecimal.valueOf(12.80));
        carritoItem.setTotal(BigDecimal.valueOf(25.60));

        assertAll("Validar valores de items del carrito de compras",
            () -> assertEquals(1L, carritoItem.getIdCarritoItem()),
            () -> assertEquals(2, carritoItem.getCantidad()),
            () -> assertEquals(12.80, carritoItem.getPrecioUnitario()),
            () -> assertEquals(25.60, carritoItem.getTotal())
        );
    }
}
