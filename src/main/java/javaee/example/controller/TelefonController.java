package javaee.example.controller;

import javaee.example.TelefonRepository;
import javaee.example.domain.Telefon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
public class TelefonController {

    @Autowired
    TelefonRepository telefonRepository;

    @RequestMapping("/")
    public String showAll(Model model) {
        model.addAttribute("telefons", telefonRepository.findAll());
        return "hello";
    }

    @RequestMapping("/edit/{id}")
    public String updateWatch(@PathVariable("id") int id, Model model) {
        model.addAttribute("telefon", telefonRepository.findTelefonById(id));
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String saveUpdate(@PathVariable long id, @Valid @ModelAttribute("telefon") Telefon telefon, BindingResult bindingResult, Model model) {
      if(bindingResult.hasErrors()){
          model.addAttribute("telefon", telefon);
          return "edit";
      }
        telefonRepository.save(telefon);
        model.addAttribute("telefons", telefonRepository.findAll());
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        telefonRepository.delete(id);
        model.addAttribute("telefons", telefonRepository.findAll());
        return "redirect:/";
    }

    @RequestMapping("/view/{id}")
    public String Watch(@PathVariable("id") int id, Model model) {
        model.addAttribute("telefon", telefonRepository.findTelefonById(id));
        return "view";
    }
}

