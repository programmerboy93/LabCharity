package pl.coderslab.charity.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
public class DonationRepositoryTest {

    @Autowired
    private DonationRepository donationRepository;

    @Test
    public void sumQuantity() {
        Integer sumQuantity = donationRepository.sumQuantity().get();
        Assert.assertEquals((Integer)12,sumQuantity);
    }

    @Test
    public void numberOfDonations() {
        Integer numberOfDonations = donationRepository.numberOfDonations();
        Assert.assertEquals((Integer)4,numberOfDonations);
    }

    @Test
    public void saveOneDonation(){
        Donation donation = new Donation();
        Category category = new Category();
        Institution institution = new Institution();
        institution.setId(1L);
        category.setId(1L);

        donation.setCity("Września");
        donation.setQuantity(10);
        donation.setInstitution(institution);
        donation.setCategories(Collections.singletonList(category));
        donation.setPickUpDate(LocalDate.now());
        donation.setPickUpTime(LocalTime.now());
        donation.setZipCode("62-231");
        Donation result = donationRepository.save(donation);
        assertThat(donation, equalTo(result));
    }

    @Test
    public void editOneDonation(){
        Donation donation = donationRepository.findById(1L).get();
        donation.setZipCode("11110");
        Donation result = donationRepository.save(donation);
        assertThat(donation, equalTo(result));
    }

    @Test
    public void destroyOneDonation(){
        donationRepository.deleteById(1L);
        Donation result = donationRepository.findById(1L).orElse(null);
        assertNull(result);
    }

    @Test
    public void readOneDonation(){
        Donation donation = donationRepository.findById(1L).get();
        assertThat(donation.getId(),equalTo(1L));
    }

    @Test
    public void readAllDonation(){
        List<Donation> donationList = donationRepository.findAll();
        assertThat(donationList.size(),equalTo(4));
    }
}