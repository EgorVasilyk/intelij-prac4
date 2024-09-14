package com.example.pract2.controller;

import com.example.pract2.model.jurnalModel;
import com.example.pract2.repository.JurnalRepository;
import com.example.pract2.service.jurnalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


//Основная бизнес-логика нашего проекта
@Controller
public class jurnalController {

    @Autowired
    private JurnalRepository jurnalService;

    @GetMapping("/jurnals")
    public String getAlljurnals(Model model) {
        model.addAttribute("jurnals", jurnalService.findAll()); // просто выгрузка студентов на экран
        return "jurnalList";
    }

    @PostMapping("/jurnals/add")
    public String addjurnal(@Valid @ModelAttribute jurnalModel jurnalModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<jurnalModel> jurnalModels = jurnalService.findAll();
            model.addAttribute("jurnals", jurnalModels);
            model.addAttribute("jurnal", new jurnalModel());
            for (final ObjectError objectError : bindingResult.getAllErrors()){
                model.addAttribute("messedge", objectError.getDefaultMessage());
            }
        }
        jurnalService.save(jurnalModel); // добавление студента в оперативную память(после перезапуска проекта, все данные стираются)
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/update/{id}")
    public String updatejurnal(@Valid @ModelAttribute jurnalModel jurnalModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            List<jurnalModel> jurnalModels = jurnalService.findAll();
            model.addAttribute("jurnals", jurnalModels);
            model.addAttribute("jurnal", new jurnalModel());
            for (final ObjectError objectError : bindingResult.getAllErrors()){
                model.addAttribute("Umessedge", objectError.getDefaultMessage());
            }
        }
        jurnalService.save(jurnalModel); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/delete/{id}")
    public String deletejurnal(@RequestParam Long id) {
        jurnalService.deleteById(id); // Ссылаемся на наш сервис для удаления по id
        return "redirect:/jurnals"; // Здесь мы с вами используем redirect на наш GetMapping, чтобы не создавать много однотипных страниц, считай просто презагружаем страницу с новыми данными
    }

    @PostMapping("/jurnals/id")
    public String findbyMiddleName(Model model, @RequestParam String middleName){
        List<jurnalModel>jurnalModels = jurnalService.findAll();
        model.addAttribute("jurnals", jurnalModels.stream().filter(element -> element.getMiddleName().equals(middleName)).collect(Collectors.toList()));
        model.addAttribute("jurnal", new jurnalModel());
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter1")
    public String filterJurnal1(Model model){
        List<jurnalModel> jurnalModels = jurnalService.findAll();
        model.addAttribute("jurnals", jurnalModels.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("1"))
                .collect(Collectors.toList()));
        model.addAttribute("jurnal", new jurnalModel());
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter2")
    public String filterJurnal2(Model model){
        List<jurnalModel> jurnalModels = jurnalService.findAll();
        model.addAttribute("jurnals", jurnalModels.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("2"))
                .collect(Collectors.toList()));
        model.addAttribute("jurnal", new jurnalModel());
        return "jurnalList";
    }

    @PostMapping("/jurnals/filter3")
    public String filterJurnal3(Model model){
        List<jurnalModel> jurnalModels = jurnalService.findAll();
        model.addAttribute("jurnals", jurnalModels.stream()
                .filter(jurnal -> jurnal.getMiddleName().equals("3"))
                .collect(Collectors.toList()));
        model.addAttribute("jurnal", new jurnalModel());
        return "jurnalList";
    }

    @PostMapping("/jurnals/clear")
    public String ClearJurnal(Model model){
        jurnalService.deleteAll();
        model.addAttribute("jurnals", jurnalService.findAll());
        return "jurnalList";
    }

    @PostMapping("/jurnals/bool")
    public String IsDeleted(@ModelAttribute jurnalModel jurnalModel){
        jurnalModel.setDeleted(true); // Получаем новые данные из полей для обновления
        jurnalService.save(jurnalModel); // Ссылаемся на наш сервис для обновления по id
        return "redirect:/jurnals";
    }
}
