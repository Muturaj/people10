package com.people10.assignment.AssignmentPeople10.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.logging.log4j.Logger;
import org.castor.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.people10.assignment.AssignmentPeople10.DAO.CustomerRepo;
import com.people10.assignment.AssignmentPeople10.DAO.HibernateRepo;
import com.people10.assignment.AssignmentPeople10.EmailConfig.EmailServiceImp;
import com.people10.assignment.AssignmentPeople10.model.Customer;
import com.people10.assignment.AssignmentPeople10.model.DBFile;
import com.people10.assignment.AssignmentPeople10.service.CostomizedQueryWithJPA;
import com.people10.assignment.AssignmentPeople10.service.DBFileService;
import com.people10.assignment.AssignmentPeople10.service.JasperUtility;
import com.people10.assignment.AssignmentPeople10.service.RepoService;
import com.people10.assignment.AssignmentPeople10.service.ReportService;


import net.sf.jasperreports.engine.JRException;

@RestController

@RequestMapping("/api")
public class CustomerController {

	@Autowired
	RepoService repo;

	@Autowired
	ReportService report;

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	EmailServiceImp emailService;

	@Autowired
	DBFileService dbservice;

	@Autowired
	CostomizedQueryWithJPA customQuery;

	
	//HibernateRepo hibernaterepo;
	//@Autowired
	//withSessionFactory withSessionFactory;


	
	

	@GetMapping("/custom/{firstname}/{email}")
	public List<Customer> getByNameAndEmail(@PathVariable String firstname, @PathVariable String email) {

		List<Customer> listcustom = customQuery.getListCostomer(firstname, email);

		return listcustom;

	}

	@GetMapping("/getFileID/{fileId}")
	public DBFile getFiles(@PathVariable int fileId) {

		DBFile data = dbservice.getFile(fileId);
		byte[] dataaa = data.getData();

		System.out.println(dataaa.toString());
		String hey = data.getFileName();
		System.out.println(hey);

		return data;
	}

	@PostMapping("/UploadToDb")
	public DBFile uploadToDb(@RequestParam("file") MultipartFile file) {

		System.out.println("Success");
		return dbservice.storeFile(file);
	}

	@GetMapping("/findAll")
	public String getAllreport() throws FileNotFoundException, JRException {

		String success = report.getAllData();

		System.out.println(success);

		return "generated";
	}

	// booking hotel by the Customer

	@PostMapping("/upload")
	public ResponseEntity uploadToLocalSystem(@RequestParam("file") MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(fileName);
		Path path = Paths.get(fileName);
		System.out.println(path);
		System.out.println(file.getInputStream().toString());

		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception e) {
			// TODO: handle exception
		}
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
				.path(fileName).toUriString();
		return ResponseEntity.ok(fileDownloadUri);

	}

	@PostMapping("/customer")
	public String createCustomer(@RequestBody @Valid Customer cust) {
		boolean existemail = customerRepo.existsByEmail(cust.getEmail());
		if (existemail) {
			return "Email Id Exists";
		} else {

			customerRepo.save(cust);
			return "Hotel booked Successfully";
		}

	}

	@GetMapping("/customer/{id}")
	public Customer getCustomerbyId(@PathVariable long id) {

		return customerRepo.findById(id).orElseThrow(() -> new CustomerIdNotPresentException(id));

	}

	@PutMapping("/customer/update/{id}")
	public Customer updateCustomerInfo(@RequestBody Customer cus, @PathVariable long id) {

		return customerRepo.findById(id).map(cusstomer -> {
			cusstomer.setEmail(cus.getEmail());
			cusstomer.setBirthDate(cus.getBirthDate());
			cusstomer.setFirstName(cus.getFirstName());
			cusstomer.setLastName(cus.getLastName());
			cusstomer.setPassword(cus.getPassword());
			return customerRepo.save(cusstomer);
		}).orElseGet(() -> {
			cus.setCid(id);
			return customerRepo.save(cus);

		});

	}

	@DeleteMapping("/customer/delete/{id}")
	public String deleteCustomer(@PathVariable long id) {
		customerRepo.deleteById(id);
		return "Successfully deleted";
	}

	@GetMapping("/sendingEmail")
	public String sendingEmail() {
		System.out.println("Hitting");
		emailService.sendSimpleMessage("mutturajdeval92@gmail.com", "Sending Java Openings", "Hi Hello");
		System.out.println("Hitting back");
		return "Mail Sent";

	}

	@GetMapping("/repo/{city}/{limit}")
	public Map<String, LinkedHashMap<String, Integer>> getTop(@PathVariable String city, @PathVariable Integer limit) {

		Map<String, LinkedHashMap<String, Integer>> result = repo.getTop50Repos(city, limit);
		System.out.println("came" + result);

		return result;
	}

}
