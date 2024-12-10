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
    public ResponseEntity<ProductoDTO> getAllProductos(){
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getById(@PathVariable Long id){
        return null;
    }
    @PostMapping()
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO ProductoDTO){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO> deleteProducto(@PathVariable Long id){
        return null;
    }
}
