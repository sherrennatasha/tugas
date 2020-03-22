package com.apap.tugas.service;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.repository.SpesialisasiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpesialisasiServiceImpl implements SpesialisasiService{

    @Autowired
    SpesialisasiDb spesialisasiDb;

    @Override
    public void addSpesialisasi(SpesialisasiModel asuransi){
    	spesialisasiDb.save(asuransi);
    }

    @Override
    public List<SpesialisasiModel> getSpesialisasiList(){
        return spesialisasiDb.findAll();
    }

    @Override
    public SpesialisasiModel getSpesialisasiByIdSpesialisasi(Long idSpesialisasi){
        return spesialisasiDb.findByIdSpesialisasi(idSpesialisasi);
    }

    @Override
    public void deleteSpesialisasi(SpesialisasiModel spesialisasi){
    	spesialisasiDb.delete(spesialisasi);
    }
}