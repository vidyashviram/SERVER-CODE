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

import com.mro.drc.administrator.dao.CustomerManagementDao;
import com.mro.drc.administrator.dto.CustomerManagementFilter;
import com.mro.drc.administrator.entity.LkupCustomer;
import com.mro.drc.administrator.serviceImpl.CustomerManagementServiceImpl;

public class CustomerManagementServiceImplTest {

	@InjectMocks
	CustomerManagementServiceImpl customerManagementServiceImpl;

	@Mock
	CustomerManagementDao customerManagementDoa;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	Date myDate = new Date(2014, 02, 11);

	public List<LkupCustomer> custumerServiceData() {
		List<LkupCustomer> dummydata = new ArrayList<>();

		LkupCustomer customerAddRequest = new LkupCustomer();
		customerAddRequest.setCustName("Apurva");
		customerAddRequest.setCustEmail("apurva.reja2gmail.com");
		customerAddRequest.setCustid(2);
		customerAddRequest.setCustPhone("11212548");
		customerAddRequest.setCustAddress("IND");
		customerAddRequest.setCustNum("1011");
		customerAddRequest.setModifiedDate(myDate);
		customerAddRequest.setCreatedDate(myDate);
		customerAddRequest.setBillTo("Lnt");
		customerAddRequest.setShipTo("Delta");
		customerAddRequest.setActive(false);

		dummydata.add(customerAddRequest);
		return dummydata;
	}

	@Test
	public void getCustumerListServicesTest() {
		Mockito.when(customerManagementDoa.getCustumerList()).thenReturn(custumerServiceData());
		List<CustomerManagementFilter> response = customerManagementServiceImpl.getCustumerList();
		assertEquals("Apurva", response.get(0).getCustName());

	}

	@Test
	public void saveCustomerManagementRecordTest() {

		LkupCustomer customerAddRequest = custumerServiceData().get(0);
		Mockito.when(customerManagementDoa.saveAndFlush(customerAddRequest)).thenReturn(customerAddRequest);
		Map<String, String> response = customerManagementServiceImpl.saveRecords(customerAddRequest);
		assertEquals("Success", response.get("message"));

	}
	
	

	@Test
	public void saveCustomerManagementNullRecordTest() {

		Mockito.when(customerManagementDoa.saveAndFlush(null)).thenReturn(null);
		Map<String, String> response = customerManagementServiceImpl.saveRecords(null);
		assertEquals("Bad Request", response.get("message"));

	}

	@Test
	public void editCustomerManagementRecordTest() {
		List<LkupCustomer> dummydata = new ArrayList<>();
		Mockito.when(customerManagementDoa.getEditCustumerData(2)).thenReturn(custumerServiceData());
		List<CustomerManagementFilter> response = customerManagementServiceImpl
				.editCustomerManagementRecord(custumerServiceData().get(0).getCustid());
		assertEquals(2, response.get(0).getCustid());

	}

	

//	@Test
//	public void deleteCustomerManagementRecord() {
//		doNothing().when(customerManagementDoa);
//		stubVoid(customerManagementServiceImpl)
//        customer.eat(dish);
//		//Map<String, String> response = customerManagementServiceImpl.updateCustomerManagementRecord(custumerServiceData().get(0));	
//		 verify(customerManagementServiceImpl, times(2)).deleteCustomerManagementRecord(custumerServiceData().get(0).getCustid());
//		
//	}
	

}
