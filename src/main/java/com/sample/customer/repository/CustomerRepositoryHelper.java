package com.sample.customer.repository;

import com.sample.customer.model.CustomerModel;

import com.sample.customer.requests.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public class CustomerRepositoryHelper {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private CustomerMongoRepository customerRepo;

    public CustomerModel saveCustomerObject(CustomerModel customerModelObj){
        logger.info("Customer with Id {} saved in DB",customerModelObj.getCustomerId());
        return customerRepo.save(customerModelObj);
        }

        public void deleteCustomerObject(Long customerId){
            logger.info("Customer with Id {} deleted in DB",customerId);
            customerRepo.deleteById(customerId);

    }
    public void deleteSubsObject(Long subscriptionId){
            logger.info("Customer with Id {} deleted in DB",subscriptionId);
            customerRepo.deleteById(subscriptionId);

    }
        public CustomerModel updateCustomerObject(CustomerModel customerModel){
            logger.info("Customer with ID {} was updated in DB", customerModel.getCustomerId());
            return customerRepo.insert(customerModel);
        }


        public CustomerModel getCustomerObject(CustomerModel customerModelObj){
        logger.info("Customer retrieved");
        return customerRepo.save(customerModelObj);
        }

    public CustomerModel findById(Long customerID){
        Optional<CustomerModel> cust = customerRepo.findById(customerID);
        return cust.isPresent()?cust.get():null;
    }
}
