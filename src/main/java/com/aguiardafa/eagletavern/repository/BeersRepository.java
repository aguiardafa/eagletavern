package com.aguiardafa.eagletavern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aguiardafa.eagletavern.model.Beer;

@Repository
public interface BeersRepository extends JpaRepository<Beer, Long>{

}
