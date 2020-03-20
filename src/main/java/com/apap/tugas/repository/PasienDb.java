package com.apap.tugas.repository;

import com.apap.tugas.model.PasienModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasienDb extends JpaRepository<PasienModel, Long> {
    PasienModel findByIdPustakawan(Long idPustakawan);
   //PasienModel findByNik(String nik);
}