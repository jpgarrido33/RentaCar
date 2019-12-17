package com.curso.RentaCar.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.curso.RentaCar.Model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {


}
