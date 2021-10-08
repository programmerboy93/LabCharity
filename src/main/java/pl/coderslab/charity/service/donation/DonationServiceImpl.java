package pl.coderslab.charity.service.donation;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.repository.DonationRepository;

@Component
@Primary
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Override
    public int numberOfDonations() {
        return donationRepository.numberOfDonations();
    }

    @Override
    public int totalQuantity() {
        return donationRepository.sumQuantity().orElse(0);
    }
}
