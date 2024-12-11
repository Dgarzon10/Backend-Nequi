package com.franquicias.api.Service.Imp;


import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import com.franquicias.api.Persistence.Entity.ProductoEntity;
import com.franquicias.api.Persistence.Entity.SucursalEntity;
import com.franquicias.api.Persistence.Repository.FranquiciaRepository;
import com.franquicias.api.dto.ProductoSucursalDTO;
import com.franquicias.api.exception.ResourceNotFoundException;
import com.franquicias.api.mapping.FranquiciaMapper;
import org.springframework.stereotype.Service;
import com.franquicias.api.Service.GenericService;
import com.franquicias.api.dto.FranquiciaDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
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

    public FranquiciaDTO updateNombre(Long id, String nombre) {
        FranquiciaEntity franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia not Found"));
        franquicia.setNombre(nombre);
        return franquiciaMapper.toDTO(franquiciaRepository.save(franquicia));
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

    public List<ProductoSucursalDTO> mayorStockPorSucursal (Long id){

        FranquiciaEntity franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia not Found"));

        List<SucursalEntity> sucursales = franquicia.getSucursales();

        List<ProductoSucursalDTO> resultado = sucursales.stream()
                .map(sucursal -> {
                    ProductoEntity productoConMasStock = sucursal.getProductos().stream()
                            .max(Comparator.comparingInt(ProductoEntity::getStock))
                            .orElse(null);

                    return new ProductoSucursalDTO(
                            sucursal.getNombre(),
                            productoConMasStock != null ? productoConMasStock.getNombre() : null,
                            productoConMasStock != null ? productoConMasStock.getStock() : null
                    );
                })
                .filter(dto -> dto.getNombreProducto() != null)
                .collect(Collectors.toList());

        return resultado;

    }

}
