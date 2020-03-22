package com.apap.tugas.service;

import com.apap.tugas.model.SpesialisasiModel;

import java.util.List;

public interface SpesialisasiService {
    void addSpesialisasi(SpesialisasiModel spesialisasi);
    List<SpesialisasiModel> getSpesialisasiList();
    SpesialisasiModel getSpesialisasiByIdSpesialisasi(Long idSpesialisasi);
    void deleteSpesialisasi(SpesialisasiModel spesialisasi);
}
