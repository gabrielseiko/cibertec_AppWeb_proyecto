package org.cibertec.edu.pe.repository;



import org.cibertec.edu.pe.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {

	
}
