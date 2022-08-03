package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {
    @GetMapping ("/roll-dice")
    public String showDiceRoll (){
        return "roll-dice";
    }

  @GetMapping ("/roll-dice/{guess}")
    public String diceRoll (@PathVariable int guess, Model model){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        String message;
        if (guess == randomNum) {
            message = "You guessed the right number";
        } else {
            message = "Sorry try again";
        }
        model.addAttribute("randomNumber", randomNum);
        model.addAttribute("guessNumber", guess);
        model.addAttribute("message", message);
        return "roll-result";
  }



}
