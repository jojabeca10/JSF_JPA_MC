package com.mejorcocina.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.mejorcocina.dao.ClienteDAO;
import com.mejorcocina.model.Cliente;

@ManagedBean (name="clienteBean")
@RequestScoped

public class ClienteBean {
	public String ejecutarCliente(){
		return "/faces/consultclien.xhtml";
	}
	public String volver(){
		return "/faces/index.xhtml";
	}
	public List<Cliente> consultarCliente(){
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarClientes();
	}
	public List<Cliente> cargarCombo(){
		ClienteDAO mesaDAO = new ClienteDAO();
		return mesaDAO.cargarCombo();
	}
}
