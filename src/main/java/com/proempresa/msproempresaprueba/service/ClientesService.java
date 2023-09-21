package com.proempresa.msproempresaprueba.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.proempresa.msproempresaprueba.mapper.CliesteMapper;
import com.proempresa.msproempresaprueba.persistence.entity.Cliente;
import com.proempresa.msproempresaprueba.persistence.repository.ClienteRepository;
import com.proempresa.msproempresaprueba.service.dto.ClienteDTO;

@Service
public class ClientesService {
	
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private CliesteMapper cliesteMapper;
    
	public List<ClienteDTO> getAll() {
		List<ClienteDTO> listaClientesDTO = new ArrayList<>();
		
		List<Cliente> clientes = (List<Cliente>) clienteRepository.getAll();
		clientes.stream().forEach(e ->{
			ClienteDTO clienteDTO = cliesteMapper.toClienteDTO(e);
			listaClientesDTO.add(clienteDTO);
		});
		return listaClientesDTO;
	}

	public ClienteDTO save(ClienteDTO entityDTO) {
		Cliente entity = cliesteMapper.ToCliente(entityDTO);
		return cliesteMapper.toClienteDTO(clienteRepository.save(entity));
	}

	public boolean delete(int id) {
        try {
        	clienteRepository.delete(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
	}
}
