package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;

@Service
public interface DonationService {
    int numberOfDonations();

    int totalQuantity();
}
