package com.example.pract2.controller;

import com.example.pract2.model.workerModel;
import com.example.pract2.repository.WorkerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//Основная бизнес-логика нашего проекта
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class workerController {

    @Autowired
    private WorkerRepository workerService;

    @GetMapping("/workers")
    public String getAllworkers(Model model) {
        model.addAttribute("workers", workerService.findAll()); // просто выгрузка студентов на экран
        return "workerList";
    }

    @PostMapping("/workers/add")
    public String addworker(@Valid @ModelAttribute workerModel workerModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<workerModel> workerModels = workerService.findAll();
            model.addAttribute("workers", workerModels);
            model.addAttribute("worker", new workerModel());
            for (final ObjectError objectError : bindingResult.getAllErrors()){
                model.addAttribute("messedge", objectError.getDefaultMessage());
            }
        } // тут мы получаем данные с главных полей, id задается автоматически из нашего репозитория
        workerService.save(workerModel); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/workers/update/{id}")
    public String updateworker(@Valid @ModelAttribute workerModel workerModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<workerModel> workerModels = workerService.findAll();
            model.addAttribute("workers", workerModels);
            model.addAttribute("worker", new workerModel());
            for (final ObjectError objectError : bindingResult.getAllErrors()){
                model.addAttribute("Umessedge", objectError.getDefaultMessage());
            }
        }
        workerService.save(workerModel); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/workers/delete/{id}")
    public String deleteworker(@RequestParam Long id) {
        workerService.deleteById(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/workers"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }
}
