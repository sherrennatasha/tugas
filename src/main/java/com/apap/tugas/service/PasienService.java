package com.apap.tugas.service;

import com.apap.tugas.model.DiagnosisPenyakitModel;
import com.apap.tugas.model.PasienModel;
import com.apap.tugas.other.AddPasienHandler;
import com.apap.tugas.other.ChangePasienHandler;

import java.util.List;

public interface PasienService {
    String addPustakawan(AddPasienHandler dataHandler);
    List<PasienModel> getPustakawanList();
    PasienModel getPustakawanByIdPustakawan(Long idPustakawan);
    //PasienModel getPasienByNikPasien(String nik);
    void addDiagnosisToPustakawan(PasienModel pustakawan, DiagnosisPenyakitModel diagnosisPenyakit);
    String changePustakawanData(PasienModel pustakawan, ChangePasienHandler dataHandler);
    void deletePustakawan(PasienModel pustakawan);
    String createNipPustakawan(int jenisKelamin, String dateOfBirth);
}