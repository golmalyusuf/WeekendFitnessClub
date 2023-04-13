package com.torik.assignment.serviceImpl;

import com.torik.assignment.bean.Customer;
import com.torik.assignment.service.RegisterCustomer;
import com.torik.assignment.serviceImpl.RegisterCustomerImpl;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegisterCustomerImplTest {


    @Test
    public void testAddCustomerToList() throws IOException {
        String input = "John\n1234567890\n"; // example input with name and mobile number
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        List<Customer> customerList = new ArrayList<Customer>();

        RegisterCustomer registerCustomer = new RegisterCustomerImpl();
        registerCustomer.addCustomerToList(customerList);

    }

    @Test
    public void TestAddCustomerToListWithName() throws IOException {
        List<Customer> customerList = new ArrayList<Customer>();

        RegisterCustomer registerCustomer = new RegisterCustomerImpl();
        registerCustomer.addCustomerToListWithName(customerList, "Torik", "123456");
    }
}