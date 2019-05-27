package com.hht.api.feeder.model;

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
@Table(name = "order")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "order_id")
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;
	
	@ManyToOne
	@JoinColumn(name = "salad_type_id")
	private SaladType saladType;
	
	@ManyToOne
	@JoinColumn(name = "drink_type_id")
	private DrinkType drinkType;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public SaladType getSaladType() {
		return saladType;
	}

	public void setSaladType(SaladType saladType) {
		this.saladType = saladType;
	}

	public DrinkType getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Order(Food food, SaladType saladType, DrinkType drinkType, User user, Status status) {
		super();
		this.food = food;
		this.saladType = saladType;
		this.drinkType = drinkType;
		this.user = user;
		this.status = status;
	}

	public Order() {
		super();
		
	}

	public Order(Long id) {
		super();
		this.id = id;
	}
	
	
	
	
	


}
