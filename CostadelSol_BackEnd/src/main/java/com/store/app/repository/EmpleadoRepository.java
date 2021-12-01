package com.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.app.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

}
