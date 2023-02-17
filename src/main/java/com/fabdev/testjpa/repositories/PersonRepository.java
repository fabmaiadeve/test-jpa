package com.fabdev.testjpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabdev.testjpa.models.PersonModel;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID>{

}
