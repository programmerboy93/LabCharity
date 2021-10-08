package pl.coderslab.charity.service.donation;

import org.springframework.stereotype.Service;

@Service
public interface DonationService {
    int numberOfDonations();

    int totalQuantity();
}
