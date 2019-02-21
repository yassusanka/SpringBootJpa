package com.example.springBootexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootexp.model.Shipwreck;

public interface ShipwreckRepository  extends JpaRepository<Shipwreck,Long>{
	

}
