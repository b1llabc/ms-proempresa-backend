package com.proempresa.msproempresaprueba.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.proempresa.msproempresaprueba.persistence.entity.Cliente;
import com.proempresa.msproempresaprueba.service.dto.ClienteDTO;

@Component
public class CliesteMapper {

	
	public ClienteDTO toClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNombres(cliente.getNombres());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setNroDocumento(cliente.getNroDocumento());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setCreateAt(dateToString(cliente.getCreateAt(),"yyyy-MM-dd'T'HH:mm:ss"));

		return clienteDTO;	
	}
	
	
	public Cliente ToCliente(ClienteDTO clientesDTO) {
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(clientesDTO.getIdCliente());
		cliente.setNombres(clientesDTO.getNombres());
		cliente.setApellidos(clientesDTO.getApellidos());
		cliente.setNroDocumento(clientesDTO.getNroDocumento());
		cliente.setEmail(clientesDTO.getEmail());
		cliente.setCreateAt(stringToDate(clientesDTO.getCreateAt(), "yyyy-MM-dd'T'HH:mm:ss"));
		
		return cliente;	
	}
	
	
	public static Date stringToDate(String fechaString, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.parse(fechaString);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String dateToString(Date fechaDate, String formatString) {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		try {
			return format.format(fechaDate);
		} catch (Exception e) {
			return null;
		}
	}
}
