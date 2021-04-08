package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(1995);
		assertEquals("The Macallan Anniversary Malt", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindAllDistilleriesForRegion__Highland(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Highland");
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
	}

	@Test
	public void canFindAllWhiskiesByDistilleryNameAndAge(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge("Glendronach", 15);
		assertEquals("The Glendronach Revival", foundWhiskies.get(0).getName());
	}


	@Test
	public void canFindAllWhiskiesByRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals("The Macallan Anniversary Malt", foundWhiskies.get(0).getName());
	}

	@Test
	public void canFindDistThatHaveWhiskiesWithParticularAge(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesAge(12);
		assertEquals("Glendronach", foundDistilleries.get(0).getName());
	}

}