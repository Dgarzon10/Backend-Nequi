package com.franquicias.api.Service.Imp;

import com.franquicias.api.Persistence.Repository.SucursalRepository;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements GenericService<SucursalDTO, Long> {

    private SucursalRepository sucursalRepository;
    @Autowired
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public SucursalDTO create(SucursalDTO enity) {
        return null;
    }

    @Override
    public SucursalDTO update(Long aLong, SucursalDTO entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public SucursalDTO getById(Long aLong) {
        return null;
    }

    @Override
    public List<SucursalDTO> getAll() {
        return List.of();
    }
}
