package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
@AllArgsConstructor
public class DonationController {

    @Autowired
    private final DonationRepository donationRepository;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "user/addDonation";
    }

    @PostMapping("/add")
    public String add(@Valid Donation donation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/addDonation";
        }
        donationRepository.save(donation);
        return "user/addDonation";
    }


}
