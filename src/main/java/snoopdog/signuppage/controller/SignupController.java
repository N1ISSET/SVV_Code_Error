package snoopdog.signuppage.controller;

import snoopdog.signuppage.model.User;
import snoopdog.signuppage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    // Show the signup form
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    // Process the signup form
    @PostMapping("/signup")
    public String processSignUp(@ModelAttribute("user") User user,
                                @RequestParam("confirmPassword") String confirmPassword,
                                Model model) {

        // Save user to database
        userRepository.save(user);
        model.addAttribute("success", "Sign up successful!");
        return "signup";
    }
}
