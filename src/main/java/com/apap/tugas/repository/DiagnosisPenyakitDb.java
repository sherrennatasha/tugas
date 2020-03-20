package com.apap.tugas.repository;

import com.apap.tugas.model.DiagnosisPenyakitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiagnosisPenyakitDb extends JpaRepository<DiagnosisPenyakitModel, Long> {
    DiagnosisPenyakitModel findByIdDiagnosisPenyakit(Long idDiagnosisPenyakit);
}