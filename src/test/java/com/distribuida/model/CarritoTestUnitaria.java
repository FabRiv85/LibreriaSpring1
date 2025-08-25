package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CarritoTestUnitaria {
    private Carrito carrito;
    @BeforeEach
    public void setup(){
        carrito = new Carrito();
    }
    @Test
    public void testCarritoConstructorandGetters(){
        assertAll( "Validar datos de carrito de compras",
                () -> assertEquals(1, carrito.getIdCarrito()),
                () -> assertEquals("9834123145154",carrito.getToken()),
                () -> assertEquals(17.00, carrito.getSubtotal()),
                () -> assertEquals(3.50, carrito.getDescuento()),
                () -> assertEquals(5.00, carrito.getImpuestos()),
                () -> assertEquals(19.5, carrito.getTotal())
                //() -> assertEquals(new date())
        );
    }

    @Test
    public void testCarritoSetters(){
        carrito = new Carrito();
        carrito.setIdCarrito(3L);
        carrito.setToken("9851230134232");
        carrito.setSubtotal(BigDecimal.valueOf(15.00));
        carrito.setDescuento(BigDecimal.valueOf(2.50));
        carrito.setImpuestos(BigDecimal.valueOf(2.00));
        carrito.setTotal(BigDecimal.valueOf(14.5));

        assertAll( "Validar datos de carrito de compras",
                () -> assertEquals(3L, carrito.getIdCarrito()),
                () -> assertEquals("9851230134232", carrito.getToken()),
                () -> assertEquals(15.00, carrito.getSubtotal()),
                () -> assertEquals(2.50, carrito.getDescuento()),
                () -> assertEquals(2.00, carrito.getImpuestos()),
                () -> assertEquals(14.5, carrito.getTotal())
        );
    }
}
