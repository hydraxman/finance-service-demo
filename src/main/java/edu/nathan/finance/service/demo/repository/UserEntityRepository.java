package edu.nathan.finance.service.demo.repository;

import edu.nathan.finance.service.demo.model.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserEntityRepository extends ReactiveCrudRepository<UserEntity, Integer> {

}