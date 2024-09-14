package com.example.pract2.service;

import com.example.pract2.model.jurnalModel;

import java.util.List;

public interface jurnalService {
    public List<jurnalModel> findAlljurnal();
    public jurnalModel addjurnal(jurnalModel jurnal);
    public jurnalModel updatejurnal(jurnalModel jurnal);
    public void deletejurnal(Long id);
    public void deletejurnalAll();

    public jurnalModel IsDeleteTrue(jurnalModel jurnal);
}
