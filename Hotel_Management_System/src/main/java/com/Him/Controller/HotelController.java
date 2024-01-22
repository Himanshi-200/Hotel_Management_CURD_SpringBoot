package com.Him.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Him.Model.Hotel;
import com.Him.Repository.HotelRepository;

@RestController
@RequestMapping("/api")
public class HotelController {

	@Autowired
	HotelRepository hotelRepository;
	@PostMapping("/hotels")
	public String createNewHotel(@RequestBody Hotel hotel) {
		hotelRepository.save(hotel);
		return "New Entry created in database";
	}
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>>getAllHotels(){
		List<Hotel>hotellist=new ArrayList<>();
		hotelRepository.findAll().forEach(hotellist::add);
		return new ResponseEntity<List<Hotel>>(hotellist,HttpStatus.OK);
	}
	@GetMapping("/hotels/{customer_id}")
	public ResponseEntity<Hotel>getHotelById(@PathVariable long customer_id){
		Optional<Hotel>hotel=hotelRepository.findById(customer_id);
		if(hotel.isPresent()) {
			return new ResponseEntity<Hotel>(hotel.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/hotels/{customer_id}")
	public String updateHotelById(@PathVariable long customer_id,@RequestBody Hotel hotel) {
		Optional<Hotel>hot=hotelRepository.findById(customer_id);
		if(hot.isPresent()) {
			Hotel existHotel=hot.get();
			existHotel.setBooking_room(hotel.getBooking_room());
			existHotel.setFood_ordered(hotel.getFood_ordered());
			hotelRepository.save(existHotel);
			return "Hotel details against customerid "+customer_id+" updated successful"; 
		}
		else {
			return "Hotel details not exists";
		}
	}
	@DeleteMapping("/hotels/{customer_id}")
	public String deletehotelByCustomerid(@PathVariable long customer_id) {
		hotelRepository.deleteById(customer_id);
		return "hotel deleted successfully";
	}
	@DeleteMapping("/hotels")
	public String deleteAllHotels() {
		hotelRepository.deleteAll();
		return "deleted all records";
	}
}
