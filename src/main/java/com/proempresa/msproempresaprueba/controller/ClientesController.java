package com.proempresa.msproempresaprueba.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proempresa.msproempresaprueba.service.ClientesService;
import com.proempresa.msproempresaprueba.service.dto.ClienteDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clientes")
public class ClientesController {
	
    @Autowired
    private ClientesService clientesService;
    
    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos los clientes")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<ClienteDTO>> getAll() {
    	return new ResponseEntity<>(clientesService.getAll(), HttpStatus.OK);
	}

    @PostMapping("/save")
    @ApiOperation(value = "Guardar cliente")
    @ApiResponse(code = 201, message = "Cliente guardado")
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO entity) {
		return new ResponseEntity<>(clientesService.save(entity), HttpStatus.CREATED);
	}
    
    @PutMapping("/update")
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO entity) {
		return new ResponseEntity<>(clientesService.save(entity), HttpStatus.CREATED);
	}

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Borrar un cliente según su Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Cliente no encontrado")
    })
	public ResponseEntity delete(@PathVariable("id") int id) {
    	 return clientesService.delete(id) ? new ResponseEntity(HttpStatus.OK): new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
