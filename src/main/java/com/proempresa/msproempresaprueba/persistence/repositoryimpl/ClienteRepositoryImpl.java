package com.proempresa.msproempresaprueba.persistence.repositoryimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proempresa.msproempresaprueba.persistence.crud.ClientesCrudRepository;
import com.proempresa.msproempresaprueba.persistence.entity.Cliente;
import com.proempresa.msproempresaprueba.persistence.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
    @Autowired
    private ClientesCrudRepository clientesCrudRepository;

	@Override
	public List<Cliente> getAll() {
		return (List<Cliente>) clientesCrudRepository.findAll();
	}

	@Override
	public Optional<Cliente> getById(int id) {
		return clientesCrudRepository.findById((long) id);
	}

	@Override
	public Cliente save(Cliente entity) {
		return clientesCrudRepository.save(entity);
	}

	@Override
	public void delete(int id) {
		clientesCrudRepository.deleteById((long) id);
	}
}
