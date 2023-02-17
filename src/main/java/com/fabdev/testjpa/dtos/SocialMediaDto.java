package com.fabdev.testjpa.dtos;

import javax.validation.constraints.NotBlank;

public class SocialMediaDto {
	
	private String instagram;
	
	private String facebook;
	
	@NotBlank
	private String linkedin;

	public String getInstagram() {
		return instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getLinkedin() {
		return linkedin;
	}
}
