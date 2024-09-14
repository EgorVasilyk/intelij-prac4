package com.example.pract2.controller;

import com.example.pract2.model.ModelUser;
import com.example.pract2.model.RoleEnum;
import com.example.pract2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String regView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String reg(ModelUser user, Model model) {
        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "regis";
        }
        if (user.getPassword().length()<4) {
            model.addAttribute("message", "Пароль должен быть от 4 до 12 символов");
            return "regis";
        }
        if (user.getPassword().length()>12) {
            model.addAttribute("message", "Пароль должен быть от 4 до 12 символов");
            return "regis";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(RoleEnum.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
