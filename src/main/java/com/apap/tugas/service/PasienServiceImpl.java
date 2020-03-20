package com.apap.tugas.service;

import com.apap.tugas.model.AsuransiModel;
import com.apap.tugas.model.DiagnosisPenyakitModel;
//import com.apap.tugas.model.EmergencyContactModel;
import com.apap.tugas.model.PasienModel;
import com.apap.tugas.other.AddPasienHandler;
import com.apap.tugas.other.ChangePasienHandler;
import com.apap.tugas.repository.AsuransiDb;
import com.apap.tugas.repository.EmergencyContactDb;
import com.apap.tugas.repository.PasienDb;
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
public class PasienServiceImpl implements PasienService {

    @Autowired
    PasienDb pasienDb;

    @Autowired
    EmergencyContactDb emergencyContactDb;

    @Autowired
    AsuransiDb asuransiDb;

    @Override
    public String addPustakawan(AddPasienHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPustakawan();
        Date tanggalLahirPustakawan = null;

        try {
            tanggalLahirPustakawan = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Membuat emergency contact baru
        /**EmergencyContactModel contact = new EmergencyContactModel();
        contact.setNama(dataHandler.getNamaEmergency());
        contact.setNik(dataHandler.getNikEmergency());
        contact.setNomorHp(dataHandler.getNomorHpEmergency());
        emergencyContactDb.save(contact);
		**/
        // Membuat pasien baru
        PasienModel pustakawan = new PasienModel();

        String nipPustakawan = createNipPustakawan(dataHandler.getJenisKelaminPustakawan(), tanggalLahirStr);
        pustakawan.setNip(nipPustakawan);

        pustakawan.setNama(dataHandler.getNamaPustakawan());
        //pustakawan.setNik(dataHandler.getNikPasien());
        pustakawan.setJenisKelamin(dataHandler.getJenisKelaminPustakawan());
        pustakawan.setTanggalLahir(tanggalLahirPustakawan);
        pustakawan.setTempatLahir(dataHandler.getTempatLahirPustakawan());
        //pustakawan.setEmergencyContact(contact);

        // Memasukkan asuransi ke data pasien
        List<AsuransiModel> listAsuransi = new ArrayList<>();

        AsuransiModel targetAsuransi = asuransiDb.findByIdAsuransi(dataHandler.getIdAsuransi());
        listAsuransi.add(targetAsuransi);
        pustakawan.setListAsuransi(listAsuransi);
        pasienDb.save(pustakawan);

        return nipPustakawan;
    }

    @Override
    public List<PasienModel> getPustakawanList() {
        return pasienDb.findAll();
    }

    @Override
    public PasienModel getPustakawanByIdPustakawan(Long idPustakawan) {
        return pasienDb.findByIdPustakawan(idPustakawan);
    }
    
    /**
    @Override
    public PasienModel getPasienByNikPasien(String nik) {
        return pasienDb.findByNik(nik);
    }**/

    @Override
    public void addDiagnosisToPustakawan(PasienModel pustakawan, DiagnosisPenyakitModel diagnosisPenyakit) {
        pustakawan.addDiagnosisPenyakit(diagnosisPenyakit);
        pasienDb.save(pustakawan);
    }

    @Override
    public String changePustakawanData(PasienModel pustakawan, ChangePasienHandler dataHandler) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahirStr = dataHandler.getTanggalLahirPustakawan();
        Date tanggalLahirPustakawan = null;

        try {
            tanggalLahirPustakawan = formatter.parse(tanggalLahirStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PasienModel pustakawanTarget = pasienDb.findByIdPustakawan(pustakawan.getIdPustakawan());
        
        /**EmergencyContactModel contactTarget = emergencyContactDb.findByIdEmergencyContact(
                pustakawan.getEmergencyContact().getIdEmergencyContact()
        );**/

        Timestamp newDateOfBirth = new Timestamp(tanggalLahirPustakawan.getTime());

        String nipPustakawan = pustakawanTarget.getNip();

        if (!newDateOfBirth.equals(pustakawanTarget.getTanggalLahir())) {
            nipPustakawan = createNipPustakawan(pustakawanTarget.getJenisKelamin(), tanggalLahirStr);
            pustakawanTarget.setNip(nipPustakawan);
        }
        /**
        contactTarget.setNama(dataHandler.getNamaEmergency());
        contactTarget.setNik(dataHandler.getNikEmergency());
        contactTarget.setNomorHp(dataHandler.getNomorHpEmergency());
        emergencyContactDb.save(contactTarget);
		**/
        pustakawanTarget.setNama(dataHandler.getNamaPustakawan());
       // pasienTarget.setNik(dataHandler.getNikPasien());
        pustakawanTarget.setJenisKelamin(dataHandler.getJenisKelaminPustakawan());
        pustakawanTarget.setTanggalLahir(tanggalLahirPustakawan);
        pustakawanTarget.setTempatLahir(dataHandler.getTempatLahirPustakawan());
       // pasienTarget.setEmergencyContact(contactTarget);
        pasienDb.save(pustakawanTarget);
        return nipPustakawan;
    }

    @Override
    public void deletePustakawan(PasienModel pustakawan) {
        pasienDb.delete(pustakawan);
    }

    @Override
    public String createNipPustakawan(int jenisKelamin, String dateOfBirth) {
        String nipPasien = "2020"; 

        // Checksum (2 Karakter terakhir) Generator
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int N = alphabet.length();

        Random r = new Random();

        String checksum = "";
        for (int i = 0; i < 2; i++) {
            checksum += alphabet.charAt(r.nextInt(N));
        }

        String[] tanggalLahirSplit = dateOfBirth.substring(0, 10).split("/");

        nipPasien += tanggalLahirSplit[0];
        nipPasien += tanggalLahirSplit[1];
        nipPasien += tanggalLahirSplit[2].substring(2, 4);
        nipPasien += String.valueOf(jenisKelamin);
        nipPasien += checksum;
        return nipPasien;
    }
}