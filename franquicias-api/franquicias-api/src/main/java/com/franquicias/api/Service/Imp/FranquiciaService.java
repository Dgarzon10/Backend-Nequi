package com.franquicias.api.Service.Imp;


import com.franquicias.api.Persistence.Repository.FranquiciaRepository;
import com.franquicias.api.mapping.FranquiciaMapper;
import org.springframework.stereotype.Service;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.FranquiciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class FranquiciaService implements GenericService<FranquiciaDTO, Long> {

    private FranquiciaRepository franquiciaRepository;

    @Autowired
    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    @Autowired
    private FranquiciaMapper franquiciaMapper;

    @Override
    public FranquiciaDTO create(FranquiciaDTO enity) {
        return null;
    }

    @Override
    public FranquiciaDTO update(Long aLong, FranquiciaDTO entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public FranquiciaDTO getById(Long aLong) {
        return null;
    }

    @Override
    public List<FranquiciaDTO> getAll() {
        return List.of();
    }
}
