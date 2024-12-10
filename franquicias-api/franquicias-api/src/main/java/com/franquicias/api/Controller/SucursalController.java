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
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<SucursalDTO> getById(@PathVariable Long id){
        return null;
    }
    @PostMapping()
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursalDTO){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SucursalDTO> updateSucursal(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SucursalDTO> deleteSucursal(@PathVariable Long id){
        return null;
    }
}
