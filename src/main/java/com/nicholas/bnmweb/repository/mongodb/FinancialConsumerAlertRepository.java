package com.nicholas.bnmweb.repository.mongodb;

import com.nicholas.bnmweb.entities.mongo.FinancialConsumerAlertEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.Future;

@Repository
public interface FinancialConsumerAlertRepository extends MongoRepository<FinancialConsumerAlertEntity, String> {
}
