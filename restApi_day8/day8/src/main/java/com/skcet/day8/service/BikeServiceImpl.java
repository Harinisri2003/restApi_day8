package com.skcet.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day8.model.Bike;
import com.skcet.day8.repository.BikeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BikeServiceImpl implements BikeService{
    
	@Autowired
	private BikeRepository bikeRepository;
	
	@Override
	public boolean addValues(Bike bike) {
		// TODO Auto-generated method stub
		boolean isExist=bikeRepository.existsByBikeId(bike.getBikeId());
		if(!isExist)
		{
			bikeRepository.save(bike);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public Bike getQuery(int year) {
		// TODO Auto-generated method stub
		return bikeRepository.findByYear(year);
	}

	@Override
	public Bike getQueryYearAndBikeName(int year, String bikeName) {
		// TODO Auto-generated method stub
		return bikeRepository.findByYearAndBikeName(year, bikeName);
	}

	@Override
	public Bike getQueryByName(String bikeName) {
		// TODO Auto-generated method stub
		return bikeRepository.findBybikeName(bikeName);
	}

	
       
}
