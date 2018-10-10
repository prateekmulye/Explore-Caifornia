package com.pm.ec.explorecali.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage implements Serializable{

	@Id
	private String id;
	
	@Column
	private String name;

	public String getCode() {
		return id;
	}

	public String getName() {
		return name;
	}

	public TourPackage(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TourPackage() {
		super();
	}

	@Override
    public String toString() {
        return "TourPackage{" +
                "code='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
