package com.distribuida.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorTestUnitaria {
    private Autor autor;
    @BeforeEach
    public void setup(){
        autor= new Autor(1,"Fabricio","Rivera","Ecuador","la casa","0995406523","fabricio.rivera@rivera.com");
    }
    @Test
    public void testAutorConstructorandGetters(){
        assertAll("Validar datos de Autor",
                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Fabricio", autor.getNomAutor()),
                () -> assertEquals("Rivera", autor.getApeAutor()),
                () -> assertEquals("Ecuador", autor.getPaisAutor()),
                () -> assertEquals("la casa", autor.getDirAutor()),
                () -> assertEquals("0995406523", autor.getFonoAutor()),
                () -> assertEquals("fabricio.rivera@rivera.com", autor.getCorreoAutor())
        );
    }
    @Test
    public void testAutorSetters(){
        autor=new Autor();
        autor.setIdAutor(2);
        autor.setNomAutor("Manuel");
        autor.setApeAutor("Beltran");
        autor.setPaisAutor("Belgica");
        autor.setDirAutor("su casa");
        autor.setFonoAutor("099593825");
        autor.setCorreoAutor("manuel.taipe@taipe.com");

        assertAll("Validar datos de autor",
                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Manuel", autor.getNomAutor()),
                () -> assertEquals("Beltran", autor.getApeAutor()),
                () -> assertEquals("su casa", autor.getDirAutor()),
                () -> assertEquals("099593825", autor.getFonoAutor()),
                () -> assertEquals("manuel.taipe@taipe.com", autor.getCorreoAutor())
        );
    }

}
