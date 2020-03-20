package com.apap.tugas.service;

import com.apap.tugas.model.EmergencyContactModel;

import java.util.List;

public interface EmergencyContactService {
    void addEmergencyContact(EmergencyContactModel emergencyContact);
    List<EmergencyContactModel> getEmergencyContactList();
    EmergencyContactModel getEmergencyContactByIdEmergencyContact(Long idEmergencyContact);
    void deleteEmergencyContact(EmergencyContactModel emergencyContact);
}
