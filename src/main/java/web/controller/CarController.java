package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.serves.CarService;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping()
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        if (count != null && count >= 5) {
            model.addAttribute("cars", carService.getCars());
        } else if (count != null && count > 0) {
            model.addAttribute("cars", carService.getShortListCars(count));
        } else {
            model.addAttribute("cars", carService.getCars());
        }
        return "cars";
    }

    @GetMapping(value = "/{id}")
    public String printSomeCar(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("car", carService.getSomeCar(id));
        return "car";
    }


}
