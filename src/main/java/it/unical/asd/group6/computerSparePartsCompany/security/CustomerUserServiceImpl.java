package it.unical.asd.group6.computerSparePartsCompany.security;

import it.unical.asd.group6.computerSparePartsCompany.data.dao.CustomerDao;
import it.unical.asd.group6.computerSparePartsCompany.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUserServiceImpl implements UserDetailsService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String s) {
        System.out.println("looking for : "+ s);
        Optional<Customer> customer = customerDao.findCustomerByUsername(s);
        CustomerUser customerUser = new CustomerUser(customer.get());
        System.out.println(customer.toString());
        return customerUser;
    }
}
