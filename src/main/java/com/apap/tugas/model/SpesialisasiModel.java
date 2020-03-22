package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class SpesialisasiModel implements Serializable {

    @ManyToMany(mappedBy = "listSpesialisasi")
    List<PustakawanModel> listPemilik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpesialisasi;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 500)
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @ManyToMany(mappedBy = "listSpesialisasi", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PustakawanModel> listPustakawan;
    
    @OneToOne(mappedBy = "spesialisasi")
    private PustakawanModel pustakawan;
    
    public Long getIdSpesialisasi() {
        return idSpesialisasi;
    }

    public void setIdSpesialisasi(Long idSpesialisasi) {
        this.idSpesialisasi = idSpesialisasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public List<PustakawanModel> getListPemilik() {
        return listPemilik;
    }

    public void setListPemilik(List<PustakawanModel> listPemilik) {
        this.listPemilik = listPemilik;
    }
    public PustakawanModel getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(PustakawanModel pustakawan) {
        this.pustakawan = pustakawan;
    }
}
