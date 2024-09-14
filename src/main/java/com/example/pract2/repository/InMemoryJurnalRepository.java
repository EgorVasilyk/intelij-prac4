package com.example.pract2.repository;

import com.example.pract2.model.jurnalModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository

//Репозиторий отвечает за хранение и управление данными студентов в памяти. Он предоставляет методы для выполнения операций(обычные CRUD действия с данными)
public class InMemoryJurnalRepository {
    private List<jurnalModel> jurnals = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1); // Генерация уникального ID

    public jurnalModel addjurnal(jurnalModel jurnal) {
        jurnals.add(jurnal);
        return jurnal;
    }

    public jurnalModel updatejurnal(jurnalModel jurnal) {
        for (int i = 0; i < jurnals.size(); i++) {
            if (jurnals.get(i).getId() == jurnal.getId()) {
                jurnals.set(i, jurnal);
                return jurnal;
            }
        }
        return null; // Студент не найден
    }

    public void deletejurnal(int id) {
        jurnals.removeIf(jurnal -> jurnal.getId() == id);
    }

    public List<jurnalModel> findAlljurnals() {
        return new ArrayList<>(jurnals);
    }

    public List<jurnalModel> findjurnalByMiddleName(String middleName) {
        return jurnals.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals(middleName))
                .collect(Collectors.toList());
    }

    public List<jurnalModel> filterJurnal1() {
        return jurnals.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("1"))
                .collect(Collectors.toList());
    }

    public List<jurnalModel> filterJurnal2() {
        return jurnals.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("2"))
                .collect(Collectors.toList());
    }

    public List<jurnalModel> filterJurnal3() {
        return jurnals.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("3"))
                .collect(Collectors.toList());
    }

    public void deletejurnalAll(){
        jurnals.clear();
    }

    public jurnalModel IsDeleteTrue(jurnalModel jurnal){//логическое удаление
        for (int i = 0; i<jurnals.size(); i++){
            if (jurnals.get(i).getId() == jurnal.getId()){
                jurnal.setDeleted(true);
                jurnals.set(i, jurnal);
                return jurnal;
            }
        }
        return null;
    }
}

