package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.sprint_purpura04.entity.PersonaEntity;
import com.unab.sprint_purpura04.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService{

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<PersonaEntity> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<PersonaEntity> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public PersonaEntity save(PersonaEntity personaEntity) {
		return this.repository.save(personaEntity);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
}
