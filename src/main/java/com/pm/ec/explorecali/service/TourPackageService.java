package com.pm.ec.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.ec.explorecali.domain.TourPackage;
import com.pm.ec.explorecali.repo.TourPackageRepository;

@Service
public class TourPackageService {

	private TourPackageRepository tourPackageRepository;

	@Autowired
	protected TourPackageService(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		
		if(!tourPackageRepository.existsById(code)) {
			tourPackageRepository.save(new TourPackage(code,name));
		}
		return null;
	}
	
	public Iterable<TourPackage> lookup(){
		return tourPackageRepository.findAll();
	}
	
	public long count() {
		return tourPackageRepository.count();
	}
}
