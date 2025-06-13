package com.distribuida.dao;


import com.distribuida.model.Categoria;
import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Libro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaDetalleRepositoryTestIntegracion {
    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void findAll(){
        List <FacturaDetalle> facturasDetalles = facturaDetalleRepository.findAll();
        assertNotNull(facturasDetalles);
        assertTrue(facturasDetalles.size()>0);
        for (FacturaDetalle item:facturasDetalles){
            System.out.println(item.toString());
        }
    }
    @Test
    public void findOne(){
        Optional <FacturaDetalle> facturaDetalle= facturaDetalleRepository.findById(24);
        assertNotNull(facturaDetalle);
        assertEquals(24, facturaDetalle.orElse(null).getIdFacDet());
        System.out.println(facturaDetalle.toString());
    }
    @Test
    public void save(){
        Optional<Factura> factura= facturaRepository.findById(1);
        assertTrue(factura.isPresent());
        Optional<Libro> libro= libroRepository.findById(1);
        assertTrue(libro.isPresent());
        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacDet(0);
        facturaDetalle.setCantFacDet(30);
        facturaDetalle.setSubtFacDet(33.78);
        facturaDetalle.setFactura(factura.orElse(null));
        facturaDetalle.setLibro(libro.orElse(null));
        FacturaDetalle facturaDetalleGuardado= facturaDetalleRepository.save(facturaDetalle);
        assertNotNull(facturaDetalleGuardado);
        assertEquals(30, facturaDetalleGuardado.getCantFacDet());
        assertEquals(33.78, facturaDetalleGuardado.getSubtFacDet());
        System.out.println(facturaDetalle.toString());
    }
    @Test
    public void update(){
        Optional <FacturaDetalle> facturaDetalleExistente = facturaDetalleRepository.findById(211);
        Optional <Factura> facturaExistente = facturaRepository.findById(1);
        Optional <Libro> libroExistente = libroRepository.findById(1);
        assertNotNull(facturaDetalleExistente);
        assertNotNull(facturaExistente);
        assertNotNull(libroExistente);
        facturaDetalleExistente.orElse(null).setCantFacDet(23);
        facturaDetalleExistente.orElse(null).setSubtFacDet(40.34);
        facturaDetalleExistente.orElse(null).setFactura(facturaExistente.orElse(null));
        facturaDetalleExistente.orElse(null).setLibro(libroExistente.orElse(null));
        FacturaDetalle facturaDetalleActualizada= facturaDetalleRepository.save(facturaDetalleExistente.orElse(null));
        assertNotNull(facturaDetalleExistente);
        assertEquals(23, facturaDetalleActualizada.getCantFacDet());
    }
    @Test
    public void delete() {
        if (facturaDetalleRepository.existsById(211)){
            facturaDetalleRepository.deleteById(211);
        }
        assertFalse(facturaDetalleRepository.existsById(211));
    }
}
