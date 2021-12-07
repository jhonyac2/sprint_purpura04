package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.sprint_purpura04.entity.HabitacionEntity;
import com.unab.sprint_purpura04.repository.IHabitacionRepository;

@Service
public class HabitacionService implements IHabitacionService{
	@Autowired
	private IHabitacionRepository repository;
	
	@Override
	public List<HabitacionEntity> all() {
		return this.repository.findAll();
	}
	
	@Override
	public Optional<HabitacionEntity> findById(Long id) {
		return this.repository.findById(id);
	}
	
	@Override
	public HabitacionEntity save(HabitacionEntity habitacionEntity) {
		return this.repository.save(habitacionEntity);
	}
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
