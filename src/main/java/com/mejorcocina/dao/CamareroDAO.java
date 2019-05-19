package com.mejorcocina.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.mejorcocina.model.Camarero;
import com.mejorcocina.model.Cliente;
import com.mejorcocina.model.JPAUtil;


public class CamareroDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Consultar camareros
			public List<Camarero> consultarCamareros(){
				Query q = entity.createNativeQuery("SELECT c.id id_cam,c.nombre nom_cam,c.apellido1 apeunocam,c.apellido2 apedoscam,"
						+ " CAST(f.fecha AS VARCHAR(10)) fechafact, ISNULL(CAST(SUM(d.importe) AS VARCHAR(25)),0) valortot FROM camareros c "
						+ " LEFT JOIN facturas f ON f.id_camarero = c.id LEFT JOIN detalle_facturas d ON d.id_factura = f.id "
						+ " GROUP BY c.id,c.nombre,c.apellido1,c.apellido2,f.fecha ORDER BY f.fecha DESC");
				List<Object[]> listaCamareros = q.getResultList();
				List<Camarero> result = new ArrayList<>();
				
				for (Object[] row : listaCamareros) {
					Camarero camarero = new Camarero();
					camarero.setId((String) row[0]);
					camarero.setNombre((String) row[1]);
					camarero.setApellido1((String) row[2]);
					camarero.setApellido2((String) row[3]);
					camarero.setFecha((String) row[4]);
					camarero.setTotal((String) row[5]);
				
					result.add(camarero);
				}
				
				return result;
			}
			
			public List<Camarero> cargarCombo(){
				List<Object[]> listaCamarero = new ArrayList<>();
				Query q = entity.createNativeQuery("SELECT id id_cam,nombre nom_cam,apellido1 apeunocam,apellido2 apedoscam,"
						+ "'2019-05-20' fechafact,'0' valortot FROM camareros");
				listaCamarero = q.getResultList();
				List<Camarero> result = new ArrayList<>();
				
				for (Object[] row : listaCamarero) {
					Camarero camarero = new Camarero();
					camarero.setId((String) row[0]);
					camarero.setNombre((String) row[1]);
					camarero.setApellido1((String) row[2]);
					camarero.setApellido2((String) row[3]);
					camarero.setFecha((String) row[4]);
					camarero.setTotal((String) row[5]);
					
					result.add(camarero);
				}
				return result;
			}
}
