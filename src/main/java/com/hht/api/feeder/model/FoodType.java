package com.hht.api.feeder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "food_type")
public class FoodType implements Serializable{
	
		private static final long serialVersionUID = -6106502415003263923L;

		@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	    @SequenceGenerator(name = "sequenceGenerator")
	    @Column(name = "food_type_id")
	    private Long id;

	    @Column(length = 55)
	    private String name;

	    @Column(length = 300)
	    private String description;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id")
	    private Status status;

	    public FoodType() {

	    }

	    public FoodType(Long id) {
	        this.id = id;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
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


	    public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}


		public enum Type {

	        ALL(0), BREAKFAST(1), LUNCH(2), DINNER(3), DESSERT(4);
	        private final long id;

	         Type(int id) {
	            this.id = id;
	        }
	         
	        public long getId() {
	            return id;
	        }

	        public FoodType toFoodType() {
	            return new FoodType(id);
	        }
	        
	        public static FoodType fromId(Long id) {
	            for (Type type : Type.values()) {
	                if (type.getId() == id) {
	                    return type.toFoodType();
	                }
	            }

	            throw new IllegalArgumentException("No constant with id " + id + " found");
	        }
	    

	    }
	    
}
