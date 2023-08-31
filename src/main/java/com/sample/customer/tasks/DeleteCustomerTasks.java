
package com.sample.customer.tasks;

import com.sample.customer.repository.CustomerMongoRepository;
import com.sample.customer.model.CustomerModel;
import com.sample.customer.repository.CustomerRepositoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerTasks {


    private static  final String SUCCESS_MESSAGE = "Customer %s removed successfully";

    private static  final String FAILURE_MESSAGE = "Customer with ID %s does not exist";


    @Autowired
    private CustomerRepositoryHelper customerRepositoryHelper;

    public String deleteCustomer(Long customerID){

        try{
            if(customerExists(customerID)) {
                customerRepositoryHelper.deleteCustomerObject(customerID);
                return String.format(SUCCESS_MESSAGE,customerID);
            }
            else {
                return String.format(FAILURE_MESSAGE,customerID);
            }
        }catch(Exception e){
            throw new RuntimeException(FAILURE_MESSAGE);
        }
    }

    private boolean customerExists(Long customerID) {
       return customerRepositoryHelper.findById(customerID) != null;
    }


}
