package com.codecubes.AdvocatePro.repository;

import com.codecubes.AdvocatePro.model.AdvocateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseModelRepository extends JpaRepository<AdvocateDetails,String> {
    List<AdvocateDetails> findByAdvocatePhoneNumber(String advocatePhoneNumber);
    Optional<AdvocateDetails> findById(String advocatePhoneNumber);
    @Query("SELECT a.AdvocateName FROM AdvocateDetails a WHERE a.advocateEmail = :advocateEmail")
    String findAdvocateNameById(String advocateEmail);
   void deleteByAdvocatePhoneNumber(String advocatePhoneNumber);


}
