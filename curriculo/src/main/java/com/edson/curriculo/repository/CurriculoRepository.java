package com.edson.curriculo.repository;

import com.edson.curriculo.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo,Long>
{

}
