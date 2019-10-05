package com.curso.RentaCar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.RentaCar.Model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

}
