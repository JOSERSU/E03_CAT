package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//sE CREA UNA INSTANCIA UTOMAtyica de esta clase
@Service
public class CategoriasService {

    //rEQUERIMOS EL REPO DE (DATOS-LISTADO) DE CATEGORIAS)
    CategoriasRepository categoriasRepository;

    //Constructor -cuando creo ella instancia le pasa el repositorio
    public CategoriasService(CategoriasRepository categoriasRepository){
        this.categoriasRepository = categoriasRepository;
    }

    //Get todas las categorias
    public List<Categoria> getAllcategorias(){
        return categoriasRepository.obtenerCategorias();
    }

    public Categoria getCategoriaById(Long id){
        return categoriasRepository.obntenerUnaCategotia(id);
    }

    public Categoria createCategoria(Categoria categoria){
        return categoriasRepository.guardar(categoria);
    }

    public Categoria updateCategoria(Categoria categoria){
        return categoriasRepository.actualizarCategoria(categoria);
    }

    public void deleteCategoria(Long id){
        categoriasRepository.eliminarCategoria(id);
    }

}
