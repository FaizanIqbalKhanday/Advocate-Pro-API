package com.codecubes.AdvocatePro.service;

import com.codecubes.AdvocatePro.model.CaseDetails;
import com.codecubes.AdvocatePro.repository.CaseModelRepository;
import org.springframework.stereotype.Service;
@Service
public class CaseModelService {
    private final CaseModelRepository caseModelRepository;

    public CaseModelService(CaseModelRepository caseModelRepository) {
        this.caseModelRepository = caseModelRepository;
    }
    public String addCaseDetails(CaseDetails caseDetails){
        caseModelRepository.save(caseDetails);
        return "success";
    }
    public CaseDetails getCaseDetails(String ncrNumber) {

        return caseModelRepository.findByNcrNumber(ncrNumber).get(0);
    }
}
