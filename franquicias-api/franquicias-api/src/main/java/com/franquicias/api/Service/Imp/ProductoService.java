package com.franquicias.api.Service.Imp;

import com.franquicias.api.Persistence.Entity.ProductoEntity;
import com.franquicias.api.Persistence.Repository.ProductoRepository;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.ProductoDTO;
import com.franquicias.api.exception.ResourceNotFoundException;
import com.franquicias.api.mapping.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements GenericService<ProductoDTO, Long> {

    private ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ProductoDTO create(ProductoDTO entity) {
        ProductoEntity productoEntity = productoMapper.toEntity(entity);
        ProductoEntity saved = productoRepository.save(productoEntity);
        return productoMapper.toDTO(saved);
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductoDTO getById(Long id) {
        return productoRepository.findById(id)
                .map(productoEntity -> productoMapper.toDTO(productoEntity))
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
    }

    @Override
    public List<ProductoDTO> getAll() {
        List<ProductoEntity> list = productoRepository.findAll();
        return list.stream()
                .map( productoEntity -> productoMapper.toDTO(productoEntity))
                .collect(Collectors.toList());
    }

    public ProductoDTO get(){
        return null;
    }
}
