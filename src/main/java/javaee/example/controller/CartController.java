package javaee.example.controller;

import javaee.example.CartFacade;
import javaee.example.TelefonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Deny on 15.04.2017.
 */
@Controller
public class CartController {
    @Autowired
    CartFacade cartFacade;
    @Autowired
    TelefonRepository telefonRepository;
    @RequestMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") int id, Model model){
        cartFacade.getCart().add(telefonRepository.findTelefonById(id));
        model.addAttribute("telefons", telefonRepository.findAll());
        return "redirect:/";

    }
    @RequestMapping("/cart")
    public String Cart (Model model) {
        model.addAttribute("cart", cartFacade.getCart());
        return "cart";
    }
    @RequestMapping ("/removeToCart")
    public String removeToCart (@RequestParam int id) {
        cartFacade.getCart().remove(telefonRepository.findTelefonById(id));
        return "redirect:cart";
    }
}
