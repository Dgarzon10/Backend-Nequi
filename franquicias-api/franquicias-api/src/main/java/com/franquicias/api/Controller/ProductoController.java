package com.franquicias.api.Controller;


import com.franquicias.api.Service.Imp.ProductoService;
import com.franquicias.api.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
public class ProductoController {

    private ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductoDTO>> getAllProductos(){
        return ResponseEntity.ok(productoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.create(productoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id,@RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.update(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id){
        productoService.delete(id);
        return ResponseEntity.ok("Eliminado Exitosamente");
    }
}
