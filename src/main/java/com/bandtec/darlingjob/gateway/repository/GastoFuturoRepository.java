package com.bandtec.darlingjob.gateway.repository;

import com.bandtec.darlingjob.gateway.repository.dominio.GastoFuturo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GastoFuturoRepository extends JpaRepository<GastoFuturo, Integer> {
    List<GastoFuturo> findByUsuario_IdUsuario(Integer idUsuario);
}