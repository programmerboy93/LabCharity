package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    @GetMapping("/")
    public String homeAction(){
        return "index";
    }

    @ModelAttribute("totalQuantity")
    public int totalQuantity(){
        return donationService.totalQuantity();
    }

    @ModelAttribute("numberOfDonations")
    public int numberOfDonations(){
        return donationService.numberOfDonations();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.findAll();
    }
}
