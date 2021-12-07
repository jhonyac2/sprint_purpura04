package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import com.unab.sprint_purpura04.entity.PersonaEntity;

public interface IPersonaService {

	public List<PersonaEntity> all();
	
	public Optional<PersonaEntity> findById(Long id);
	
	public PersonaEntity save(PersonaEntity personaEntity);
	
	public void delete(Long id);
}
