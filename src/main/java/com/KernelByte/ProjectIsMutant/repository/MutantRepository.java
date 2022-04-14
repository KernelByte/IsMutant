package com.KernelByte.ProjectIsMutant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.KernelByte.ProjectIsMutant.models.Mutant;


@Repository
public interface MutantRepository extends MongoRepository<Mutant, String> {

}
