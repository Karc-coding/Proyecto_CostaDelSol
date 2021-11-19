package com.store.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.store.app.entity.Huesped;
@EnableJpaRepositories

public interface HuespedRepository extends JpaRepository<Huesped, String> {
	
	
	

}

