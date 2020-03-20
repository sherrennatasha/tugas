package com.apap.tugas.controller;

import com.apap.tugas.controller.*;
import com.apap.tugas.model.DiagnosisPenyakitModel;
import com.apap.tugas.model.PasienModel;
import com.apap.tugas.service.DiagnosisPenyakitService;
import com.apap.tugas.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DiagnosisPenyakitController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    // Menampilkan seluruh diagnosis penyakit
    @GetMapping(value = "/diagnosis-penyakit-all")
    public String showAllDiagnosisPenyakit(Model model)
    {
        List<DiagnosisPenyakitModel> diagnosisPenyakitList = diagnosisPenyakitService.getDiagnosisPenyakitList();
        model.addAttribute("diagnosisPenyakitList", diagnosisPenyakitList);
        return "diagnosispenyakit-all";
    }

    // Menampilkan diagnosis penyakit berdasarkan id diagnosis
    @GetMapping(value = "/diagnosis-penyakit")
    public String showDiagnosisPenyakitById(@RequestParam(value = "idDiagnosis") Long idDiagnosisPenyakit, Model model)
    {
        DiagnosisPenyakitModel diagnosisPenyakit = diagnosisPenyakitService.getDiagnosisPenyakitByIdDiagnosisPenyakit(idDiagnosisPenyakit);
        List<PasienModel> listPenderita = diagnosisPenyakit.getListPenderita();
        model.addAttribute("penyakit", diagnosisPenyakit);
        model.addAttribute("listPenderita", listPenderita);
        return "diagnosispenyakit-detail";
    }

    // Membuka form untuk menambahkan diagnosis penyakit dari pasien
    @GetMapping(value = "/diagnosis-penyakit/tambah")
    public String showAddDiagnosisPenyakitForm(Model model)
    {
        DiagnosisPenyakitModel diagnosisPenyakit = new DiagnosisPenyakitModel();
        model.addAttribute("penyakit", diagnosisPenyakit);
        return "diagnosispenyakit-add";
    }

    // Mengirimkan data dari form tambah diagnosis penyakit ke database
    @PostMapping(value = "/diagnosis-penyakit/tambah")
    public String submitAddDiagnosisPenyakitForm(@ModelAttribute DiagnosisPenyakitModel diagnosisPenyakit,
                                                 Model model)
    {
        diagnosisPenyakitService.addDiagnosisPenyakit(diagnosisPenyakit);
        model.addAttribute("pesan", "Data diagnosis penyakit berhasil ditambahkan!");
        return "message-info";
    }

    // Melakukan penghapusan data diagnosis penyakit
    @GetMapping(value = "/diagnosis-penyakit/hapus/{idDiagnosisPenyakit}")
    public String deleteDiagnosisPenyakit(@PathVariable("idDiagnosisPenyakit") Long idDiagnosisPenyakit,
                                          Model model)
    {
        diagnosisPenyakitService.deleteDiagnosisPenyakit(idDiagnosisPenyakit);
        model.addAttribute("pesan", "Data diagnosis penyakit berhasil dihapus!");
        return "message-info";
    }

}