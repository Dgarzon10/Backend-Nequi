package com.franquicias.api.Controller;

import com.franquicias.api.Persistence.Entity.ProductoEntity;
import com.franquicias.api.Service.Imp.FranquiciaService;
import com.franquicias.api.dto.FranquiciaDTO;
import com.franquicias.api.dto.ProductoSucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/franquicias")
public class FranquiciasController {

    private FranquiciaService franquiciaService;
    @Autowired
    public FranquiciasController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @GetMapping()
    public ResponseEntity<List<FranquiciaDTO>> getAllFranquicias(){
        return ResponseEntity.ok(franquiciaService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FranquiciaDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(franquiciaService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<FranquiciaDTO> createFranquicia(@RequestBody FranquiciaDTO franquiciaDTO){
        return ResponseEntity.ok(franquiciaService.create(franquiciaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranquiciaDTO> updateFranquicia(@PathVariable Long id, @RequestBody FranquiciaDTO franquiciaDTO){
        return ResponseEntity.ok(franquiciaService.update(id, franquiciaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFranquicia(@PathVariable Long id){
        franquiciaService.delete(id);
        return ResponseEntity.ok("Franquicia eliminada exitosamente!!");
    }

    @GetMapping("/maxStock/{id}")
    public ResponseEntity<List<ProductoSucursalDTO>> getMaxStockPorSucursal(@PathVariable Long id){
        return ResponseEntity.ok(franquiciaService.mayorStockPorSucursal(id));
    }

}
