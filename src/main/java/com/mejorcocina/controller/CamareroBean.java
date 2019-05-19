package com.mejorcocina.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mejorcocina.dao.CamareroDAO;
import com.mejorcocina.dao.ClienteDAO;
import com.mejorcocina.model.Camarero;
import com.mejorcocina.model.Cliente;

@ManagedBean (name="camareroBean")
@RequestScoped

public class CamareroBean {
	public String ejecutarCamarero(){
		return "/faces/consultcamar.xhtml";
	}
	public String volver(){
		return "/faces/index.xhtml";
	}
	public List<Camarero> consultarCamarero(){
		CamareroDAO camareroDAO = new CamareroDAO();
		return camareroDAO.consultarCamareros();
	}
	public List<Camarero> cargarCombo(){
		CamareroDAO camareroDAO = new CamareroDAO();
		return camareroDAO.cargarCombo();
	}
}
