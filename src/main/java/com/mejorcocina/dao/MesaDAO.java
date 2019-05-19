package com.mejorcocina.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mejorcocina.model.JPAUtil;
import com.mejorcocina.model.Mesa;

public class MesaDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Obtener todos los clientes
	public List<Mesa> cargarCombo(){
		List<Object[]> listaMesas = new ArrayList<>();
		Query q = entity.createNativeQuery("SELECT id,num_max_comensa,ubicacion FROM mesas");
		listaMesas = q.getResultList();
		List<Mesa> result = new ArrayList<>();
		
		for (Object[] row : listaMesas) {
			Mesa mesa = new Mesa();
			mesa.setId((String)row[0]);
			mesa.setNum_max_comensa((Integer)row[1]);
			mesa.setUbicacion((String)row[2]);
			
			result.add(mesa);
		}
		return result;
	}
}
