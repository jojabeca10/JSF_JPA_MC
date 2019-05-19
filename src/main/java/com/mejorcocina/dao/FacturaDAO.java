package com.mejorcocina.dao;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.mejorcocina.model.Factura;
import com.mejorcocina.model.JPAUtil;

public class FacturaDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	EntityManager entidad=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Factura factura){
		entity.getTransaction().begin();
		entity.persist(factura);
		entity.getTransaction().commit();
		entity.close();
		
		insertarDetalle(factura);
		//JPAUtil.shutdown();
	}
	
	public void insertarDetalle(Factura factura){
		entidad.getTransaction().begin();
		StoredProcedureQuery query = entidad.createNamedStoredProcedureQuery("wp02_agregar_detalle");
		query.setParameter("@p_plato", factura.getPlato());
		query.setParameter("@p_importe", Long.parseLong(factura.getValor()));

		query.execute();
		entidad.getTransaction().commit();
		entidad.close();
	}
}
