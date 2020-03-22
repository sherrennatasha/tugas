package com.apap.tugas.other;

public class AddPustakawanHandler {

    private String namaPustakawan;
    private Integer jenisKelaminPustakawan;
    private String tanggalLahirPustakawan;
    private String tempatLahirPustakawan;
    private String namaSpesialisasi;

    private Long idSpesialisasi;

    public Long getIdSpesialisasi() {
        return idSpesialisasi;
    }

    public void setIdSpesialisasi(Long idSpesialisasi) {
        this.idSpesialisasi = idSpesialisasi;
    }
    
    public String getNamaSpesialisasi() {
    	return namaSpesialisasi;
    }
    public void setNamaSpesialisasi(String namaSpesialisasi) {
    	this.namaSpesialisasi = namaSpesialisasi;
    }

    public String getNamaPustakawan() {
        return namaPustakawan;
    }

    public void setNamaPustakawan(String namaPustakawan) {
        this.namaPustakawan = namaPustakawan;
    }

    public Integer getJenisKelaminPustakawan() {
        return jenisKelaminPustakawan;
    }

    public void setJenisKelaminPustakawan(Integer jenisKelaminPustakawan) {
        this.jenisKelaminPustakawan = jenisKelaminPustakawan;
    }

    public String getTanggalLahirPustakawan() {
        return tanggalLahirPustakawan;
    }

    public void setTanggalLahirPustakawan(String tanggalLahirPustakawan) {
        this.tanggalLahirPustakawan = tanggalLahirPustakawan;
    }

    public String getTempatLahirPustakawan() {
        return tempatLahirPustakawan;
    }

    public void setTempatLahirPustakawan(String tempatLahirPustakawan) {
        this.tempatLahirPustakawan = tempatLahirPustakawan;
    }

}