package com.karoljanowski.controller;

import com.karoljanowski.domain.Pracownik;
import com.karoljanowski.repository.PracownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Karol Janowski on 2017-08-03.
 */
@Controller
public class HomeController {

    @Autowired
    private PracownikRepository pracownikRepository;

    @RequestMapping("/")
    public String index(Model model){
        List<Pracownik> pracownikList;
        pracownikList = pracownikRepository.findAll();
        model.addAttribute("pracownikList", pracownikList);
        return "index";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model){
        Pracownik pracownik =pracownikRepository.findOne(id);
        pracownikRepository.delete(pracownik);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("id") Integer id, Model model){
        Pracownik pracownik =pracownikRepository.findOne(id);
        model.addAttribute(pracownik);
        return "edytujPracownika";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute("pracownik") Pracownik pracownik, HttpServletRequest request){
        pracownikRepository.save(pracownik);
        return "redirect:/";
    }


}
