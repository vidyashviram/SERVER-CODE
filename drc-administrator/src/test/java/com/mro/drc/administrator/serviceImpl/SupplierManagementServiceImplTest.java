package com.mro.drc.administrator.serviceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mro.drc.administrator.dao.SupplierManagementDoa;
import com.mro.drc.administrator.dto.SupplierManagementFilter;
import com.mro.drc.administrator.entity.LkupSupplier;
import com.mro.drc.administrator.serviceImpl.SupplierManagementServiceImpl;

public class SupplierManagementServiceImplTest {

	@Mock
	private SupplierManagementDoa supplierManagementDoa;

	@InjectMocks
	private SupplierManagementServiceImpl supplierManagementServiceImpl;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date myDate = new Date(2014, 02, 11);

	public List<LkupSupplier> supplierServiceData() {
		List<LkupSupplier> dummydata = new ArrayList<>();

		LkupSupplier supplierAddRequest = new LkupSupplier();
		supplierAddRequest.setSupplierName("Apurva");
		supplierAddRequest.setSupplierAddress("IND");
		supplierAddRequest.setSupplierEmail("Apurva@gmail.com");
		supplierAddRequest.setSupplierPhone("12345678");
		supplierAddRequest.setSupplierId(2);
		supplierAddRequest.setModifiedDate(new Date());
		supplierAddRequest.setCreatedDate(new Date());
		supplierAddRequest.setActive(true); 

		dummydata.add(supplierAddRequest);
		return dummydata;
	}  

	@Test
	public void getSupplierListServicesTest() {
		Mockito.when(supplierManagementDoa.getSupplierList()).thenReturn(supplierServiceData());
		List<SupplierManagementFilter> response = supplierManagementServiceImpl.getSupplierList();
		assertEquals("Apurva", response.get(0).getSupplierName());

	}

	@Test
	public void saveCustomerManagementRecordTest() {

		Mockito.when(supplierManagementDoa.saveAndFlush(supplierServiceData().get(0)))
				.thenReturn(supplierServiceData().get(0));
		Map<String, String> response = supplierManagementServiceImpl
				.saveRecords(supplierServiceData().get(0));
		assertEquals("Success", response.get("message"));

	}

	@Test
	public void saveCustomerManagementNullRecordTest() {

		Mockito.when(supplierManagementDoa.saveAndFlush(null)).thenReturn(null);
		Map<String, String> response = supplierManagementServiceImpl.saveRecords(null);
		assertEquals("Bad Request", response.get("message"));

	}

	@Test
	public void editCustomerManagementRecordTest() {
		Mockito.when(supplierManagementDoa.getEditSupplierData(2)).thenReturn(supplierServiceData());
		List<SupplierManagementFilter> response = supplierManagementServiceImpl
				.editSupplierManagementRecord(supplierServiceData().get(0).getSupplierId());
		assertEquals(2, response.get(0).getSupplierId());

	}

	@Test
	public void updateCustomerManagementRecordTest() {
		Mockito.when(supplierManagementDoa.save(supplierServiceData().get(0))).thenReturn(supplierServiceData().get(0));
		Map<String, String> response = supplierManagementServiceImpl
				.saveRecords(supplierServiceData().get(0));
		assertEquals("Success", response.get("message"));

	}

	@Test
	public void updateCustomerManagementNullRecordTest() {
		Mockito.when(supplierManagementDoa.save(null)).thenReturn(null);
		Map<String, String> response = supplierManagementServiceImpl.saveRecords(null);
		assertEquals("Bad Request", response.get("message"));

	}

}
