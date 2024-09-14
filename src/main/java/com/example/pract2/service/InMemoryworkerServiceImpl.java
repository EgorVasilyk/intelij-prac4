package com.example.pract2.service;

import com.example.pract2.entity.workerEntity;
import com.example.pract2.model.workerModel;
import com.example.pract2.repository.InMemoryworkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//Сервисный слой отвечает за бизнес-логику приложения. Он использует репозиторий для выполнения операций с данными и может включать дополнительные проверки или преобразования данных
//так же мы тут можем настроить инкапсуляцию
//А если простыми словами тут происходит разделенние запросов от контроллера к сервису
@Service
public class InMemoryworkerServiceImpl implements workerService {

    private final InMemoryworkerRepository workerRepository;

    public InMemoryworkerServiceImpl(InMemoryworkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<workerModel> findAllworker() {
        return workerRepository.findAllworkers();
    }

    @Override
    public workerModel findworkerById(int id) {
        return workerRepository.findworkerById(id);
    }

    @Override
    public workerModel addworker(workerModel worker) {
        return workerRepository.addworker(worker);
    }

    @Override
    public workerModel updateworker(workerModel worker) {
        return workerRepository.updateworker(worker);
    }

    @Override
    public void deleteworker(int id) {
        workerRepository.deleteworker(id);
    }
}

