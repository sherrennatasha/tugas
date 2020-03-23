package com.apap.tugas.service;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.model.PerpustakaanModel;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.other.AddPustakawanHandler;
import com.apap.tugas.other.ChangePustakawanHandler;
import com.apap.tugas.repository.SpesialisasiDb;

import com.apap.tugas.repository.PustakawanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PustakawanServiceImpl implements PustakawanService {

    @Autowired
    PustakawanDb pustakawanDb;

    @Autowired
    SpesialisasiDb spesialisasiDb;

    @Override
    public String addPustakawan(AddPustakawanHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPustakawan();
        Date tanggalLahirPustakawan = null;

        try {
            tanggalLahirPustakawan = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        
        PustakawanModel pustakawan = new PustakawanModel();

        String nipPustakawan = createNipPustakawan(dataHandler.getJenisKelaminPustakawan(), tanggalLahirStr);
        pustakawan.setNip(nipPustakawan);

        pustakawan.setNama(dataHandler.getNamaPustakawan());
        
        pustakawan.setJenisKelamin(dataHandler.getJenisKelaminPustakawan());
        pustakawan.setTanggalLahir(tanggalLahirPustakawan);
        pustakawan.setTempatLahir(dataHandler.getTempatLahirPustakawan());
       
        
        List<SpesialisasiModel> listSpesialisasi = new ArrayList<>();

        SpesialisasiModel targetSpesialisasi = spesialisasiDb.findByIdSpesialisasi(dataHandler.getIdSpesialisasi());
        listSpesialisasi.add(targetSpesialisasi);
        pustakawan.setListSpesialisasi(listSpesialisasi);
        pustakawanDb.save(pustakawan);

        return nipPustakawan;
    }
    

    @Override
    public List<PustakawanModel> getPustakawanList() {
        return pustakawanDb.findAll();
    }

    @Override
    public PustakawanModel getPustakawanByIdPustakawan(Long idPustakawan) {
        return pustakawanDb.findByIdPustakawan(idPustakawan);
    }
    

    @Override
    public void addPerpustakaanToPustakawan(PustakawanModel pustakawan, PerpustakaanModel perpustakaan) {
        pustakawan.addPerpustakaan(perpustakaan);
        pustakawanDb.save(pustakawan);
    }

    @Override
    public String changePustakawanData(PustakawanModel pustakawan, ChangePustakawanHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPustakawan();
        Date tanggalLahirPustakawan = null;

        try {
            tanggalLahirPustakawan = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PustakawanModel pustakawanTarget = pustakawanDb.findByIdPustakawan(pustakawan.getIdPustakawan());
        
       
        Timestamp newDateOfBirth = new Timestamp(tanggalLahirPustakawan.getTime());

        String nipPustakawan = pustakawanTarget.getNip();

        if (!newDateOfBirth.equals(pustakawanTarget.getTanggalLahir())) {
            nipPustakawan = createNipPustakawan(pustakawanTarget.getJenisKelamin(), tanggalLahirStr);
            pustakawanTarget.setNip(nipPustakawan);
        }
       
        pustakawanTarget.setNama(dataHandler.getNamaPustakawan());
      
        pustakawanTarget.setJenisKelamin(dataHandler.getJenisKelaminPustakawan());
        pustakawanTarget.setTanggalLahir(tanggalLahirPustakawan);
        pustakawanTarget.setTempatLahir(dataHandler.getTempatLahirPustakawan());
       
        pustakawanDb.save(pustakawanTarget);
        return nipPustakawan;
    }

    @Override
    public void deletePustakawan(PustakawanModel pustakawan) {
       pustakawanDb.delete(pustakawan);
    }

    @Override
    public String createNipPustakawan(int jenisKelamin, String dateOfBirth) {
        String nipPustakawan = "2020"; 

        // Checksum (2 Karakter terakhir) Generator
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();

        String checksum = "";
        for (int i = 0; i < 2; i++) {
            checksum += alphabet.charAt(r.nextInt(N));
        }

        String[] tanggalLahirSplit = dateOfBirth.substring(0, 10).split("/");

        nipPustakawan += tanggalLahirSplit[0];
        nipPustakawan += tanggalLahirSplit[1];
        nipPustakawan += tanggalLahirSplit[2].substring(2, 4);
        nipPustakawan += String.valueOf(jenisKelamin);
        nipPustakawan += checksum;
        return nipPustakawan;
    }
}