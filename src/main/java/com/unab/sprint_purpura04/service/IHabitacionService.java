package com.unab.sprint_purpura04.service;

import java.util.List;
import java.util.Optional;

import com.unab.sprint_purpura04.entity.HabitacionEntity;

public interface IHabitacionService {
	public List<HabitacionEntity> all();
	
	public Optional<HabitacionEntity> findById(Long id);
	
	public HabitacionEntity save(HabitacionEntity habitacionEntity);
	
	public void delete(Long id);
}
