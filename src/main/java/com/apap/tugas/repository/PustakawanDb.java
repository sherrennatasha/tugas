package com.apap.tugas.repository;

import com.apap.tugas.model.PustakawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Long> {
   PustakawanModel findByIdPustakawan(Long idPustakawan);
   PustakawanModel findByNipPustakawan(String nipPustakawan);
  
}