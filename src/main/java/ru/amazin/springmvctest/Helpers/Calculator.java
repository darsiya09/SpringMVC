package ru.amazin.springmvctest.Helpers;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public String getCalculation(int a, int b, String calculationType) {
        String result;
        String prefix = "Result of calculations is: ";

        switch (calculationType) {
            case "multiplication":
                result = prefix + (a * b);
                break;
            case "addition":
                result = prefix + (a + b);
                break;
            case "subtraction":
                result = prefix + (a - b);
                break;
            case "division":
                result = prefix + ((double) a / b);
                break;
            default:
                result = "Operation cannot be found";
        }
        return result;
    }
}
