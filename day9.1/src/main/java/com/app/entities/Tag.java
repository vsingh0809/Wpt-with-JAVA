package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {
	@Column(length=20,unique=true)
	private String name;
 
	
	
	@Override
	public String toString() {
		return "Tag [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		Tag tag=(Tag)o;
		return this.name.equals(tag.name) ;
	}

	@Override
	public int hashCode() {
		
		return name.hashCode();
	}
	
	
	
}

