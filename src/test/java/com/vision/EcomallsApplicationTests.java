package com.vision;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.vision.service.*;
@SpringBootTest
class EcomallsApplicationTests {
	@Autowired
    private CustomerServiceImpl cService;
	@Test
	void contextLoads() {
	}
    @Test
    void getAllCustomer() {
    	cService.getAllCustomer();
    }
    @Test
    void deleteCustomer() {
    	cService.deleteCustomer(104);
    }
    @Test
    void getCustomerById() {
    	cService.getCustomerById(100);
    }
}
