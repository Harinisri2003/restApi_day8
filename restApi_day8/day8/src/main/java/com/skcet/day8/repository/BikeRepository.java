package com.skcet.day8.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcet.day8.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer>{
       boolean existsByBikeId(int bikeId);
       
       @Query(value="select * from _bike where year=:y",nativeQuery = true)
       Bike findByYear(@Param("y") int year);
       
       @Query("select b from Bike b where year=:y and bikeName=:n")
       Bike findByYearAndBikeName(@Param("y") int year,@Param("n") String bikeName);
       
       @Query(value="select * from _bike where bike_name=:n",nativeQuery = true)
       Bike findBybikeName(@Param("n") String bikeName);
       
}
