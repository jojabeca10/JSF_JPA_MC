package com.mejorcocina.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.mejorcocina.model.Cliente;
import com.mejorcocina.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//Consultar clientes
	public List<Cliente> consultarClientes(){
		Query q = entity.createNativeQuery("SELECT c.id id_cli,c.nombre nom_cli,c.apellido1 apeunocli,c.apellido2 apedoscli,"
				+ " ISNULL(CAST(SUM(d.importe) AS VARCHAR(25)),0) valortot FROM clientes c"
				+ " INNER JOIN facturas f ON f.id_cliente = c.id INNER JOIN detalle_facturas d ON d.id_factura = f.id WHERE d.importe > 100000"
				+ " GROUP BY c.id,c.nombre,c.apellido1,c.apellido2,d.importe ORDER BY d.importe DESC");
		List<Object[]> listaClientes = q.getResultList();
		List<Cliente> result = new ArrayList<>();
		
		for (Object[] row : listaClientes) {
			Cliente cliente = new Cliente();
			cliente.setId((String) row[0]);
			cliente.setNombre((String) row[1]);
			cliente.setApellido1((String) row[2]);
			cliente.setApellido2((String) row[3]);
			cliente.setTotal((String) row[4]);
		
			result.add(cliente);
		}
		
		return result;
	}
	
	public List<Cliente> cargarCombo(){
		List<Object[]> listaClientes = new ArrayList<>();
		Query q = entity.createNativeQuery("SELECT id,nombre,apellido1,apellido2,'0' FROM clientes");
		listaClientes = q.getResultList();
		List<Cliente> result = new ArrayList<>();
		
		for (Object[] row : listaClientes) {
			Cliente cliente = new Cliente();
			cliente.setId((String) row[0]);
			cliente.setNombre((String) row[1]);
			cliente.setApellido1((String) row[2]);
			cliente.setApellido2((String) row[3]);
			cliente.setTotal((String) row[4]);
			
			result.add(cliente);
		}
		return result;
	}
}
