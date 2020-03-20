package com.apap.tugas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "emergencyContact")
public class EmergencyContactModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmergencyContact;

    /**@NotNull
    @Size(max = 255)
    @Column(name = "nik", nullable = false)
    private String nik;**/

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 255)
    @Column(name = "nomorHp", nullable = false)
    private String nomorHp;

    @OneToOne(mappedBy = "emergencyContact")
    private PasienModel pustakawan;

    public Long getIdEmergencyContact() {
        return idEmergencyContact;
    }

    public void setIdEmergencyContact(Long idEmergencyContact) {
        this.idEmergencyContact = idEmergencyContact;
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

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public PasienModel getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(PasienModel pustakawan) {
        this.pustakawan = pustakawan;
    }
}