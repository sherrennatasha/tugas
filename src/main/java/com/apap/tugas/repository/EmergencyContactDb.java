package com.apap.tugas.repository;

import com.apap.tugas.model.EmergencyContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactDb extends JpaRepository<EmergencyContactModel, Long> {
    EmergencyContactModel findByIdEmergencyContact(Long idEmergencyContact);
}