package com.apap.tugas.service;

import com.apap.tugas.model.DiagnosisPenyakitModel;
import com.apap.tugas.repository.DiagnosisPenyakitDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisPenyakitServiceImpl implements DiagnosisPenyakitService{

    @Autowired
    DiagnosisPenyakitDb diagnosisPenyakitDb;

    @Override
    public void addDiagnosisPenyakit(DiagnosisPenyakitModel diagnosisPenyakit){
        diagnosisPenyakitDb.save(diagnosisPenyakit);
    }

    @Override
    public List<DiagnosisPenyakitModel> getDiagnosisPenyakitList(){
        return diagnosisPenyakitDb.findAll();
    }

    @Override
    public DiagnosisPenyakitModel getDiagnosisPenyakitByIdDiagnosisPenyakit(Long idDiagnosisPenyakit){
        return diagnosisPenyakitDb.findByIdDiagnosisPenyakit(idDiagnosisPenyakit);
    }

    @Override
    public void deleteDiagnosisPenyakit(Long idDiagnosisPenyakit){
        DiagnosisPenyakitModel diagnosisPenyakit = getDiagnosisPenyakitByIdDiagnosisPenyakit(idDiagnosisPenyakit);
        diagnosisPenyakitDb.delete(diagnosisPenyakit);
    }
}
