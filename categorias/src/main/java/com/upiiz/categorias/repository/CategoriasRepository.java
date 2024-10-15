package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

//Con POST
@Repository
public class CategoriasRepository {
    //manejar categorias
    // genrar aid pra la base

    private List<Categoria> categorias = new ArrayList<Categoria>();//Evitar el null pointer exception
    private AtomicLong id = new AtomicLong();

    //GET todas las cat

    public List<Categoria> obtenerCategorias() {
        return categorias;
    }

    //GET solo una cat por id
    public Categoria obntenerUnaCategotia(Long id){
        //Estructurada
        /*for(Categoria categoria : categorias){
            if(categoria.getId().equals(id)){
                return categoria;
            }
        }
        return null;*/

        //funcinal
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);

    }

    //POST
    public Categoria guardar(Categoria categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    //Delete
    public void eliminarCategoria(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }

    //PUT
    public Categoria actualizarCategoria(Categoria categoria){
        eliminarCategoria(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }

}
