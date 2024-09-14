package com.example.pract2.repository;

import com.example.pract2.model.workerModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository

//Репозиторий отвечает за хранение и управление данными студентов в памяти. Он предоставляет методы для выполнения операций(обычные CRUD действия с данными)
public class InMemoryworkerRepository {
    private List<workerModel> workers = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // Генерация уникального ID

    public workerModel addworker(workerModel worker) {
        workers.add(worker);
        return worker;
    }

    public workerModel updateworker(workerModel worker) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId() == worker.getId()) {
                workers.set(i, worker);
                return worker;
            }
        }
        return null; // Студент не найден
    }

    public void deleteworker(int id) {
        workers.removeIf(worker -> worker.getId() == id);
    }

    public List<workerModel> findAllworkers() {
        return new ArrayList<>(workers);
    }

    public workerModel findworkerById(int id) {
        return workers.stream()
                .filter(worker -> worker.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
