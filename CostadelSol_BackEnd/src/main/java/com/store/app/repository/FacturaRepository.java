package com.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, String> {

}
