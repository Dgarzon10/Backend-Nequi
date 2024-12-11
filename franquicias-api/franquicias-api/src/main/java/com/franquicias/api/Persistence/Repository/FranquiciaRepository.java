package com.franquicias.api.Persistence.Repository;

import com.franquicias.api.Persistence.Entity.FranquiciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranquiciaRepository extends JpaRepository<FranquiciaEntity, Long> {
}
