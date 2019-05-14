package com.nicholas.bnmweb.repository.mongodb;

import com.nicholas.bnmweb.entities.mongo.FinancialConsumerAlertEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialConsumerAlertRepository extends MongoRepository<FinancialConsumerAlertEntity, String> {

}
