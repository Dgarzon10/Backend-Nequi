package com.franquicias.api.Service.Imp;

import com.franquicias.api.Persistence.Repository.ProductoRepository;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.ProductoDTO;
import com.franquicias.api.mapping.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProductoDTO create(ProductoDTO enity) {
        return null;
    }

    @Override
    public ProductoDTO update(Long aLong, ProductoDTO entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public ProductoDTO getById(Long aLong) {
        return null;
    }

    @Override
    public List<ProductoDTO> getAll() {
        return List.of();
    }

    public ProductoDTO get(){
        return null;
    }
}
