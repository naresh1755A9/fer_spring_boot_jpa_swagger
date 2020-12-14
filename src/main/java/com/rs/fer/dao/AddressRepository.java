package com.rs.fer.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.fer.bean.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	

}
