package com.hht.api.feeder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6106502415003263923L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "status_id")
    private Long id;

    @Column(length = 55)
    private String name;

    @Column(length = 300)
    private String description;

    public Status() {

    }

    public Status(Long id) {
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


    public enum Type {

        ALL(0), ENABLED(1), DELETE(2), DISABLED(3), GENERATE(4), CANCEL(5);
        private final long id;

         Type(int id) {
            this.id = id;
        }
         
        public static Long[] asArrayEnabled() {
            return new Long[]{ENABLED.getId()};
        }

        public static Long[] asArrayDisabled() {
            return new Long[]{DISABLED.getId()};
        }

        public static Long[] asArrayAll() {
            return new Long[]{ENABLED.getId(), DISABLED.getId()};
        }

        public long getId() {
            return id;
        }

        public Status toStatus() {
            return new Status(id);
        }
        
        public static Status fromId(Long id) {
            for (Type type : Type.values()) {
                if (type.getId() == id) {
                    return type.toStatus();
                }
            }

            throw new IllegalArgumentException("No constant with id " + id + " found");
        }
    

    }
    

}
