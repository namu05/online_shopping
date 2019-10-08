package net.nmu.onlineshoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Category {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", Description=" + Description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAB_CUSTOMER_SEQ")
	@SequenceGenerator(name="TAB_CUSTOMER_SEQ", sequenceName="TAB_CUSTOMER_SEQ", allocationSize=1)
	private int id;
	private String name;
	private String Description;
	@Column(name="IMAGE_URL")
	private String imageURL;
	private boolean active = true;

}
