package com.bytecode.crud.repository;

import com.bytecode.crud.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Serializable> {
}
