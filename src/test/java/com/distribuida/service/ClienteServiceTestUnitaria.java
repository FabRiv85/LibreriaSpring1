package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTestUnitaria {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;

    private Cliente cliente;

    @BeforeEach
    public void setup(){
        cliente= new Cliente();
        cliente.setIdCliente(1);
        cliente.setCedula("17174439205");
        cliente.setNombre("Juan");
        cliente.setApellido("Coquito");
        cliente.setDireccion("muy lejano");
        cliente.setTelefono("096593932");
        cliente.setCorreo("juancoquito@coquito.com");
    }

    @Test
    public void findAll(){
        when(clienteRepository.findAll()).thenReturn(List.of(cliente));
        List<Cliente> clientes= clienteServiceImpl.findAll();
        assertNotNull(clientes);
        assertEquals(1,clientes.size());
        verify(clienteRepository, times(1)).findAll();
    }
    @Test
    public void findOne(){
        when(clienteRepository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        Cliente cliente = clienteServiceImpl.findOne(1);
        assertNotNull(cliente);
        assertEquals("Juan", cliente.getNombre());
    }
    @Test
    public void testFindOneNoExistente(){
        when(clienteRepository.findById(2)).thenReturn(Optional.empty());
        Cliente cliente = clienteServiceImpl.findOne(2);
        assertNull(cliente);
    }
    @Test
    public void save(){
        when(clienteRepository.save(cliente)).thenReturn(cliente);
        Cliente clienteSave = clienteServiceImpl.save(cliente);
        assertNotNull(clienteSave);
        assertEquals("Juan", clienteSave.getNombre());
    }
    @Test
    public void testUpdateExistente(){
        Cliente clienteActualizado = new Cliente();
        clienteActualizado.setCedula("09340382822");
        clienteActualizado.setNombre("Pedro");
        clienteActualizado.setApellido("Pelion");
        clienteActualizado.setDireccion("muy muy cercano");
        clienteActualizado.setTelefono("3029544");
        clienteActualizado.setCorreo("pedro.pelion@pelion.com");
        when(clienteRepository.findById(1)).thenReturn(Optional.ofNullable(cliente));
        when(clienteRepository.save(any())).thenReturn(clienteActualizado);

        Cliente clienteResultado = clienteServiceImpl.update(1, clienteActualizado);
        assertNotNull(clienteResultado);
        assertEquals("Pedro", clienteResultado.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    public void testUpdateNoExistente(){
        Cliente clienteNuevo= new Cliente();
        when(clienteRepository.findById(999)).thenReturn(Optional.empty());
        Cliente clienteResultado = clienteServiceImpl.update(999, clienteNuevo);
        assertNull(clienteResultado);
        verify(clienteRepository, never()).save(any()); //never equivalente a times(0)
    }
    @Test
    public void testDeleteExistente(){
        when(clienteRepository.existsById(1)).thenReturn(true);
        clienteServiceImpl.delete(1);
        verify(clienteRepository).deleteById(1);
    }
    @Test
    public void testDeleteNoExistente(){
        when(clienteRepository.existsById(999)).thenReturn(false);
        clienteServiceImpl.delete(999);
        verify(clienteRepository, never()).deleteById(anyInt()); //999
    }

}
