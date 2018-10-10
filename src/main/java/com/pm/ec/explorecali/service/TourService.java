package com.pm.ec.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.ec.explorecali.domain.Difficulty;
import com.pm.ec.explorecali.domain.Region;
import com.pm.ec.explorecali.domain.Tour;
import com.pm.ec.explorecali.domain.TourPackage;
import com.pm.ec.explorecali.repo.TourPackageRepository;
import com.pm.ec.explorecali.repo.TourRepository;

@Service
public class TourService {

	private TourPackageRepository tourPackageRepository;
	private TourRepository tourRepository;

	@Autowired
	public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
		this.tourRepository = tourRepository;
	}
	
	public Tour createTour(String title, String description, String blurb, Integer price,
            String duration, String bullets,
            String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
				
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(()->new RuntimeException("Tour Package Does Not Exist: " + tourPackageName));
		
		return tourRepository.save(new Tour(title, description,blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));
	}

	public Iterable<Tour> lookup(){
		return tourRepository.findAll();
	}
	
	public long total() {
		return tourRepository.count();
	}
	
}
