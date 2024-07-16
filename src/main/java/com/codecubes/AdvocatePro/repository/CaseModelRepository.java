package com.codecubes.AdvocatePro.repository;

import com.codecubes.AdvocatePro.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseModelRepository extends JpaRepository<CaseDetails,String> {
    List<CaseDetails>findByNcrNumber(String ncrNumber);
    List<CaseDetails>findByCaseType(String caseType);

}
