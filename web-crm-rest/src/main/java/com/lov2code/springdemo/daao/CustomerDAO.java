package com.lov2code.springdemo.daao;

import com.lov2code.springdemo.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void saveCustomer(Customer customer);

    Customer updateCustomer(int theId);

    void deleteCustomer(int id);
}