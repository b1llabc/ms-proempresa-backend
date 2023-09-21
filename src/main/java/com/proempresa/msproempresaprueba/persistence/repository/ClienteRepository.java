package com.proempresa.msproempresaprueba.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.proempresa.msproempresaprueba.persistence.entity.Cliente;

public interface ClienteRepository {
	
    List<Cliente> getAll();
    
    Optional<Cliente> getById(int id);
    
    Cliente save(Cliente entity);
    
    void delete(int id);
}
