package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class AccountController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "account/register";
    }

    @PostMapping
    public String register(@Valid UserDto userDto, BindingResult result) {
        if (userRepository.existsByEmailIgnoreCase(userDto.getEmail())) {
            result.addError(new FieldError("userDto","email", "Email jest w bazie danych"));
        }
        if (result.hasErrors()) {
            return "account/register";
        }

        userService.save(userDto);
        return "redirect:/";
    }
}
