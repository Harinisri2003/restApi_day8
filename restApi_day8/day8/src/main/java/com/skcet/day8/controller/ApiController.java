 package com.skcet.day8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day8.model.Bike;
import com.skcet.day8.service.BikeService;

@RestController
@RequestMapping("api/v1/controller")
public class ApiController {
       @Autowired
       private BikeService bikeService;
       
       @PostMapping("/add")
       public ResponseEntity<String> addValues(@RequestBody Bike bike)
       {
    	   boolean dataSaved=bikeService.addValues(bike);
    	   if(dataSaved)
    	   {
    		   return ResponseEntity.status(200).body("Success!");
    	   }
    	   else
    	   {
    		   return ResponseEntity.status(200).body("Not Success!");   
    	   }
       }
       
       @GetMapping("/getQuery/{year}")
       public ResponseEntity<Bike> getQuery(@PathVariable int year)
       {
    	   return ResponseEntity.status(200).body(bikeService.getQuery(year));
       }
       
       @GetMapping("/get/{year}/{bikeName}")
       public ResponseEntity<Bike> getQuery(@PathVariable int year,@PathVariable String bikeName)
       {
    	   return ResponseEntity.status(200).body(bikeService.getQueryYearAndBikeName(year, bikeName));
       }
       
       @GetMapping("/getQueryName/{bikeName}")
       public ResponseEntity<Bike> getQuery(@PathVariable String bikeName)
       {
    	   return ResponseEntity.status(200).body(bikeService.getQueryByName(bikeName));
       }
}
