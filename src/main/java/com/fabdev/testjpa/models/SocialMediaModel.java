package com.fabdev.testjpa.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_social_media")
public class SocialMediaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_social_media")
	private UUID id;
	
	@Column(name = "email_instagram")
	private String instagram;
	
	@Column(name = "email_facebook")
	private String facebook;
	
	@Column(name = "email_linkedin", nullable = false)
	private String linkedin;
	
	public SocialMediaModel() {
	}

	public SocialMediaModel(String instagram, String facebook, String linkedin) {
		super();
		this.instagram = instagram;
		this.facebook = facebook;
		this.linkedin = linkedin;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

}
