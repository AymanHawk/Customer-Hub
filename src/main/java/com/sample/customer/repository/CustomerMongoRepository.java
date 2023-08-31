package com.sample.customer.repository;

import com.sample.customer.model.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoRepository extends MongoRepository<CustomerModel,Long> {
}
