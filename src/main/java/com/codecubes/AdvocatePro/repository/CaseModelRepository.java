package com.codecubes.AdvocatePro.repository;

import com.codecubes.AdvocatePro.model.AdvocateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseModelRepository extends JpaRepository<AdvocateDetails,String> {
    List<AdvocateDetails> findByAdvocateId(String advocateId);
    @Query("SELECT a.AdvocateName FROM AdvocateDetails a WHERE a.advocateId = :advocateId")
    String findAdvocateNameById(String advocateId);
   void deleteByAdvocateId(String advocateId);


}
