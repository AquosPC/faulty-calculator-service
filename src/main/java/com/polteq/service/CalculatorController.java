package com.polteq.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/sum")
    public double sum(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b) {
        return a / b;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/power")
    public double power(@RequestParam double a, @RequestParam double b) {
        return Math.pow(a, b);
    }

    @GetMapping("/sqrt")
    public double sqrt(@RequestParam double a) {
        return Math.sqrt(a);
    }

    @GetMapping("/modulo")
    public int modulo(@RequestParam int a, @RequestParam int b) {
        return a % b;
    }

    @GetMapping("/average")
    public double average(@RequestParam List<Double> numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.size();
    }

    @GetMapping("/factorial")
    public int factorial(@RequestParam int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
