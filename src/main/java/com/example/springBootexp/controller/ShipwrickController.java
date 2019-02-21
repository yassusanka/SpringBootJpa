package com.example.springBootexp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.springBootexp.model.*;
import com.example.springBootexp.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwrickController {
	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value="Shipwreck",method= RequestMethod.GET)
	public List<Shipwreck>list(){
		return shipwreckRepository.findAll();
	}
	@RequestMapping(value="Shipwreck",method= RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck){
		return shipwreckRepository.saveAndFlush(shipwreck);	
	}
	@RequestMapping(value="Shipwreck/{id}", method= RequestMethod.GET)
	public Shipwreck get(@PathVariable  Long id){
		return  shipwreckRepository.findOne(id);
	}
	@RequestMapping(value="Shipwreck/{id}", method= RequestMethod.PUT)
	public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck){
		Shipwreck existingShipwreck=shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck,existingShipwreck);
		return  shipwreckRepository.saveAndFlush(existingShipwreck);
	}
	@RequestMapping(value="Shipwreck/{id}",method= RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id){
		Shipwreck existingShipwreck=shipwreckRepository.findOne(id);
		shipwreckRepository.delete(existingShipwreck);
		return existingShipwreck;
	}
}
