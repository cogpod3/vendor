package com.application.vendor.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "vendor")
public class Vendor {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id", nullable = false)
	private Integer vendorId;

	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_ts")
	private String createdTs;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_ts")
	private String updatedTs;
	@Column(name = "vendor_address")
	private String vendorAddress;
	@Column(name = "vendor_contact")
	private String vendorContact;
	@Column(name = "vendor_email")
	private String vendorEmail;
	@Column(name = "vendor_name")
	private String vendorName;
	@Column(name = "vendor_nbr")
	private Long vendorNbr;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(String createdTs) {
		this.createdTs = createdTs;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedTs() {
		return updatedTs;
	}

	public void setUpdatedTs(String updatedTs) {
		this.updatedTs = updatedTs;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Long getVendorNbr() {
		return vendorNbr;
	}

	public void setVendorNbr(Long vendorNbr) {
		this.vendorNbr = vendorNbr;
	}

}
