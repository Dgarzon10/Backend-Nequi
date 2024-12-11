package com.franquicias.api.Service.Imp;


import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import com.franquicias.api.Persistence.Entity.SucursalEntity;
import com.franquicias.api.Persistence.Repository.FranquiciaRepository;
import com.franquicias.api.Persistence.Repository.SucursalRepository;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.SucursalDTO;
import com.franquicias.api.exception.ResourceNotFoundException;
import com.franquicias.api.mapping.SucursalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService implements GenericService<SucursalDTO, Long> {

    private SucursalRepository sucursalRepository;
    private FranquiciaRepository franquiciaRepository; // Repositorio de Franquicia

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository, FranquiciaRepository franquiciaRepository) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaRepository = franquiciaRepository;
    }

    @Autowired
    private SucursalMapper sucursalMapper;


    @Override
    public SucursalDTO create(SucursalDTO entity) {

        FranquiciaEntity franquiciaEntity = franquiciaRepository.findById(entity.getFranquicia_id())
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia not found"));
        SucursalEntity sucursalEntity = sucursalMapper.toEntity(entity,franquiciaEntity);
        SucursalEntity saved = sucursalRepository.save(sucursalEntity);

        return sucursalMapper.toDTO(saved);
    }

    @Override
    public SucursalDTO update(Long id, SucursalDTO sucursalDTO) {
        return null;
    }

    public SucursalDTO updateNombre(Long id, String nombre) {
        SucursalEntity sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal not found"));
        sucursal.setNombre(nombre);
        return sucursalMapper.toDTO(sucursalRepository.save(sucursal));
    }

    @Override
    public void delete(Long id) {
        sucursalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal not found"));
        sucursalRepository.deleteById(id);

    }

    @Override
    public SucursalDTO getById(Long id) {
        return sucursalRepository.findById(id)
                .map(sucursalEntity -> sucursalMapper.toDTO(sucursalEntity))
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal not found"));
    }

    @Override
    public List<SucursalDTO> getAll() {
        return sucursalRepository.findAll()
                .stream().map(sucursalEntity -> sucursalMapper.toDTO(sucursalEntity))
                .collect(Collectors.toList());
    }
}
