package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Service
public interface InstitutionService {

    List<Institution> findAll();
}
