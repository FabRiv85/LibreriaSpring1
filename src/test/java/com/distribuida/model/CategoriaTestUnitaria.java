package com.distribuida.model;

//import com.distribuida.entities.Autor;
//import com.distribuida.entities.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoriaTestUnitaria{
    private Categoria categoria;
    @BeforeEach
    public void setup(){
        categoria= new Categoria(1,"Terror","Libro que enseña a programar sin perder la cabeza");
    }
    @Test
    public void testCategoriaConstructorandGetters(){
        assertAll("Validar datos de Categoria",
                () -> assertEquals(1, categoria.getidCategoria()),
                () -> assertEquals("Terror", categoria.getcategoria()),
                () -> assertEquals("Libro que enseña a programar sin perder la cabeza", categoria.getDescripcion())
         );
    }
    @Test
    public void testCategoriaSetters(){
        categoria=new Categoria();
        categoria.setIdCategoria(2);
        categoria.setCategoria("Drama");
        categoria.setDescripcion("Programar sin llorar");
        assertAll("Validar datos de categoria",
                () -> assertEquals(2, categoria.getidCategoria()),
                () -> assertEquals("Drama", categoria.getcategoria()),
                () -> assertEquals("Programar sin llorar", categoria.getDescripcion())
        );
    }
}

