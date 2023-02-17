package com.fabdev.testjpa.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonDto {
	
	@NotBlank
	private String name;

	
	@NotBlank
	@Size(max = 11)
	private String cpfNumber;
	
	
	private SocialMediaDto socialMediaDto;


	public String getName() {
		return name;
	}


	public String getCpfNumber() {
		return cpfNumber;
	}


	public SocialMediaDto getSocialMediaDto() {
		return socialMediaDto;
	}
	
	

}
