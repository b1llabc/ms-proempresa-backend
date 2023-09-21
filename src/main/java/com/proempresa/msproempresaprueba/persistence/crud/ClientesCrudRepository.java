package com.proempresa.msproempresaprueba.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.proempresa.msproempresaprueba.persistence.entity.Cliente;

public interface ClientesCrudRepository extends CrudRepository<Cliente, Long> {

}
