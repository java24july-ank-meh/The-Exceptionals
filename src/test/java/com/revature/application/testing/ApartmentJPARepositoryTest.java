package com.revature.application.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.application.model.Apartment;
import com.revature.application.repository.ApartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApartmentJPARepositoryTest {
	
	@Autowired
	ApartmentRepository apartmentRepository;
	
	@Test
	public void ApartmentJPAMethods() {
		
		apartmentRepository.save(new Apartment());
        apartmentRepository.flush();

        apartmentRepository.saveAndFlush(new Apartment());

        apartmentRepository.save(new Apartment());

        apartmentRepository.findAll().forEach(System.out::println);

        apartmentRepository.deleteInBatch(apartmentRepository.findAll());
		
	}

}
