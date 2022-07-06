package com.generation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

	// TRABAJAR CON JPQL REALIZANDO QUERYS ESPECIFICAS

	//QUERY COMUN
	@Query(value="SELECT * FROM autos WHERE marca = ?1", nativeQuery = true) 
	List<Auto> filtrarMarca(String marca);
	
	//FILTRAR CON QUERYS COMUN DEVUELVE LIST TIPO OBJ
	@Query(value="SELECT marca, color, precio FROM autos WHERE marca = ?1 ", nativeQuery = true)
	List<Object[]> buscarMarcaColor(String marca);

	//QUERY CON OBJETO
	@Query("SELECT a FROM Auto a WHERE a.marca = ?1")
	List<Auto> findAllAutosMarca(String marca);
	
	//JOIN CON OBJETO
	@Query("SELECT a FROM Auto a JOIN a.listaCompraVentas cv")
	List<Auto> FindAutoCompraVenta(String marca);

}
