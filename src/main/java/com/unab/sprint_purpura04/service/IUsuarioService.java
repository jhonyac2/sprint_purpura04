package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import com.unab.sprint_purpura04.entity.UsuarioEntity;

public interface IUsuarioService {
	
	public List<UsuarioEntity> all();
	
	public Optional<UsuarioEntity> findById(Long id);
	
	public UsuarioEntity save(UsuarioEntity usuarioEntity);
	
	public void delete(Long id);
}
