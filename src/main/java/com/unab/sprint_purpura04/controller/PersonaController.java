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

import com.unab.sprint_purpura04.entity.PersonaEntity;
import com.unab.sprint_purpura04.service.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public List<PersonaEntity> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<PersonaEntity> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonaEntity save(@RequestBody PersonaEntity personaEntity) {
		return service.save(personaEntity);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PersonaEntity update(@PathVariable Long id, @RequestBody PersonaEntity personaEntity) {
		Optional<PersonaEntity> op = service.findById(id);
		
		if (!op.isEmpty()) {
			PersonaEntity personaEntityUpdate = op.get();
			personaEntityUpdate.setDocumento(personaEntity.getDocumento());
			personaEntityUpdate.setNombre(personaEntity.getNombre());
			personaEntityUpdate.setApellido(personaEntity.getApellido());
			personaEntityUpdate.setCorreo(personaEntity.getCorreo());
			personaEntityUpdate.setTelefono(personaEntity.getTelefono());
			return service.save(personaEntityUpdate);
		}
		
		return personaEntity;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
