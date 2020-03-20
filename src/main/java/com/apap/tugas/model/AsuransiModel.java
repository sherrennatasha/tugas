package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "spesialisasi")
public class AsuransiModel implements Serializable {

    @ManyToMany(mappedBy = "listAsuransi")
    List<PasienModel> listPemilik;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsuransi;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "jenis", nullable = false)
    private String jenis;

    @ManyToMany(mappedBy = "listAsuransi", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PasienModel> listPasien;

    public Long getIdAsuransi() {
        return idAsuransi;
    }

    public void setIdAsuransi(Long idAsuransi) {
        this.idAsuransi = idAsuransi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public List<PasienModel> getListPemilik() {
        return listPemilik;
    }

    public void setListPemilik(List<PasienModel> listPemilik) {
        this.listPemilik = listPemilik;
    }
}
