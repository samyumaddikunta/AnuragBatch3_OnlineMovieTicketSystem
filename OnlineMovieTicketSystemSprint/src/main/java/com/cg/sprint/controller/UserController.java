package com.cg.sprint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.entity.Account;
import com.cg.sprint.entity.City;
import com.cg.sprint.entity.Customer;
import com.cg.sprint.entity.Languages;
import com.cg.sprint.entity.Movies;
import com.cg.sprint.entity.Payments;
import com.cg.sprint.entity.Refund;
import com.cg.sprint.entity.Seats;
import com.cg.sprint.entity.Shows;
import com.cg.sprint.entity.Theatre;
import com.cg.sprint.exceptions.AdminAccountNotFoundException;
import com.cg.sprint.exceptions.InvalidBookingDetailsException;
import com.cg.sprint.exceptions.UserAccountNotFoundException;
import com.cg.sprint.service.UserServiceInterface;
@RequestMapping("/user")
@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {		
	@Autowired
	private UserServiceInterface movieservice;
	//Signup Details
	@PostMapping("/signup")
    public Account addUser(@Valid @RequestBody Account a)
    {
   	 return movieservice.save(a);
   	
    }

	//Login Details
	@GetMapping("/validation/{username}/{password}")
	public ResponseEntity<Account> validate(@PathVariable("username") String uname, @PathVariable("password") String pwd) throws UserAccountNotFoundException{
		Account auth = movieservice.validate(uname, pwd);
		ResponseEntity<Account> response = new ResponseEntity<Account>(auth,HttpStatus.OK);
		return response;
	}
	//displaying cities
	@GetMapping("/cities")
	public List<City> cityNames(){
		return movieservice.getCityNames();
	}
	//displaying theaters
	@GetMapping("/theatres/{city-name}")
	public List<Theatre> theatreNames(@PathVariable("city-name") String name){
		return movieservice.theatreNames(name);
	}
	//displaying movies
	@GetMapping("/movies/{theatre-name}")
	public List<Movies> movieNames(@PathVariable("theatre-name") String name){
		return movieservice.movieNames(name);
	}
	//displaying shows
	@GetMapping("/shows")
	public List<Shows> getShows(){
		return movieservice.getShows();
	}
	//displaying languages
	@GetMapping("/languages")
	public List<Languages> getLanguage(){
		return movieservice.getLanguage();
	}
	//displaying seats
	@GetMapping("/seats")
	public List<Seats> getSeats(){
		return movieservice.getSeats();
	}
	//fetching account number
	@GetMapping("/account_data/{account_no}")
	public ResponseEntity<Customer> getAccountData(@PathVariable("account_no") int accno) {
		Customer customer = movieservice.getAccountData(accno);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return response;
	}
	//updating seats
	@PutMapping("/update_seats")
	public String updateSeats(@RequestBody Seats seat) {
		
		return movieservice.updateSeats(seat);
	}
	//payment details
	@PostMapping("/payments") 
	public String payments(@RequestBody Payments pay) {
		return movieservice.payments(pay);
	}
	//refund details
	@GetMapping("/refund/{acc_no}/{book_id}")
	public Payments refund(@PathVariable("acc_no") int accno, @PathVariable("book_id") int bookingid) throws InvalidBookingDetailsException {
		return movieservice.refund(accno, bookingid);
	}
	//updating payment
	@PutMapping("/update_payment")
	public String updatePayment(@RequestBody Payments payment) {
		return movieservice.updatePayment(payment);
	}
	//refund details
	@PostMapping("/refund_details")
	public String refundDetails(@RequestBody Refund refund) {
		return movieservice.refundDetails(refund);
	}
	//seats information
	@GetMapping("/seat_details/{seat_type}")
	public Seats seatDetails(@PathVariable("seat_type") String seattype) {
		return movieservice.seatDetails(seattype);
	}
		@PutMapping("/set_seats")
	public String setSeats(@RequestBody Seats seat )   
	{
		String string = movieservice.setSeats(seat);
		if(string!=null)
		{
			return "updated successfully!"+"Sno"+seat.getSno()+"seattype"+seat.getSeatType()+"seats available"+seat.getAvailableSeats()+"price"+seat.getPrice();
		}
		else
		{
			
			return "seats not updated";
		}
	}
	@PutMapping("/update_customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer cus) //throws InvalidDetailsException
	{
		String string = movieservice.updateCustomer(cus);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}

}