package com.edson.curriculo.controller;

import com.edson.curriculo.model.Curriculo;
import com.edson.curriculo.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CurriculoController {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @GetMapping("/")
    public String getCurriculos(Model model) {
        model.addAttribute("curriculos", curriculoRepository.findAll());
        model.addAttribute("curriculo", new Curriculo());
        return "index";
    }

    @PostMapping("/curriculos")
    public String createCurriculo(@ModelAttribute Curriculo curriculo) {
        curriculoRepository.save(curriculo);
        return "redirect:/";
    }

    @GetMapping("/curriculos/{id}/edit")
    public String editCurriculo(@PathVariable Long id, Model model) {
        Optional<Curriculo> curriculoOpt = curriculoRepository.findById(id);
        if (curriculoOpt.isPresent()) {
            model.addAttribute("curriculo", curriculoOpt.get());
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/curriculos/{id}")
    public String updateCurriculo(@PathVariable Long id, @ModelAttribute Curriculo curriculo) {
        curriculo.setId(id);
        curriculoRepository.save(curriculo);
        return "redirect:/";
    }

    @GetMapping("/curriculos/{id}/delete")
    public String deleteCurriculo(@PathVariable Long id) {
        curriculoRepository.deleteById(id);
        return "redirect:/";
}
}
