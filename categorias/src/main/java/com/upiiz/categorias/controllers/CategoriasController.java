package com.upiiz.categorias.controllers;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.services.CategoriasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

    //Requiero inyectar el servicio
    CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService){
        this.categoriasService = categoriasService;
    }

    //Get de todas
    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok(categoriasService.getAllcategorias());
    }

    //Get de una
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriasService.getCategoriaById(id));
    }

    //Post - crear una cat
    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriasService.createCategoria(categoria));
    }

    //PUT - actualizar una cat
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Long id){
        categoria.setId(id);
        return ResponseEntity.ok(categoriasService.updateCategoria(categoria));
    }

    //Delete - elimibnar una cat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCetegoria(@PathVariable Long id){
        categoriasService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
    
}
