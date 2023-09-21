package com.proempresa.msproempresaprueba.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.proempresa.msproempresaprueba.mapper.CliesteMapper;
import com.proempresa.msproempresaprueba.persistence.entity.Cliente;
import com.proempresa.msproempresaprueba.persistence.repository.ClienteRepository;
import com.proempresa.msproempresaprueba.service.dto.ClienteDTO;
import com.proempresa.msproempresaprueba.utils.TestUtils;

import reactor.core.publisher.Mono;

public class ClienteServiceTest {
	
	@MockBean
    private ClienteRepository clienteRepository;
	
	@MockBean
    private CliesteMapper cliesteMapper;
    
    @Autowired
    private ClientesService clientesService;
	
    @Test
	void whenGetAllClientes() throws IOException {
		 
		 Cliente cliente =  new Cliente();
		 cliente.setIdCliente( (long)1);
		 cliente.setNombres("juan alberto");
		 cliente.setNombres("Delgado ramirez");
		 cliente.setNroDocumento("123456678");
		 cliente.setNroDocumento("correo@gmail.com");
		 cliente.setCreateAt(new Date());
		 ClienteDTO clienteDTO =  new ClienteDTO();
		 
	     Mockito.when(clienteRepository.getAll()).thenReturn((List<Cliente>) Mono.just(cliente));
	     Mockito.when(cliesteMapper.toClienteDTO(cliente)).thenReturn(clienteDTO);
	     clientesService.getAll();
	     		
	}
    
//    @Test
//	void whenSaveCliente() throws IOException {
//		 
//		 Cliente cliente =  (Cliente) TestUtils.readJsonFromPath("mocks/getClientByIdFromRest.json", new TypeReference<Cliente>() {});
//		 
//	     Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
//		
//	}
//
//    
//    @Test
//	void whenDeleteCliente() throws IOException {
//		 
//		 Cliente cliente =  (Cliente) TestUtils.readJsonFromPath("mocks/getClientByIdFromRest.json", new TypeReference<Cliente>() {});
//		 
//	     Mockito.when(clienteRepository.delete((int) 1)).thenReturn(Mono.empty());
//		
//	}


}
