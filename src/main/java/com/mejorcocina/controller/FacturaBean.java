package com.mejorcocina.controller;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mejorcocina.dao.FacturaDAO;
import com.mejorcocina.model.Factura;

@ManagedBean (name="facturaBean")
@RequestScoped

public class FacturaBean {
	public String ejecutarFactura(){
		Factura fact = new Factura();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("factura", fact);
		return "/faces/nueva.xhtml";
	}
	public String volver(){
		return "/faces/index.xhtml";
	}
	public void guardar(Factura factura){
		FacturaDAO facturaDAO = new FacturaDAO();
		facturaDAO.guardar(factura);
	}
}
