package ru.amazin.springmvctest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.amazin.springmvctest.Helpers.Calculator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    private Calculator calculator;

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname", required = false) String surname,
                        Model model) {
        System.out.println("Hi, " + name + " " + surname + "!");
        model.addAttribute("message", "Hi, " + name + " " + surname + "!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "first/goodbye";
    }

    @GetMapping("/simple/calculator")
    public String simpleCalculator(@RequestParam(value = "a") int a,
                                   @RequestParam(value = "b") int b,
                                   @RequestParam(value = "operation") String operation,
                                   Model model) {

        model.addAttribute("result", calculator.getCalculation(a, b, operation));
        return "simple/calculator";
    }
}
