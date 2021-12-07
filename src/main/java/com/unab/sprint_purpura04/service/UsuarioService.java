package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.sprint_purpura04.entity.UsuarioEntity;
import com.unab.sprint_purpura04.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public List<UsuarioEntity> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<UsuarioEntity> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public UsuarioEntity save(UsuarioEntity usuarioEntity) {
		return this.repository.save(usuarioEntity);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
