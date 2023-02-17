package com.fabdev.testjpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fabdev.testjpa.models.PersonModel;
import com.fabdev.testjpa.repositories.PersonRepository;

@Service
public class PersonService {

	final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Transactional
	public PersonModel save(PersonModel personModel) {
		return personRepository.save(personModel);
	}
	
	public List<PersonModel> getAllPersons() {
		return personRepository.findAll();
	}
	
	public Optional<PersonModel> getById(UUID id_person) {
		return personRepository.findById(id_person);
	}
	
	@Transactional
	public void deletePerson(PersonModel personModel) {
		personRepository.delete(personModel);
	}
}
