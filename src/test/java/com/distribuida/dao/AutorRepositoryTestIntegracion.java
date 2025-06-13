package com.distribuida.dao;

import com.distribuida.model.Autor;
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
public class AutorRepositoryTestIntegracion {
    @Autowired
    private AutorRepository autorRepository;
    @Test
    public void findAll(){
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        assertTrue(autores.size()>0);
        autores = autorRepository.findAll();
        for (Autor item:autores){
            System.out.println(item.toString());
        }
    }
    @Test
    public void  findOne(){
        Optional <Autor> autor= autorRepository.findById(42);
        assertTrue(autor.isPresent());
        System.out.println(autor.toString());

    }
    @Test
    public void save(){
        Autor autor= new Autor(0,"Martin","Calle","Finlandia","Lejos de aqui","0954921311","martin.calle@calle.com");
        Autor autorGuardado= autorRepository.save(autor);
        assertNotNull(autorGuardado);
        assertEquals("Martin", autorGuardado.getNomAutor());
        assertEquals("Calle", autorGuardado.getApeAutor());
        assertEquals("Finlandia", autorGuardado.getPaisAutor());
    }
    @Test
    public void update(){
        Optional<Autor>autor=autorRepository.findById(54);
        assertTrue(autor.isPresent(),"El autor con el id 54, deberia constar en la base");
        autor.orElse(null).setNomAutor("Dionicio");
        autor.orElse(null).setApeAutor("Gaitan");
        autor.orElse(null).setPaisAutor("Ecuador");
        autor.orElse(null).setDirAutor("cerca de aqui");
        autor.orElse(null).setFonoAutor("0954921311");
        autor.orElse(null).setCorreoAutor("dionicio.gaitan@gaitan.com");
        Autor autorActualizado= autorRepository.save(autor.orElse(null));
        assertNotNull(autorActualizado);
        assertEquals("Dionicio",autorActualizado.getNomAutor());
        assertEquals("Gaitan",autorActualizado.getApeAutor());
    }
    @Test
    public void delete(){
        if (autorRepository.existsById(54)){
            autorRepository.deleteById(54);
        }
        assertFalse(autorRepository.existsById(54), "El id=54 debia haberse eliminado");
    }
}
