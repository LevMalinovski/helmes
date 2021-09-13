package com.helmes.helmes.model.repository;

import com.helmes.helmes.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    List<Application> findAllByToken(String token);

    Optional<Application> findByIdAndToken(Long id, String token);
}
