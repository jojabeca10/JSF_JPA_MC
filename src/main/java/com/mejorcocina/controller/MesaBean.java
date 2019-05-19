package com.mejorcocina.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mejorcocina.dao.MesaDAO;
import com.mejorcocina.model.Mesa;

@ManagedBean(name = "mesaBean")
@RequestScoped

public class MesaBean {
	public List<Mesa> cargarCombo(){
		MesaDAO mesaDAO = new MesaDAO();
		return mesaDAO.cargarCombo();
	}
}
