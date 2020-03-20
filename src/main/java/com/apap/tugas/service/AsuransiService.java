package com.apap.tugas.service;

import com.apap.tugas.model.AsuransiModel;

import java.util.List;

public interface AsuransiService {
    void addAsuransi(AsuransiModel asuransi);
    List<AsuransiModel> getAsuransiList();
    AsuransiModel getAsuransiByIdAsuransi(Long idAsuransi);
    void deleteAsuransi(AsuransiModel asuransi);
}
