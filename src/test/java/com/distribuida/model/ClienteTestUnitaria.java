package com.distribuida.model;

//import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {
    private Cliente cliente;
    @BeforeEach
    public void setup(){
        cliente= new Cliente(1,"1717532220","Fabricio","Rivera","la casa","0995406523","fabricio.rivera@rivera.com");
    }
    @Test
    public void testClienteConstructorandGetters(){
        assertAll("Validar datos de cliente",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("1717532220", cliente.getCedula()),
                () -> assertEquals("Fabricio", cliente.getNombre()),
                () -> assertEquals("Rivera", cliente.getApellido()),
                () -> assertEquals("la casa", cliente.getDireccion()),
                () -> assertEquals("0995406523", cliente.getTelefono()),
                () -> assertEquals("fabricio.rivera@rivera.com", cliente.getCorreo())
        );
    }
    @Test
    public void testClienteSetters(){
        cliente=new Cliente();
        cliente.setIdCliente(2);
        cliente.setCedula("1829494009");
        cliente.setNombre("Manuel");
        cliente.setApellido("Beltran");
        cliente.setDireccion("su casa");
        cliente.setTelefono("099593825");
        cliente.setCorreo("manuel.taipe@taipe.com");


        assertAll("Validar datos de cliente",
                () -> assertEquals(2, cliente.getIdCliente()),
                () -> assertEquals("1829494009", cliente.getCedula()),
                () -> assertEquals("Manuel", cliente.getNombre()),
                () -> assertEquals("Beltran", cliente.getApellido()),
                () -> assertEquals("su casa", cliente.getDireccion()),
                () -> assertEquals("099593825", cliente.getTelefono()),
                () -> assertEquals("manuel.taipe@taipe.com", cliente.getCorreo())
        );
    }
    @Test
    public void testClienteToString(){
        String str= cliente.toString();
        assertAll("Validar datos de cliente",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("1717532220")),
                () -> assertTrue(str.contains("Fabricio")),
                () -> assertTrue(str.contains("Rivera")),
                () -> assertTrue(str.contains("la casa")),
                () -> assertTrue(str.contains("0995406523")),
                () -> assertTrue(str.contains("fabricio.rivera@rivera.com"))
        );
    }
}
