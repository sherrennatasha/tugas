package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable {

    @ManyToMany(mappedBy = "listPerpustakaan", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PustakawanModel> listPemilik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerpustakaan;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;
    
    @NotNull
    @Size(max = 500)
    @Column(name = "lokasi", nullable = false)
    private String lokasi;
    
    public Long getIdPerpustakaan() {
        return idPerpustakaan;
    }

    public void setIdPerpustakaan(Long idPerpustakaan) {
        this.idPerpustakaan = idPerpustakaan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<PustakawanModel> getListPemilik() {
        return listPemilik;
    }

    public void setListPemilik(List<PustakawanModel> listPemilik) {
        this.listPemilik = listPemilik;
    }
}