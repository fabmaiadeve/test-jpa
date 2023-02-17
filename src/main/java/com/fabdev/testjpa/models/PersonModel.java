package com.fabdev.testjpa.models;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_person")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_person")
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "cpf_number", length = 11)
	private String cpfNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_social_media")
	private SocialMediaModel socialMedia;

	public PersonModel() {
	}

	public PersonModel(String name, String cpfNumber) {
		super();
		this.name = name;
		this.cpfNumber = cpfNumber;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfNumber() {
		return cpfNumber;
	}

	public void setCpfNumber(String cpfNumber) {
		this.cpfNumber = cpfNumber;
	}

	public SocialMediaModel getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(SocialMediaModel socialMedia) {
		this.socialMedia = socialMedia;
	}
}
