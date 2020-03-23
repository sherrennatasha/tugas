package com.apap.tugas.service;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.other.AddPustakawanHandler;
import com.apap.tugas.other.ChangePustakawanHandler;

import java.util.List;

public interface PustakawanService {
    String addPustakawan(AddPustakawanHandler dataHandler);
    List<PustakawanModel> getPustakawanList();
    PustakawanModel getPustakawanByIdPustakawan(Long idPustakawan);
    void addPerpustakaanToPustakawan(PustakawanModel pustakawan, PerpustakaanModel perpustakaan);
    String changePustakawanData(PustakawanModel pustakawan, ChangePustakawanHandler dataHandler);
    void deletePustakawan(PustakawanModel pustakawan);
    String createNipPustakawan(int jenisKelamin, String dateOfBirth);
}