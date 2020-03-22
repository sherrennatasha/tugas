package com.apap.tugas.service;

import com.apap.tugas.model.PerpustakaanModel;

import java.util.List;

public interface PerpustakaanService {
    void addPerpustakaan(PerpustakaanModel perpustakaan);
    List<PerpustakaanModel> getPerpustakaanList();
    PerpustakaanModel getPerpustakaanByIdPerpustakaan(Long idPerpustakaan);
    void deletePerpustakaan(Long idPerpustakaan);
}