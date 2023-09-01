package com.skcet.day8.service;

import java.util.List;

import com.skcet.day8.model.Bike;

public interface BikeService {
      boolean addValues(Bike bike);
      Bike getQuery(int year);
      Bike getQueryYearAndBikeName(int year,String bikeName);
      Bike getQueryByName(String bikeName);
}
