package com.apap.tugas.controller;

import com.apap.tugas.controller.*;
import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.service.PerpustakaanService;
import com.apap.tugas.service.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PerpustakaanController {

    @Autowired
    private PustakawanService pustakawanService;

    @Autowired
    private PerpustakaanService perpustakaanService;

    @GetMapping(value = "/perpustakaan-all")
    public String showAllPerpustakaan(Model model)
    {
        List<PerpustakaanModel> perpustakaanList = perpustakaanService.getPerpustakaanList();
        model.addAttribute("perpustakaanList", perpustakaanList);
        return "perpustakaan-all";
    }

    
    @GetMapping(value = "/perpustakaan")
    public String showPerpustakaanById(@RequestParam(value = "idPerpustakaan") Long idPerpustakaan, Model model)
    {
    	PerpustakaanModel perpustakaan = perpustakaanService.getPerpustakaanByIdPerpustakaan(idPerpustakaan);
        List<PustakawanModel> listPemilik = perpustakaan.getListPemilik();
        model.addAttribute("perpustakaan", perpustakaan);
        model.addAttribute("listPemilik", listPemilik);
        return "perpustakaan-detail";
    }

   
    @GetMapping(value = "/perpustakaan/tambah")
    public String showAddPerpustakaanForm(Model model)
    {
    	PerpustakaanModel perpustakaan = new PerpustakaanModel();
        model.addAttribute("pemilik", perpustakaan);
        return "perpustakaan-add";
    }

    
    @PostMapping(value = "/perpustakaan/tambah")
    public String submitAddPerpustakaanForm(@ModelAttribute PerpustakaanModel perpustakaan,
                                                 Model model)
    {
    	perpustakaanService.addPerpustakaan(perpustakaan);
        model.addAttribute("pesan", "Data perpustakaan berhasil ditambahkan!");
        return "message-info";
    }

   
    @GetMapping(value = "/perpustakaan/delete/{idPerpustakaan}")
    public String deletePerpustakaan(@PathVariable("idPerpustakaan") Long idPerpustakaan,
                                          Model model)
    {
    	perpustakaanService.deletePerpustakaan(idPerpustakaan);
        model.addAttribute("pesan", "Data perpustakaan berhasil dihapus!");
        return "message-info";
    }

}