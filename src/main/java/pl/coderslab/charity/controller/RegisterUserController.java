package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserDtoRegister;
import pl.coderslab.charity.service.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
@Slf4j
public class RegisterUserController {

    private final UserService userService;

    @GetMapping
    public String register(Model model) {

        model.addAttribute("user", new UserDtoRegister());
        return "account/register";
    }

    @PostMapping
    public String register(@ModelAttribute("user") @Valid UserDtoRegister userDtoRegister, BindingResult result) {
//        if (userService.validUser(userDtoRegister, result)) {
//            return "account/register";
//        }
        userService.registerNewUserAccount(userDtoRegister);
        return "redirect:/";
    }

    @GetMapping("/{token}")
    public String confirmRegister(@PathVariable String token, Model model) {
        model.addAttribute("msg", userService.accountActivation(token));
        return "redirect:/login";
    }
}
