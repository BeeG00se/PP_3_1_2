package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private CarsService service;

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(name = "count", required = false, defaultValue = "0") int x) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "pink", 150));
        cars.add(new Car("Nissan", "gold", 300));
        cars.add(new Car("Jeep", "white", 200));
        cars.add(new Car("Lamborghini", "blue", 250));
        cars.add(new Car("Mercedes", "black", 500));
        model.addAttribute("cars", service.getCars(cars, x));
        return "cars";
    }

}