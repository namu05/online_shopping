package net.nmu.onlineshoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Category {

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return category_name;
	}

	public void setName(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return category_description;
	}

	public void setDescription(String category_description) {
		this.category_description = category_description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	@Id
	private int id;
	@Column(name="NAME")
	@NotBlank(message = "Please enter the Category Name!")
	private String category_name;
	@Column(name="DESCRIPTION")
	@NotBlank(message = "Please enter the Category Description!")
	private String category_description;
	@Column(name="IMAGE_URL")
	private String imageURL;
	private boolean active = true;

}
