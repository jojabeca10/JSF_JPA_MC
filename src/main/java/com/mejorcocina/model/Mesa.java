package com.mejorcocina.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mesas")

public class Mesa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column
	private Integer num_max_comensa;
	@Column
	private String ubicacion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getNum_max_comensa() {
		return num_max_comensa;
	}
	public void setNum_max_comensa(Integer num_max_comensa) {
		this.num_max_comensa = num_max_comensa;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	@Override
	public String toString() {
		return "Mesa [id=" + id + ", num_max_comensa=" + num_max_comensa + ", ubicacion=" + ubicacion + "]";
	}
	
}
