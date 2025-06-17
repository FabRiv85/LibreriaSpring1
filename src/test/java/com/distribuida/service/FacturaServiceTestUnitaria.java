package com.distribuida.service;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class FacturaServiceTestUnitaria {
    @Mock
    private FacturaRepository facturaRepository;
    @InjectMocks
    private FacturaServiceImpl facturaServiceImpl;

    private Factura factura;
    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        factura = new Factura();
        cliente= new Cliente(1,"132465444","Pedro","Armendariz","Cayambe","099432022","pedro.armendariz@armendariz.com");
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-00344");
        factura.setFecha(new Date());
        factura.setTotalNeto(145.32);
        factura.setIva(34.43);
        factura.setTotal(179.43);
        factura.setCliente(cliente);
    }
    @Test
    public void findAll(){
        when(facturaRepository.findAll()).thenReturn(List.of(factura));
        List<Factura> facturas1 = facturaServiceImpl.findAll();
        assertEquals(1, facturas1.size());
        assertNotNull(facturas1);
        verify(facturaRepository, times(1)).findAll();
    }
    @Test
    public void findOneExistente(){
        when(facturaRepository.findById(1)).thenReturn(Optional.ofNullable(factura));
        Factura factura = facturaServiceImpl.findOne(1);
        assertNotNull(factura);
        assertEquals("FAC-00344", factura.getNumFactura());
    }
    @Test
    public void findOneNoExistente(){
        when(facturaRepository.findById(2)).thenReturn(Optional.empty());
        Factura factura = facturaServiceImpl.findOne(2);
        assertNull(factura);
    }
    @Test
    public void save(){
        when(facturaRepository.save(factura)).thenReturn(factura);
        Factura factura2 = facturaServiceImpl.save(factura);
        assertEquals("FAC-00344", factura2.getNumFactura());
        assertEquals(179.43, factura2.getTotal());
    }
    @Test
    public void updateExistente(){
        Factura facturaNueva = new Factura();
        Cliente cliente= new Cliente(2,"132465432","Manuel","Armendar","El Quinche","099432022","pedro.armendariz@armendariz.com");
        facturaNueva.setNumFactura("FAC-00030");
        facturaNueva.setFecha(new Date());
        facturaNueva.setTotalNeto(200.43);
        facturaNueva.setIva(45.67);
        facturaNueva.setTotal(245.99);
        facturaNueva.setCliente(cliente);
        when(facturaRepository.findById(1)).thenReturn(Optional.ofNullable(factura));
        when(facturaRepository.save(factura)).thenReturn(factura);
        Factura facturaRespuesta = facturaServiceImpl.update(1, facturaNueva);
        assertNotNull(facturaRespuesta);
        assertEquals("FAC-00030", facturaRespuesta.getNumFactura());
        assertEquals(245.99, facturaRespuesta.getTotal());
        verify(facturaRepository, times(1)).save(factura);
    }
    @Test
    public void updateNoExistente(){
        Factura factura = new Factura();
        when(facturaRepository.findById(999)).thenReturn(Optional.empty());
        Factura factura1= facturaServiceImpl.update(999, factura);
        assertNull(factura1);
        verify(facturaRepository, times(0)).save(any());
    }
    @Test
    public void delete(){
        when(facturaRepository.existsById(1)).thenReturn(true);
        facturaServiceImpl.delete(1);
        verify(facturaRepository,times(1)).deleteById(1);
    }
}
