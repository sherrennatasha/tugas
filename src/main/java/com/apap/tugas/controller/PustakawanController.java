package com.apap.tugas.controller;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.other.AddPustakawanHandler;
import com.apap.tugas.other.ChangePustakawanHandler;

import com.apap.tugas.service.SpesialisasiService;
import com.apap.tugas.service.PerpustakaanService;
import com.apap.tugas.service.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PustakawanController {

    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private SpesialisasiService spesialisasiService;

    @Autowired
    private PerpustakaanService perpustakaanService;

    
    @GetMapping("/")
    public String showHomePage(Model model) {
        List<PustakawanModel> pustakawanList = pustakawanService.getPustakawanList();
        model.addAttribute("pustakawanList", pustakawanList);
        return "homepage";
    }

    
    @GetMapping(value = "/pustakawan/tambah")
    public String showAddPustakawanForm(@ModelAttribute("addHandler") AddPustakawanHandler addHandler, Model model) {
        List<SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
        model.addAttribute("spesialisasiList", spesialisasiList);
        return "pustakawan-add";
    }

    
    @PostMapping(value = "/pustakawan/tambah")
    public String submitAddPustakawanForm(@ModelAttribute("addHandler") AddPustakawanHandler addHandler, Model model) {
        String nipPustakawan = pustakawanService.addPustakawan(addHandler);
        model.addAttribute(
                "pesan", "Pustakawan " + addHandler.getNamaPustakawan() + " dengan kode pustakawan " + nipPustakawan + " berhasil ditambahkan!"
        );
        return "message-info";
    }

    @GetMapping(value = "/pustakawan/detail/{idPustakawan}")
    public String showPustakawanInfoById(@PathVariable(value = "idPustakawan") Long idPustakawan, Model model) {
    	PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
        model.addAttribute("pustakawan", pustakawan);
        return "pustakawan-detail";
    }
    
    @GetMapping(value = "/pustakawan/update/{idPustakawan}")
    public String showChangePasienForm(@PathVariable Long idPustakawan,
                                       @ModelAttribute("changeHandler") ChangePustakawanHandler changeHandler,
                                       Model model) {
        PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
        model.addAttribute("pustakawan", pustakawan);
        return "pustakawan-change";
    } 
   
    @PostMapping(value = "/pustakawan/update/{idPustakawan}")
    public String showChangePasienForm(@PathVariable Long idPustakawan,
                                       @ModelAttribute PustakawanModel pustakawan,
                                    
                                       @ModelAttribute("changeHandler") ChangePustakawanHandler changeHandler,
                                       Model model) {
        String kodePustakawan = pustakawanService.changePustakawanData(pustakawan, changeHandler);
        model.addAttribute(
                "pesan", "Pustakawan " + changeHandler.getNamaPustakawan() + " berhasil diubah, ID Pustakawan: " + kodePustakawan
        );
        return "message-info";
    }
        

    @GetMapping(value = "/pustakawan/delete/{idPustakawan}")
    public String deleteDiagnosisPenyakit(@PathVariable("idPustakawan") Long idPustakawan, Model model)
    {
    	PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
        pustakawanService.deletePustakawan(pustakawan);
        model.addAttribute("pesan", "Data pustakawan berhasil dihapus!");
        return "message-info";
    }
    
}