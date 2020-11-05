package com.application.vendor.model.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.vendor.constant.ErrorConstant;
import com.application.vendor.constant.ErrorMessage;
import com.application.vendor.dto.VendorDTO;
import com.application.vendor.exception.VendorException;
import com.application.vendor.model.Vendor;
import com.application.vendor.model.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {

	Date now = new Date();
	String pattern = "yyyy-MM-dd HH:mm:ss";
	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	String timestamp = formatter.format(now);

	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private VendorRepository repository;

	public List<Vendor> getAllVendors() {
		log.info("VendorService :: getAllVendors");
		return (List<Vendor>) repository.findAll();
	}

	public Vendor registerVendor(VendorDTO vendorDTO, String createdby) throws VendorException {
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		if (repository.findByVendorName(vendor.getVendorName()).isPresent()
				|| repository.findByvendorNbr(vendor.getVendorNbr()).isPresent()) {
			log.info("VendorService :: registerVendor :: Given details is already present : {}", vendor);
			throw new VendorException(ErrorConstant.VENDOR_NUMBER_ERROR, ErrorMessage.VENDOR_NUMBER_FAILED);
		}
		try {
			vendor.setCreatedTs(timestamp);
			vendor.setCreatedBy(createdby);
			return repository.save(vendor);

		} catch (Exception ex) {
			log.debug("VendorService : registerVendor : vendor :{} Exception : {}", vendorDTO, ex);
			throw new VendorException(ErrorConstant.VENDOR_SAVE_ERROR, ErrorMessage.VENDOR_SAVE_FAILED);
		}
	}

	public void deleteVendorId(int vendorId) throws VendorException {
		if (repository.findById(vendorId).isPresent()) {
			repository.deleteById(vendorId);
		} else {
			throw new VendorException(ErrorConstant.VENDOR_NUMBER_ERROR, ErrorMessage.VENDOR_NOT_FOUND);
		}
	}

	public void deleteVendorNbr(Long vendorNbr) throws VendorException {
		if (repository.findByvendorNbr(vendorNbr).isPresent()) {
			repository.deleteUsersByVendorNbr(vendorNbr);
		} else {
			throw new VendorException(ErrorConstant.VENDOR_NUMBER_ERROR, ErrorMessage.VENDOR_NOT_FOUND);
		}
	}

	public Vendor updateVendor(VendorDTO vendorDTO, long vendorNbr, String updatedBy) throws VendorException {
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		if (repository.findByvendorNbr(vendorNbr).isPresent()) {
			try {
				Vendor vendorInDb = repository.findByvendorNbr(vendorNbr).get();
				if (vendor.getVendorName() != null)
					vendorInDb.setVendorName(vendor.getVendorName());
				if (vendor.getVendorAddress() != null)
					vendorInDb.setVendorAddress(vendor.getVendorAddress());
				if (vendor.getVendorContact() != null)
					vendorInDb.setVendorContact(vendor.getVendorContact());
				if (vendor.getVendorEmail() != null)
					vendorInDb.setVendorEmail(vendor.getVendorEmail());
				if (vendor.getVendorNbr() != null)
					vendorInDb.setVendorNbr(vendor.getVendorNbr());
				vendorInDb.setUpdatedBy(updatedBy);
				vendorInDb.setUpdatedTs(timestamp);
				return repository.save(vendorInDb);
			} catch (Exception ex) {
				log.info("VendorService :  updateVendor : Vendor :{} Exception : {}", vendorDTO, ex);
				throw new VendorException(ErrorConstant.VENDOR_UPDATE_ERROR, ErrorMessage.VENDOR_UPDATE_FAILED);
			}
		} else {
			throw new VendorException(ErrorConstant.VENDOR_NUMBER_ERROR, ErrorMessage.VENDOR_NOT_FOUND);
		}

	}

	public Vendor getVendorByName(String vendorName) throws VendorException {
		if (repository.findByVendorName(vendorName).isPresent())
			return repository.findByVendorName(vendorName).get();
		else
			throw new VendorException(ErrorConstant.VENDOR_TYPE_ERROR, ErrorMessage.VENDOR_NOT_FOUND);
	}

	public Vendor updateVendorbyID(VendorDTO vendorDTO, int vendorId, String updatedBy) throws VendorException {
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);

		if (repository.findById(vendorId).isPresent()) {
			try {
				Vendor vendorInDb = repository.findById(vendorId).get();
				if (vendor.getVendorName() != null)
					vendorInDb.setVendorName(vendor.getVendorName());
				if (vendor.getVendorAddress() != null)
					vendorInDb.setVendorAddress(vendor.getVendorAddress());
				if (vendor.getVendorContact() != null)
					vendorInDb.setVendorContact(vendor.getVendorContact());
				if (vendor.getVendorEmail() != null)
					vendorInDb.setVendorEmail(vendor.getVendorEmail());
				if (vendor.getVendorNbr() != null)
					vendorInDb.setVendorNbr(vendor.getVendorNbr());
				vendorInDb.setUpdatedBy(updatedBy);
				vendorInDb.setUpdatedTs(timestamp);
				return repository.save(vendorInDb);
			} catch (Exception ex) {
				log.info("VendorService :  updateVendor : Vendor :{} Exception : {}", vendorDTO, ex);
				throw new VendorException(ErrorConstant.VENDOR_UPDATE_ERROR, ErrorMessage.VENDOR_UPDATE_FAILED);
			}
		} else {
			throw new VendorException(ErrorConstant.VENDOR_NUMBER_ERROR, ErrorMessage.VENDOR_NOT_FOUND);
		}
	}

}