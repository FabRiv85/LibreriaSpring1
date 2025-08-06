package com.distribuida.dao;
import com.distribuida.model.Carrito;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CarritoRepositoryTestIntegracion {
    @Autowired
    private CarritoRepository carritoRepository;

    @Test
    public void findAll(){
        List<Carrito> carritos = carritoRepository.findAll();
        assertNotNull(carritos);
        assertTrue(carritos.size()>0);
        carritos = carritoRepository.findAll();
        for (Carrito item:carritos){
            System.out.println(item.toString());
        }
    }
    @Test
    public void  findOne(){
        Optional<Carrito> carrito= carritoRepository.findById(42);
        assertTrue(carrito.isPresent());
        System.out.println(carrito.toString());
    }
    @Test
    public void save(){
        Carrito carrito = new Carrito();
        Carrito carritoGuardado= carritoRepository.save(carrito);
        assertNotNull(carritoGuardado);
        assertEquals("9834123145154", carritoGuardado.getToken());
        assertEquals(17.00, carritoGuardado.getSubtotal());
        assertEquals(3.50, carritoGuardado.getDescuento());
        assertEquals(5.00, carritoGuardado.getImpuestos());
        assertEquals(19.5, carritoGuardado.getTotal());
    }

    @Test
    public void update(){
        Optional<Carrito>carrito=carritoRepository.findById(2);
        assertTrue(carrito.isPresent(),"El carrito con el id 2, deberia constar en la base");
        carrito.orElse(null).setToken("9834123145155");
        carrito.orElse(null).setSubtotal(BigDecimal.valueOf(15.68));
        carrito.orElse(null).setDescuento(BigDecimal.valueOf(3.10));
        carrito.orElse(null).setImpuestos(BigDecimal.valueOf(3.98));
        carrito.orElse(null).setTotal(BigDecimal.valueOf(16.56));
        Carrito carritoactualizado= carritoRepository.save(carrito.orElse(null));
        assertNotNull(carritoactualizado);
        assertEquals("9834123145155",carritoactualizado.getToken());
        assertEquals(16.56, carritoactualizado.getTotal());
    }

    public void delete(){
        if (carritoRepository.existsById(1L)){
            carritoRepository.deleteById(1L);
        }
        assertFalse(carritoRepository.existsById(1L), "El id=54 debia haberse eliminado");
    }
}
