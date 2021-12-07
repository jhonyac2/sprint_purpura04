package com.unab.sprint_purpura04.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.sprint_purpura04.entity.UsuarioEntity;
import com.unab.sprint_purpura04.service.IUsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/ususario")
public class UsusarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public List<UsuarioEntity> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<UsuarioEntity> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioEntity save(@RequestBody UsuarioEntity usuarioEntity) {
		return service.save(usuarioEntity);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioEntity update(@PathVariable Long id, @RequestBody UsuarioEntity usuarioEntity) {
		Optional<UsuarioEntity> op = service.findById(id);
		
		if (!op.isEmpty()) {
			UsuarioEntity usuarioEntityUpdate = op.get();
			usuarioEntityUpdate.setUsuario(usuarioEntity.getUsuario());
			usuarioEntityUpdate.setContrasenia(usuarioEntity.getContrasenia());
			usuarioEntityUpdate.setIdPersona(usuarioEntity.getIdPersona());			
			return service.save(usuarioEntityUpdate);
		}
		
		return usuarioEntity;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
