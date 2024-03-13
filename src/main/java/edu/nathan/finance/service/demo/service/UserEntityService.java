package edu.nathan.finance.service.demo.service;

import edu.nathan.finance.service.demo.model.UserEntity;
import edu.nathan.finance.service.demo.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public Flux<UserEntity> getUsers() {
        return userEntityRepository.findAll();
    }

    public Mono<UserEntity> getUser(Integer id) {
        return userEntityRepository.findById(id);
    }
}
