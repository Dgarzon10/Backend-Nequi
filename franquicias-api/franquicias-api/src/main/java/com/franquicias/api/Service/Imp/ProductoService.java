package com.franquicias.api.Service.Imp;

import com.franquicias.api.Persistence.Entity.ProductoEntity;
import com.franquicias.api.Persistence.Entity.SucursalEntity;
import com.franquicias.api.Persistence.Repository.ProductoRepository;
import com.franquicias.api.Persistence.Repository.SucursalRepository;
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
    private SucursalRepository sucursalRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, SucursalRepository sucursalRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public ProductoDTO create(ProductoDTO entity) {
        SucursalEntity sucursalEntity = sucursalRepository.findById(entity.getSucursal_id())
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal not found"));
        ProductoEntity productoEntity = productoMapper.toEntity(entity,sucursalEntity);
        ProductoEntity saved = productoRepository.save(productoEntity);
        return productoMapper.toDTO(saved);
    }

    @Override
    public ProductoDTO update(Long id, ProductoDTO entity) {
        ProductoEntity productoEntity = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
        productoMapper.updateProductoFromDto(entity,productoEntity);
        return productoMapper.toDTO(productoRepository.save(productoEntity));
    }
    public ProductoDTO updateStock(Long id, Integer stock) {
        ProductoEntity productoEntity = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
        productoEntity.setStock(stock); // Actualiza directamente el stock
        return productoMapper.toDTO(productoRepository.save(productoEntity));
    }

    public ProductoDTO updateNombre(Long id, String nombre) {
        ProductoEntity productoEntity = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
        productoEntity.setNombre(nombre); // Actualiza directamente el nombre
        return productoMapper.toDTO(productoRepository.save(productoEntity));
    }

    @Override
    public void delete(Long id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found"));
        productoRepository.deleteById(id);

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

}
