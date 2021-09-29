package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

import java.util.Optional;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query("SELECT SUM(d.quantity) FROM Donation d WHERE d.quantity > 0")
    Optional<Integer> sumQuantity();

    @Query("SELECT COUNT(d.id) FROM Donation d")
    Optional<Integer> numberOfDonations();
}
