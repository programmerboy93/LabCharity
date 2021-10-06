package pl.coderslab.charity.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql("/insert_data.sql")
public class DonationRepositoryTestJPA {

    @Autowired
    private DonationRepository donationRepository;

    @Test
    public void sum_of_donations() {
        donationRepository.deleteById(1L);
        int size = donationRepository.numberOfDonations();
        Assert.assertEquals(3,size);
    }



}