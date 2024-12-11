package com.franquicias.api.Service.Imp;


import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import com.franquicias.api.Persistence.Repository.FranquiciaRepository;
import com.franquicias.api.exception.ResourceNotFoundException;
import com.franquicias.api.mapping.FranquiciaMapper;
import org.springframework.stereotype.Service;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.FranquiciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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
    public FranquiciaDTO create(FranquiciaDTO entity) {
        FranquiciaEntity franquiciaEntity = franquiciaMapper.toEntity(entity);
        FranquiciaEntity savedEntity = franquiciaRepository.save(franquiciaEntity);
        return franquiciaMapper.toDTO(savedEntity);
    }

    @Override
    public FranquiciaDTO update(Long id, FranquiciaDTO entity) {
        // NO es necesario por el momento
        return null;
    }

    @Override
    public void delete(Long id) {
        franquiciaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Franquicia not Found"));
        franquiciaRepository.deleteById(id);
    }

    @Override
    public FranquiciaDTO getById(Long id) {
        return franquiciaRepository.findById(id)
                .map(franquicia -> franquiciaMapper.toDTO(franquicia))
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia not Found"));
    }

    @Override
    public List<FranquiciaDTO> getAll() {
        List<FranquiciaEntity> list = franquiciaRepository.findAll();
        return list.stream().map(franquiciaEntity ->  franquiciaMapper.toDTO(franquiciaEntity))
                .collect(Collectors.toList());
    }
}
