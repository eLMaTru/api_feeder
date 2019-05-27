package com.hht.api.feeder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = -155866065569570367L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator")
	@Column(name = "rol_id")
	private long id;

	@Size(max = 55)
	private String name;

	@Size(max = 300)
	private String description;

	public Rol() {
	}

	public Rol(long id) {
		this.id = id;
	}

	public Rol(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Rol rol = (Rol) o;

		if (id != rol.id)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return (int) (id ^ (id >>> 32));
	}

	@Override
	public String toString() {
		return getId() + ":" + getName();
	}

	public enum Type {

		ROLE_ADMIN(1, "ROLE_ADMIN"), ROLE_USER(2, "ROLE_USER"), ROLE_DELIVERY(3, "ROLE_DELIVERY"),
		ROLE_OPERATOR(4, "ROLE_OPERATOR");
		private final long id;
		private final String name;

		private Type(long id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public long getId() {
			return id;
		}

		public Rol toRol() {
			return new Rol(id);
		}
		
		 public static Rol fromId(Long id) {
	            for (Type type : Type.values()) {
	                if (type.getId() == id) {
	                    return type.toRol() ;
	                }
	            }

	            throw new IllegalArgumentException("No constant with id " + id + " found");
	        }

	}
}
