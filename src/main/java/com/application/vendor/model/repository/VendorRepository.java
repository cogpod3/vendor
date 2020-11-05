package com.application.vendor.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.application.vendor.model.Vendor;

@Repository
@Transactional
public interface VendorRepository extends CrudRepository<Vendor, Integer> {
	public Optional<Vendor> findByVendorName(String vendorName);

	public Optional<Vendor> findByvendorNbr(Long vendorName);

	@Modifying
	@Query(value = "delete from vendor u where u.vendor_nbr = :vendorNbr", nativeQuery = true)
	void deleteUsersByVendorNbr(@Param("vendorNbr") Long vendorNbr);
}