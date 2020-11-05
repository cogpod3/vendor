package com.application.vendor.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.application.vendor.dto.VendorDTO;
import com.application.vendor.exception.VendorException;
import com.application.vendor.model.Vendor;
import com.application.vendor.model.repository.VendorRepository;
import com.application.vendor.model.service.VendorService;

class VendorServiceTest {

	@Mock
	private VendorRepository mockRepository;

	@InjectMocks
	private VendorService vendorServiceUnderTest;

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
		final List<Vendor> expectedResult = Arrays.asList(vendor);

		// Configure VendorRepository.findAll(...).
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
		final Iterable<Vendor> vendors = Arrays.asList(vendor1);
		when(mockRepository.findAll()).thenReturn(vendors);

		// Run the test
		final List<Vendor> result = vendorServiceUnderTest.getAllVendors();

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testRegisterVendor() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor expectedResult = new Vendor();
		expectedResult.setVendorId(0);
		expectedResult.setCreatedBy("createdBy");
		expectedResult.setCreatedTs("createdTs");
		expectedResult.setUpdatedBy("updatedBy");
		expectedResult.setUpdatedTs("updatedTs");
		expectedResult.setVendorAddress("vendorAddress");
		expectedResult.setVendorContact("vendorContact");
		expectedResult.setVendorEmail("vendorEmail");
		expectedResult.setVendorName("vendorName");
		expectedResult.setVendorNbr(0L);

		// Configure VendorRepository.findByVendorName(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByVendorName("vendorName")).thenReturn(Optional.empty());

		// Configure VendorRepository.findByvendorNbr(...).
		final Vendor vendor3 = new Vendor();
		vendor3.setVendorId(0);
		vendor3.setCreatedBy("createdBy");
		vendor3.setCreatedTs("createdTs");
		vendor3.setUpdatedBy("updatedBy");
		vendor3.setUpdatedTs("updatedTs");
		vendor3.setVendorAddress("vendorAddress");
		vendor3.setVendorContact("vendorContact");
		vendor3.setVendorEmail("vendorEmail");
		vendor3.setVendorName("vendorName");
		vendor3.setVendorNbr(0L);
		final Optional<Vendor> vendor2 = Optional.of(vendor3);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(Optional.empty());

		// Configure VendorRepository.save(...).
		final Vendor vendor4 = new Vendor();
		vendor4.setVendorId(0);
		vendor4.setCreatedBy("createdBy");
		vendor4.setCreatedTs("createdTs");
		vendor4.setUpdatedBy("updatedBy");
		vendor4.setUpdatedTs("updatedTs");
		vendor4.setVendorAddress("vendorAddress");
		vendor4.setVendorContact("vendorContact");
		vendor4.setVendorEmail("vendorEmail");
		vendor4.setVendorName("vendorName");
		vendor4.setVendorNbr(0L);
		when(mockRepository.save(any())).thenReturn(vendor4);

		// Run the test
		final Vendor result = vendorServiceUnderTest.registerVendor(vendorDTO, "createdby");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testRegisterVendor_ThrowsVendorException() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);

		// Configure VendorRepository.findByVendorName(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByVendorName("vendorName")).thenReturn(vendor);

		// Configure VendorRepository.findByvendorNbr(...).
		final Vendor vendor3 = new Vendor();
		vendor3.setVendorId(0);
		vendor3.setCreatedBy("createdBy");
		vendor3.setCreatedTs("createdTs");
		vendor3.setUpdatedBy("updatedBy");
		vendor3.setUpdatedTs("updatedTs");
		vendor3.setVendorAddress("vendorAddress");
		vendor3.setVendorContact("vendorContact");
		vendor3.setVendorEmail("vendorEmail");
		vendor3.setVendorName("vendorName");
		vendor3.setVendorNbr(0L);
		final Optional<Vendor> vendor2 = Optional.of(vendor3);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(vendor2);

		// Configure VendorRepository.save(...).
		final Vendor vendor4 = new Vendor();
		vendor4.setVendorId(0);
		vendor4.setCreatedBy("createdBy");
		vendor4.setCreatedTs("createdTs");
		vendor4.setUpdatedBy("updatedBy");
		vendor4.setUpdatedTs("updatedTs");
		vendor4.setVendorAddress("vendorAddress");
		vendor4.setVendorContact("vendorContact");
		vendor4.setVendorEmail("vendorEmail");
		vendor4.setVendorName("vendorName");
		vendor4.setVendorNbr(0L);
		when(mockRepository.save(new Vendor())).thenReturn(vendor4);

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.registerVendor(vendorDTO, "createdby");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testDeleteVendorId() {
		// Setup

		// Configure VendorRepository.findById(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findById(0)).thenReturn(vendor);

		// Run the test
		vendorServiceUnderTest.deleteVendorId(0);

		// Verify the results
		verify(mockRepository).deleteById(0);
	}

	@Test
	void testDeleteVendorId_ThrowsVendorException() {
		// Setup

		// Configure VendorRepository.findById(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findById(0)).thenReturn(Optional.empty());

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.deleteVendorId(0);
		}).isInstanceOf(VendorException.class);

	}

	@Test
	void testDeleteVendorNbr() {
		// Setup

		// Configure VendorRepository.findByvendorNbr(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(vendor);

		// Run the test
		vendorServiceUnderTest.deleteVendorNbr(0L);

		// Verify the results
		verify(mockRepository).deleteUsersByVendorNbr(0L);
	}

	@Test
	void testDeleteVendorNbr_ThrowsVendorException() {
		// Setup

		// Configure VendorRepository.findByvendorNbr(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(Optional.empty());

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.deleteVendorNbr(0L);
		}).isInstanceOf(VendorException.class);

	}

	@Test
	void testUpdateVendor() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor expectedResult = new Vendor();
		expectedResult.setVendorId(0);
		expectedResult.setCreatedBy("createdBy");
		expectedResult.setCreatedTs("createdTs");
		expectedResult.setUpdatedBy("updatedBy");
		expectedResult.setUpdatedTs("updatedTs");
		expectedResult.setVendorAddress("vendorAddress");
		expectedResult.setVendorContact("vendorContact");
		expectedResult.setVendorEmail("vendorEmail");
		expectedResult.setVendorName("vendorName");
		expectedResult.setVendorNbr(0L);

		// Configure VendorRepository.findByvendorNbr(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(vendor);

		// Configure VendorRepository.save(...).
		final Vendor vendor2 = new Vendor();
		vendor2.setVendorId(0);
		vendor2.setCreatedBy("createdBy");
		vendor2.setCreatedTs("createdTs");
		vendor2.setUpdatedBy("updatedBy");
		vendor2.setUpdatedTs("updatedTs");
		vendor2.setVendorAddress("vendorAddress");
		vendor2.setVendorContact("vendorContact");
		vendor2.setVendorEmail("vendorEmail");
		vendor2.setVendorName("vendorName");
		vendor2.setVendorNbr(0L);
		when(mockRepository.save(any())).thenReturn(vendor2);

		// Run the test
		final Vendor result = vendorServiceUnderTest.updateVendor(vendorDTO, 0L, "updatedBy");

		// Verify the results
		assertThat(result.getVendorId()).isEqualTo(expectedResult.getVendorId());
	}

	@Test
	void testUpdateVendor_ThrowsVendorException() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);

		// Configure VendorRepository.findByvendorNbr(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByvendorNbr(0L)).thenReturn(Optional.empty());

		// Configure VendorRepository.save(...).
		final Vendor vendor2 = new Vendor();
		vendor2.setVendorId(0);
		vendor2.setCreatedBy("createdBy");
		vendor2.setCreatedTs("createdTs");
		vendor2.setUpdatedBy("updatedBy");
		vendor2.setUpdatedTs("updatedTs");
		vendor2.setVendorAddress("vendorAddress");
		vendor2.setVendorContact("vendorContact");
		vendor2.setVendorEmail("vendorEmail");
		vendor2.setVendorName("vendorName");
		vendor2.setVendorNbr(0L);
		when(mockRepository.save(new Vendor())).thenReturn(vendor2);

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.updateVendor(vendorDTO, 0L, "updatedBy");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testGetVendorByName() {
		// Setup
		final Vendor expectedResult = new Vendor();
		expectedResult.setVendorId(0);
		expectedResult.setCreatedBy("createdBy");
		expectedResult.setCreatedTs("createdTs");
		expectedResult.setUpdatedBy("updatedBy");
		expectedResult.setUpdatedTs("updatedTs");
		expectedResult.setVendorAddress("vendorAddress");
		expectedResult.setVendorContact("vendorContact");
		expectedResult.setVendorEmail("vendorEmail");
		expectedResult.setVendorName("vendorName");
		expectedResult.setVendorNbr(0L);

		// Configure VendorRepository.findByVendorName(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByVendorName("vendorName")).thenReturn(vendor);

		// Run the test
		final Vendor result = vendorServiceUnderTest.getVendorByName("vendorName");

		// Verify the results
		assertThat(result).isEqualTo(expectedResult);
	}

	@Test
	void testGetVendorByName_ThrowsVendorException() {
		// Setup

		// Configure VendorRepository.findByVendorName(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findByVendorName("vendorName")).thenReturn(Optional.empty());

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.getVendorByName("vendorName");
		}).isInstanceOf(VendorException.class);
	}

	@Test
	void testUpdateVendorbyID() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);
		final Vendor expectedResult = new Vendor();
		expectedResult.setVendorId(0);
		expectedResult.setCreatedBy("createdBy");
		expectedResult.setCreatedTs("createdTs");
		expectedResult.setUpdatedBy("updatedBy");
		expectedResult.setUpdatedTs("updatedTs");
		expectedResult.setVendorAddress("vendorAddress");
		expectedResult.setVendorContact("vendorContact");
		expectedResult.setVendorEmail("vendorEmail");
		expectedResult.setVendorName("vendorName");
		expectedResult.setVendorNbr(0L);

		// Configure VendorRepository.findById(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findById(0)).thenReturn(vendor);

		// Configure VendorRepository.save(...).
		final Vendor vendor2 = new Vendor();
		vendor2.setVendorId(0);
		vendor2.setCreatedBy("createdBy");
		vendor2.setCreatedTs("createdTs");
		vendor2.setUpdatedBy("updatedBy");
		vendor2.setUpdatedTs("updatedTs");
		vendor2.setVendorAddress("vendorAddress");
		vendor2.setVendorContact("vendorContact");
		vendor2.setVendorEmail("vendorEmail");
		vendor2.setVendorName("vendorName");
		vendor2.setVendorNbr(0L);
		when(mockRepository.save(any())).thenReturn(vendor2);

		// Run the test
		final Vendor result = vendorServiceUnderTest.updateVendorbyID(vendorDTO, 0, "updatedBy");

		// Verify the results
		assertThat(result.getVendorId()).isEqualTo(expectedResult.getVendorId());
	}

	@Test
	void testUpdateVendorbyID_ThrowsVendorException() {
		// Setup
		final VendorDTO vendorDTO = new VendorDTO(0, "createdBy", "createdTs", "updatedBy", "updatedTs",
				"vendorAddress", "vendorContact", "vendorEmail", "vendorName", 0L);

		// Configure VendorRepository.findById(...).
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
		final Optional<Vendor> vendor = Optional.of(vendor1);
		when(mockRepository.findById(0)).thenReturn(Optional.empty());

		// Configure VendorRepository.save(...).
		final Vendor vendor2 = new Vendor();
		vendor2.setVendorId(0);
		vendor2.setCreatedBy("createdBy");
		vendor2.setCreatedTs("createdTs");
		vendor2.setUpdatedBy("updatedBy");
		vendor2.setUpdatedTs("updatedTs");
		vendor2.setVendorAddress("vendorAddress");
		vendor2.setVendorContact("vendorContact");
		vendor2.setVendorEmail("vendorEmail");
		vendor2.setVendorName("vendorName");
		vendor2.setVendorNbr(0L);
		when(mockRepository.save(new Vendor())).thenReturn(vendor2);

		// Run the test
		assertThatThrownBy(() -> {
			vendorServiceUnderTest.updateVendorbyID(vendorDTO, 0, "updatedBy");
		}).isInstanceOf(VendorException.class);
	}
}