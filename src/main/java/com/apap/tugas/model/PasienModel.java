package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pustakawan")
public class PasienModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPustakawan;

    @NotNull
    @Size(max = 13)
    @Column(name = "nip", nullable = false, unique=true)
    private String nip;

    /**@NotNull
    @Column(name = "nik", nullable = false)
    private String nik;**/

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "jenisKelamin", nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Column(name = "tanggalLahir", nullable = false)
    private Date tanggalLahir;

    @NotNull
    @Column(name = "tempatLahir", nullable = false)
    private String tempatLahir;

   // @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idEmergencyContact", referencedColumnName = "idEmergencyContact")
    //private EmergencyContactModel emergencyContact;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pustakawan_spesialisasi",
            joinColumns = @JoinColumn(name = "pustakawanId"),
            inverseJoinColumns = @JoinColumn(name = "spesialisasiId"))
    private List<AsuransiModel> listSpesialisasi;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "pustakawan_diagnosis_penyakit",
            joinColumns = @JoinColumn(name = "pustakawanId"),
            inverseJoinColumns = @JoinColumn(name = "diagnosisPenyakitId"))
    private List<DiagnosisPenyakitModel> listDiagnosisPenyakit;

    public Long getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(Long idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    /**public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }**/

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    /**public EmergencyContactModel getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactModel emergencyContact) {
        this.emergencyContact = emergencyContact;
    }**/

    public List<AsuransiModel> getListSpesialisasi() {
        return listSpesialisasi;
    }

    public void setListSpesialisasi(List<AsuransiModel> listSpesialisasi) {
        this.listSpesialisasi = listSpesialisasi;
    }

    public void addSpesialisasi(AsuransiModel spesialisasi){
        listSpesialisasi.add(spesialisasi);
    }

    public void removeSpesialisasi(AsuransiModel spesialisasi){
        listSpesialisasi.remove(spesialisasi);
    }

    public List<DiagnosisPenyakitModel> getListDiagnosisPenyakit() {
        return listDiagnosisPenyakit;
    }

    public void setListDiagnosisPenyakit(List<DiagnosisPenyakitModel> listDiagnosisPenyakit) {
        this.listDiagnosisPenyakit = listDiagnosisPenyakit;
    }

    public void addDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakit){
        listDiagnosisPenyakit.add(diagnosisPenyakit);
    }

    public void removeDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakitModel){
        listDiagnosisPenyakit.remove(diagnosisPenyakitModel);
    }
}