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

import com.unab.sprint_purpura04.entity.HabitacionEntity;
import com.unab.sprint_purpura04.service.IHabitacionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/habitacion")
public class HabitacionController {
	
	@Autowired
	private IHabitacionService service;
	
	@GetMapping
	public List<HabitacionEntity> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<HabitacionEntity> show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public HabitacionEntity save(@RequestBody HabitacionEntity habitacionEntity) {
		return service.save(habitacionEntity);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public HabitacionEntity update(@PathVariable Long id, @RequestBody HabitacionEntity habitacionEntity) {
		Optional<HabitacionEntity> op = service.findById(id);
		
		if (!op.isEmpty()) {
			HabitacionEntity habitacionEntityUpdate = op.get();
			habitacionEntityUpdate.setnhabitacion(habitacionEntity.getnhabitacion());
			habitacionEntityUpdate.setcantidad(habitacionEntity.getcantidad());			
			return service.save(habitacionEntityUpdate);
		}
		
		return habitacionEntity;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
