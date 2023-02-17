package com.fabdev.testjpa.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.testjpa.dtos.PersonDto;
import com.fabdev.testjpa.models.PersonModel;
import com.fabdev.testjpa.models.SocialMediaModel;
import com.fabdev.testjpa.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto) {
		PersonModel personModel = new PersonModel(personDto.getName(), personDto.getCpfNumber());
		SocialMediaModel socialMediaModel = new SocialMediaModel(personDto.getSocialMediaDto().getInstagram(), personDto.getSocialMediaDto().getFacebook(), personDto.getSocialMediaDto().getLinkedin());
		
		personModel.setSocialMedia(socialMediaModel);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
	}
	
	@GetMapping
	public ResponseEntity<List<PersonModel>> getAllPersons() {
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOnePerson(@PathVariable(value = "id") UUID id) {
		Optional<PersonModel> personOptional = personService.getById(id);
		
		if(personOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") UUID id) {
		Optional<PersonModel> personOptional = personService.getById(id);
		
		if(!personOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
		}
		
		personService.deletePerson(personOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Person record deleted successfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePerson(@PathVariable(value = "id") UUID id,
											   @RequestBody @Valid PersonDto personDto) {
		Optional<PersonModel> personOptional = personService.getById(id);
		
		if(personOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found!");
		}
		
		SocialMediaModel socialMediaModelUpdate = new SocialMediaModel();
		socialMediaModelUpdate.setId(personOptional.get().getSocialMedia().getId());
		socialMediaModelUpdate.setInstagram(personDto.getSocialMediaDto().getInstagram());
		socialMediaModelUpdate.setFacebook(personDto.getSocialMediaDto().getFacebook());
		socialMediaModelUpdate.setLinkedin(personDto.getSocialMediaDto().getLinkedin()); 
		
		PersonModel personModel = new PersonModel();
		personModel.setId(personOptional.get().getId());
		personModel.setName(personDto.getName());
		personModel.setCpfNumber(personDto.getCpfNumber()); 
		personModel.setSocialMedia(socialMediaModelUpdate);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
	}
	
	

}
