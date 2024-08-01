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
import java.util.Optional;

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
    public AdvocateDetails getCaseDetails(String advocatePhoneNumber) {
        AdvocateDetails advocateDetails=caseModelRepository.findByAdvocatePhoneNumber(advocatePhoneNumber).get(0);
        if (advocateDetails==null){
            throw new ResourceNotFoundException("Advocate with ID " + advocatePhoneNumber + " not found");
        }
        return advocateDetails;
    }
    public Optional<Cases> getCaseByNcrNumber(String ncrNumber) {
        return caseModelRepository.findAll().stream()
                .flatMap(advocateDetails -> advocateDetails.getCasesList().stream())
                .filter(caseDetails -> caseDetails.getCaseDetails().getNcrNumber().equals(ncrNumber))
                .findFirst();
    }
    public Optional<Cases> getCaseByFirNumber(int firNumber) {
        return caseModelRepository.findAll().stream()
                .flatMap(advocateDetails -> advocateDetails.getCasesList().stream())
                .filter(firDetails -> firDetails.getFirDetails().getFirNumber()==firNumber)
                .findFirst();
    }
    public Optional<Cases> getCaseByRegistrationNumber(String registrationNumber) {
        return caseModelRepository.findAll().stream()
                .flatMap(advocateDetails -> advocateDetails.getCasesList().stream())
                .filter(caseDetails -> caseDetails.getCaseDetails().getRegistrationNumber().equals(registrationNumber))
                .findFirst();
    }
    public Optional<Cases> getCaseByFilingNumber(String filingNumber) {
        return caseModelRepository.findAll().stream()
                .flatMap(advocateDetails -> advocateDetails.getCasesList().stream())
                .filter(caseDetails -> caseDetails.getCaseDetails().getFilingNumber().equals(filingNumber))
                .findFirst();
    }
    public void updateCloudVendor(AdvocateDetails advocateDetails) {
        caseModelRepository.save(advocateDetails);
    }
    public String getAdvocateNameById(String advocateEmail) {
        return caseModelRepository.findAdvocateNameById(advocateEmail);
    }
    public void deleteAdvocateById(String advocatePhoneNumber) {
        if (caseModelRepository.existsById(advocatePhoneNumber)) {
            caseModelRepository.deleteById(advocatePhoneNumber);
        } else {
            throw new RuntimeException("Advocate not found");
        }
    }
    @Transactional
    public void deleteCaseByNcrNumber(String advocatePhoneNumber, String ncrNumber) {
        AdvocateDetails advocateDetails = caseModelRepository.findById(advocatePhoneNumber).orElseThrow(() -> new RuntimeException("Advocate not found"));

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

