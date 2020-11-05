package com.application.vendor.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VendorDTO {

	private Integer vendorId;

	private String createdBy;

	private String createdTs;

	private String updatedBy;

	private String updatedTs;

	private String vendorAddress;

	private String vendorContact;

	private String vendorEmail;

	private String vendorName;

	private Long vendorNbr;

}