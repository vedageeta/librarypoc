package com.fis.training.microservice.subscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.training.microservice.subscriptionservice.bean.Subscription;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String>  {

}
