package com.distribuida.dao;

import com.distribuida.model.Cliente;
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
@Rollback (value = false)
public class ClienteRepositoryTestIntegracion {
        @Autowired
        private ClienteRepository clienteRepository;
        @Test
        public void findAll(){
            List<Cliente> clientes = clienteRepository.findAll();
            assertNotNull(clientes);
            assertTrue(clientes.size()>0);
            for(Cliente item:clientes){
                System.out.println(item.toString());
            }
        }
        @Test
        public void  findOne(){
            Optional<Cliente> cliente = clienteRepository.findById(1);
            assertTrue(cliente.isPresent());
            System.out.println(cliente.toString());
        }
        @Test
        public void save(){
            Cliente cliente= new Cliente(0,"190459493","Pedro","Quizhpe","Por ahí","0995406402","pedro.quizhpe@quizhpe.com");
            Cliente clienteGuardado = clienteRepository.save(cliente);
            assertNotNull(clienteGuardado);
            assertEquals("Pedro",clienteGuardado.getNombre());
            assertEquals("Quizhpe", clienteGuardado.getApellido());
            //clienteRepository.save(cliente);
        }
        @Test
        public void update(){
            Optional<Cliente> cliente = clienteRepository.findById(40);
            assertTrue(cliente.isPresent(),"El cliente con id = 40 deberia existir");
            cliente.orElse(null).setCedula("170459493");
            cliente.orElse(null).setNombre("Pablo");
            cliente.orElse(null).setApellido("Quispe");
            cliente.orElse(null).setDireccion("no se cambia");
            cliente.orElse(null).setTelefono("098542934");
            cliente.orElse(null).setCorreo("pablo.quispe@quispe.com");
            Cliente clienteActualizado = clienteRepository.save(cliente.orElse(null));
            assertNotNull(clienteActualizado);
            assertEquals("Pablo", clienteActualizado.getNombre());
            assertEquals("Quispe", clienteActualizado.getApellido());
        }
        @Test
        public void  delete(){
            if (clienteRepository.existsById(40)){
                clienteRepository.deleteById(40);
            }
            assertFalse(clienteRepository.existsById(40),"El id=40 debería haberse eliminado");
        }
}
