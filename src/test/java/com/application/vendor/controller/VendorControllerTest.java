package com.application.vendor.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.application.vendor.dto.VendorDTO;
import com.application.vendor.exception.VendorException;
import com.application.vendor.model.Vendor;
import com.application.vendor.model.service.VendorService;

class VendorControllerTest {

	@Mock
	private VendorService mockService;

	@InjectMocks
	private VendorController vendorControllerUnderTest;

	@BeforeEach
	void setUp() {
		initMocks(this);
	}

	@Test
	void testGetAllVendors() {
		// Setup
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<List<Vendor>> expectedResult = new ResponseEntity<>(Arrays.asList(vendor), HttpStatus.OK);

		// Configure VendorService.getAllVendors(...).
		final Vendor vendor1 = new Vendor();
		vendor1.setVendorId(0);
		vendor1.setCreatedBy("createdBy");
		vendor1.setCreatedTs("createdTs");
		vendor1.setUpdatedBy("updatedBy");
		vendor1.setUpdatedTs("updatedTs");
		vendor1.setVendorAddress("vendorAddress");
		vendor1.setVendorContact("vendorContact");
		vendor1.setVendorEmail("vendorEmail");
		vendor1.setVendorName("vendorName");
		vendor1.setVendorNbr(0L);
		final List<Vendor> vendors = Arrays.asList(vendor1);
		when(mockService.getAllVendors()).thenReturn(vendors);

		// Run the test
		final ResponseEntity<List<Vendor>> result = vendorControllerUnderTest.getAllVendors();

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testGetVendorByName() throws Exception {
		// Setup
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.OK);

		// Configure VendorService.getVendorByName(...).
		final Vendor vendor1 = new Vendor();
		vendor1.setVendorId(0);
		vendor1.setCreatedBy("createdBy");
		vendor1.setCreatedTs("createdTs");
		vendor1.setUpdatedBy("updatedBy");
		vendor1.setUpdatedTs("updatedTs");
		vendor1.setVendorAddress("vendorAddress");
		vendor1.setVendorContact("vendorContact");
		vendor1.setVendorEmail("vendorEmail");
		vendor1.setVendorName("vendorName");
		vendor1.setVendorNbr(0L);
		when(mockService.getVendorByName("vendorName")).thenReturn(vendor1);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.getVendorByName("vendorName");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testGetVendorByName_VendorServiceThrowsVendorException() {
		// Setup
		when(mockService.getVendorByName("vendorName")).thenThrow(VendorException.class);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.getVendorByName("vendorName");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testRegisterVendor() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.CREATED);

		// Configure VendorService.registerVendor(...).
		final Vendor vendor1 = new Vendor();
		vendor1.setVendorId(0);
		vendor1.setCreatedBy("createdBy");
		vendor1.setCreatedTs("createdTs");
		vendor1.setUpdatedBy("updatedBy");
		vendor1.setUpdatedTs("updatedTs");
		vendor1.setVendorAddress("vendorAddress");
		vendor1.setVendorContact("vendorContact");
		vendor1.setVendorEmail("vendorEmail");
		vendor1.setVendorName("vendorName");
		vendor1.setVendorNbr(0L);
		when(mockService.registerVendor(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), "createdby")).thenReturn(vendor1);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.registerVendor(vendordto, "createdby");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testRegisterVendor_VendorServiceThrowsVendorException() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		when(mockService.registerVendor(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), "createdby"))
						.thenThrow(VendorException.class);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.registerVendor(vendordto, "createdby");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testDeleteVendorId() {
		// Setup
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.OK);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.deleteVendorId(0);

		// Verify the results
		assertThat(result.getStatusCode()).isEqualTo(expectedResult.getStatusCode());
		verify(mockService).deleteVendorId(0);
	}

	@Test
	void testDeleteVendorId_VendorServiceThrowsVendorException() {
		// Setup
		doThrow(VendorException.class).when(mockService).deleteVendorId(0);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.deleteVendorId(0);
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testDelVendorNbr() {
		// Setup
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.OK);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.delVendorNbr(0L);

		// Verify the results
		assertThat(result.getStatusCode()).isEqualTo(expectedResult.getStatusCode());
		verify(mockService).deleteVendorNbr(0L);
	}

	@Test
	void testDelVendorNbr_VendorServiceThrowsVendorException() {
		// Setup
		doThrow(VendorException.class).when(mockService).deleteVendorNbr(0L);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.delVendorNbr(0L);
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testUpdateVendor() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.OK);

		// Configure VendorService.updateVendor(...).
		final Vendor vendor1 = new Vendor();
		vendor1.setVendorId(0);
		vendor1.setCreatedBy("createdBy");
		vendor1.setCreatedTs("createdTs");
		vendor1.setUpdatedBy("updatedBy");
		vendor1.setUpdatedTs("updatedTs");
		vendor1.setVendorAddress("vendorAddress");
		vendor1.setVendorContact("vendorContact");
		vendor1.setVendorEmail("vendorEmail");
		vendor1.setVendorName("vendorName");
		vendor1.setVendorNbr(0L);
		when(mockService.updateVendor(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), 0L, "updatedBy"))
						.thenReturn(vendor1);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.updateVendor(vendordto, 0L, "updatedBy");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testUpdateVendor_VendorServiceThrowsVendorException() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		when(mockService.updateVendor(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), 0L, "updatedBy"))
						.thenThrow(VendorException.class);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.updateVendor(vendordto, 0L, "updatedBy");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testUpdateVendorId() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor vendor = new Vendor();
		vendor.setVendorId(0);
		vendor.setCreatedBy("createdBy");
		vendor.setCreatedTs("createdTs");
		vendor.setUpdatedBy("updatedBy");
		vendor.setUpdatedTs("updatedTs");
		vendor.setVendorAddress("vendorAddress");
		vendor.setVendorContact("vendorContact");
		vendor.setVendorEmail("vendorEmail");
		vendor.setVendorName("vendorName");
		vendor.setVendorNbr(0L);
		final ResponseEntity<Vendor> expectedResult = new ResponseEntity<>(vendor, HttpStatus.OK);

		// Configure VendorService.updateVendorbyID(...).
		final Vendor vendor1 = new Vendor();
		vendor1.setVendorId(0);
		vendor1.setCreatedBy("createdBy");
		vendor1.setCreatedTs("createdTs");
		vendor1.setUpdatedBy("updatedBy");
		vendor1.setUpdatedTs("updatedTs");
		vendor1.setVendorAddress("vendorAddress");
		vendor1.setVendorContact("vendorContact");
		vendor1.setVendorEmail("vendorEmail");
		vendor1.setVendorName("vendorName");
		vendor1.setVendorNbr(0L);
		when(mockService.updateVendorbyID(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), 0, "updatedBy"))
						.thenReturn(vendor1);

		// Run the test
		final ResponseEntity<Vendor> result = vendorControllerUnderTest.updateVendorId(vendordto, 0, "updatedBy");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testUpdateVendorId_VendorServiceThrowsVendorException() {
		// Setup
		final VendorDTO vendordto = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		when(mockService.updateVendorbyID(new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L), 0, "updatedBy"))
						.thenThrow(VendorException.class);

		// Run the test
		assertThatThrownBy(() -> {
			vendorControllerUnderTest.updateVendorId(vendordto, 0, "updatedBy");
		}).isInstanceOf(VendorException.class);
	}
}
