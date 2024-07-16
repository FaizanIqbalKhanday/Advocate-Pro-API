package com.codecubes.AdvocatePro.controller;

import com.codecubes.AdvocatePro.model.CaseDetails;
import com.codecubes.AdvocatePro.service.CaseModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/advocatepro")
public class CaseModelController {
   // @Autowired
    private final CaseModelService caseModelService;

    public CaseModelController(CaseModelService caseModelService) {
        this.caseModelService = caseModelService;
    }

    @PostMapping()
    public String addCaseDetails(@RequestBody CaseDetails caseDetails){
        caseModelService.addCaseDetails(caseDetails);
        return "case details added successfully";
    }
    @GetMapping("/{ncrNumber}")
    public CaseDetails getCaseDetails(@PathVariable("ncrNumber") String ncrNumber){
        return caseModelService.getCaseDetails(ncrNumber);
    }

}
