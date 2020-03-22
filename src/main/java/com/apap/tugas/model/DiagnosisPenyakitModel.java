package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "diagnosisPenyakit")
public class DiagnosisPenyakitModel implements Serializable {

    @ManyToMany(mappedBy = "listDiagnosisPenyakit", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PustakawanModel> listPenderita;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiagnosisPenyakit;

    @NotNull
    @Size(max = 13)
    @Column(name = "nip", nullable = false, unique=true)
    private String nip;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    public Long getIdDiagnosisPenyakit() {
        return idDiagnosisPenyakit;
    }

    public void setIdDiagnosisPenyakit(Long idDiagnosisPenyakit) {
        this.idDiagnosisPenyakit = idDiagnosisPenyakit;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<PustakawanModel> getListPenderita() {
        return listPenderita;
    }

    public void setListPenderita(List<PustakawanModel> listPenderita) {
        this.listPenderita = listPenderita;
    }
}