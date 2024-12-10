package com.franquicias.api.Controller;

import com.franquicias.api.Service.Imp.FranquiciaService;
import com.franquicias.api.dto.FranquiciaDTO;
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
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<FranquiciaDTO> getById(@PathVariable Long id){
        return null;
    }
    @PostMapping()
    public ResponseEntity<FranquiciaDTO> createFranquicia(@RequestBody FranquiciaDTO franquiciaDTO){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<FranquiciaDTO> updateFranquicia(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FranquiciaDTO> deleteFranquicia(@PathVariable Long id){
        return null;
    }

}
