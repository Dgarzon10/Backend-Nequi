package com.franquicias.api.Controller;

import com.franquicias.api.Service.Imp.SucursalService;
import com.franquicias.api.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sucursal")
public class SucursalController {

    private SucursalService sucursalService;
    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @GetMapping()
    public ResponseEntity<List<SucursalDTO>> getAllSucursales(){
        return ResponseEntity.ok(sucursalService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SucursalDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(sucursalService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO){
        return ResponseEntity.ok(sucursalService.create(sucursalDTO));
    }

    @PutMapping("/nombre/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Long id, @RequestBody SucursalDTO sucursalDTO){
        return ResponseEntity.ok(sucursalService.updateNombre(id, sucursalDTO.getNombre()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSucursal(@PathVariable Long id){
        sucursalService.delete(id);
        return ResponseEntity.ok("Eliminado Exitosamente");
    }
}
