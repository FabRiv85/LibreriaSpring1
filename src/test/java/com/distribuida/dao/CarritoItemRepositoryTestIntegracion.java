package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.CarritoItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class CarritoItemRepositoryTestIntegracion {
    @Autowired
    private CarritoItemRepository carritoItemRepository;
    @Test
    public void findAll(){
        List<CarritoItem> carritoItems = carritoItemRepository.findAll();
        assertNotNull(carritoItems);
        assertTrue(carritoItems.size()>0);
        carritoItems = carritoItemRepository.findAll();
        for (CarritoItem item:carritoItems){
            System.out.println(item.toString());
        }
    }

    @Test
    public void  findOne(){
        Optional<CarritoItem> carritoItems= carritoItemRepository.findById(1L);
        assertTrue(carritoItems.isPresent());
        System.out.println(carritoItems.toString());
    }

    @Test
    public void save(){
        CarritoItem carritoItem = new CarritoItem();
        CarritoItem carritoItemGuardado= carritoItemRepository.save(carritoItem);
        assertNotNull(carritoItemGuardado);
        assertEquals(2, carritoItemGuardado.getCantidad());
        assertEquals(12.80, carritoItemGuardado.getPrecioUnitario());
        assertEquals(25.60, carritoItemGuardado.getTotal());
    }

    @Test
    public void update(){
        Optional<CarritoItem>carritoItem=carritoItemRepository.findById(1L);
        assertTrue(carritoItem.isPresent(),"El item con el id 1, deberia constar en la base");
        carritoItem.orElse(null).setCantidad(2);
        carritoItem.orElse(null).setPrecioUnitario(BigDecimal.valueOf(12.80));
        carritoItem.orElse(null).setTotal(BigDecimal.valueOf(25.60));
        CarritoItem carritoItemActualizado= carritoItemRepository.save(carritoItem.orElse(null));
        assertNotNull(carritoItemActualizado);
        assertEquals(2, carritoItemActualizado.getCantidad());
        assertEquals(25.60, carritoItemActualizado.getTotal());
    }

    @Test
    public void delete(){
        if (carritoItemRepository.existsById(1L)){
            carritoItemRepository.deleteById(1L);
        }
        assertFalse(carritoItemRepository.existsById(1L), "El id=1 debia haberse eliminado");
    }
}

