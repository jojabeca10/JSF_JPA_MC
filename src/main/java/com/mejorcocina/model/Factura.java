package com.mejorcocina.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="facturas")
@NamedStoredProcedureQuery(name="wp02_agregar_detalle",procedureName="wp02_agregar_detalle",parameters={
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name="@p_plato"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name="@p_importe")
})

public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	@Column
	private String id_cliente;
	@Column
	private String id_camarero;
	@Column
	private String id_mesa;
	@Column
	private String fecha;
	
	private String plato;
	private String valor;
	
	public String getPlato() {
		return plato;
	}
	public void setPlato(String plato) {
		this.plato = plato;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getId_camarero() {
		return id_camarero;
	}
	public void setId_camarero(String id_camarero) {
		this.id_camarero = id_camarero;
	}
	public String getId_mesa() {
		return id_mesa;
	}
	public void setId_mesa(String id_mesa) {
		this.id_mesa = id_mesa;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Factura [id=" + id + ", id_cliente=" + id_cliente + ", id_camarero=" + id_camarero + ", id_mesa="
				+ id_mesa + ", fecha=" + fecha + ", plato=" + plato + ", valor=" + valor + "]";
	}
}
