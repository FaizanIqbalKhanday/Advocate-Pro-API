package com.codecubes.AdvocatePro.service;

import com.codecubes.AdvocatePro.exception.GlobalExceptionHandler;
import com.codecubes.AdvocatePro.model.AdvocateDetails;
import com.codecubes.AdvocatePro.model.CaseDetails;
import com.codecubes.AdvocatePro.model.Cases;
import com.codecubes.AdvocatePro.repository.CaseModelRepository;
import jakarta.transaction.Transactional;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class CaseModelService {
    @Autowired
    private final CaseModelRepository caseModelRepository;

    public CaseModelService(CaseModelRepository caseModelRepository) {
        this.caseModelRepository = caseModelRepository;
    }
    public void addCaseDetails(AdvocateDetails caseDetails){
        caseModelRepository.save(caseDetails);

    }
    public AdvocateDetails getCaseDetails(String advocateId) {
        AdvocateDetails advocateDetails=caseModelRepository.findByAdvocateId(advocateId).get(0);
        if (advocateDetails==null){
            throw new ResourceNotFoundException("Advocate with ID " + advocateId + " not found");
        }
        return advocateDetails;
    }
    public void updateCloudVendor(AdvocateDetails advocateDetails) {
        caseModelRepository.save(advocateDetails);
    }
    public String getAdvocateNameById(String advocateId) {
        return caseModelRepository.findAdvocateNameById(advocateId);
    }
    public void deleteAdvocateById(String advocateId) {
        if (caseModelRepository.existsById(advocateId)) {
            caseModelRepository.deleteById(advocateId);
        } else {
            throw new RuntimeException("Advocate not found");
        }
    }
    @Transactional
    public void deleteCaseByNcrNumber(String advocateId, String ncrNumber) {
        AdvocateDetails advocateDetails = caseModelRepository.findById(advocateId).orElseThrow(() -> new RuntimeException("Advocate not found"));

        Iterator<Cases> iterator = advocateDetails.getCasesList().iterator();
        while (iterator.hasNext()) {
            CaseDetails caseDetails = iterator.next().getCaseDetails();
            if (caseDetails.getNcrNumber().equals(ncrNumber)) {
                iterator.remove();  // Remove the case from the list
                break;
            }
        }

        caseModelRepository.save(advocateDetails); // Save the updated advocateDetails entity
    }
}

