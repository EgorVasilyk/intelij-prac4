package com.example.pract2.service;

import com.example.pract2.model.workerModel;

import java.util.List;

public interface workerService {
    public List<workerModel> findAllworker();
    public workerModel findworkerById(int id);
    public workerModel addworker(workerModel worker);
    public workerModel updateworker(workerModel worker);
    public void deleteworker(int id);
}
