package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> country() {
        return countryService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView listCity() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormcreateCity() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCity(@ModelAttribute("city") City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        modelAndView.addObject("city", new City());
        redirectAttributes.addFlashAttribute("messages", "create new city successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("eror.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editCity(@ModelAttribute City city, RedirectAttributes redirectAttributes){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        redirectAttributes.addFlashAttribute("messages","edit successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if (city!=null){
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("city",city);
            modelAndView.addObject("messages","Are you sure you want to delete city:");
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public ModelAndView deleteCity(@ModelAttribute("cities") City city ){
        cityService.remove(city.getCityId());
        ModelAndView modelAndView = new ModelAndView("redirect:list");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewproduct(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("city", city);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
