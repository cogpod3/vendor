package com.application.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.vendor.dto.VendorDTO;
import com.application.vendor.exception.VendorException;
import com.application.vendor.model.Vendor;
import com.application.vendor.model.service.VendorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService service;

	@GetMapping("/get/all")
	public ResponseEntity<List<Vendor>> getAllVendors() {
		return ResponseEntity.ok(service.getAllVendors());
	}

	@GetMapping("/search/{VendorName}")
	public ResponseEntity<Vendor> getVendorByName(String vendorName) throws VendorException {
		log.info("VendorController :: getVendorByName :: vendorName : {}", vendorName);
		return ResponseEntity.ok(service.getVendorByName(vendorName));
	}

	@PostMapping("/")
	public ResponseEntity<Vendor> registerVendor(@RequestBody VendorDTO vendordto, @RequestHeader String createdby)
			throws VendorException {
		log.info("VendorController :: registerVendor :: VendorDTO : {}", vendordto);
		log.info("VendorController :: registerVendor :: createdby : {}", createdby);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.registerVendor(vendordto, createdby));
	}

	@DeleteMapping("/deletebyVendorId/{vendorId}")
	public ResponseEntity<Vendor> deleteVendorId(@PathVariable("vendorId") int vendorId) throws VendorException {
		log.info("VendorController :: deleteVendorId :: vendorId : {}", vendorId);
		service.deleteVendorId(vendorId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/deletebyvendorNbr/{vendorNbr}")
	public ResponseEntity<Vendor> delVendorNbr(@PathVariable("vendorNbr") Long vendorNbr) throws VendorException {
		log.info("VendorController :: delVendorNbr :: vendorNbr : {}", vendorNbr);
		service.deleteVendorNbr(vendorNbr);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/UpdatedbyNbr/{vendorNbr}")
	public ResponseEntity<Vendor> updateVendor(@RequestBody VendorDTO vendordto,
			@PathVariable("vendorNbr") Long vendorNbr, @RequestHeader String updatedBy) throws VendorException {
		log.info("VendorController :: updateVendor :: VendorDTO : {}", vendordto);
		log.info("VendorController :: updateVendor :: vendorNbr : {} :: updatedBy :{}, ", vendorNbr, updatedBy);
		return ResponseEntity.ok(service.updateVendor(vendordto, vendorNbr, updatedBy));
	}

	@PutMapping("/updatedbyId/{vendorId}")
	public ResponseEntity<Vendor> updateVendorId(@RequestBody VendorDTO vendordto,
			@PathVariable("vendorId") int vendorId, @RequestHeader String updatedBy) throws VendorException {
		log.info("VendorController :: updateVendorId :: VendorDTO : {}", vendordto);
		log.info("VendorController :: updateVendorId :: vendorId : {} :: updatedBy :{}, ", vendorId, updatedBy);
		return ResponseEntity.ok(service.updateVendorbyID(vendordto, vendorId, updatedBy));
	}
}