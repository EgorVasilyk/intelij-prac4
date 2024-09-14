package com.example.pract2.service;

import com.example.pract2.entity.jurnalEntity;
import com.example.pract2.model.jurnalModel;
import com.example.pract2.repository.InMemoryJurnalRepository;
import com.example.pract2.repository.JurnalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


//Сервисный слой отвечает за бизнес-логику приложения. Он использует репозиторий для выполнения операций с данными и может включать дополнительные проверки или преобразования данных
//так же мы тут можем настроить инкапсуляцию
//А если простыми словами тут происходит разделенние запросов от контроллера к сервису
@Service
public class InMemoryJurnalServiceImpl implements jurnalService {

    private final JurnalRepository jurnalRepository;

    public InMemoryJurnalServiceImpl(JurnalRepository jurnalRepository) {
        this.jurnalRepository = jurnalRepository;
    }

    @Override
    public List<jurnalModel> findAlljurnal() {
        return jurnalRepository.findAll();
    }

    @Override
    public jurnalModel addjurnal(jurnalModel jurnal) {
        return jurnalRepository.save(jurnal);
    }

    @Override
    public jurnalModel updatejurnal(jurnalModel jurnal) {
        return jurnalRepository.save(jurnal);
    }

    @Override
    public void deletejurnal(Long id) {
        jurnalRepository.deleteById(id);
    }
    @Override
    public void deletejurnalAll() {
        jurnalRepository.deleteAll();
    }

    @Override
    public jurnalModel IsDeleteTrue(jurnalModel jurnal) {
        return jurnalRepository.save(jurnal);
    }
}

