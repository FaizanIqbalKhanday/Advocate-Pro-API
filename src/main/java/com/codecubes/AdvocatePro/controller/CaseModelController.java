package com.codecubes.AdvocatePro.controller;

import com.codecubes.AdvocatePro.exception.GlobalExceptionHandler;
import com.codecubes.AdvocatePro.model.AdvocateDetails;
import com.codecubes.AdvocatePro.service.CaseModelService;
import org.apache.catalina.connector.Response;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/advocatepro")
public class CaseModelController {
    @Autowired
    private final CaseModelService caseModelService;

    public CaseModelController(CaseModelService caseModelService) {
        this.caseModelService = caseModelService;
    }

    @PostMapping()
    public String addCaseDetails(@RequestBody AdvocateDetails caseDetails){
        caseModelService.addCaseDetails(caseDetails);
        return "case details added successfully";
    }
    @GetMapping("/{advocateId}")
    public AdvocateDetails getCaseDetails(@PathVariable("advocateId") String advocateId){
        AdvocateDetails advocateDetails=caseModelService.getCaseDetails(advocateId);
        return new ResponseEntity<>(advocateDetails, HttpStatus.OK).getBody();
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody AdvocateDetails advocateDetails){

        caseModelService.updateCloudVendor(advocateDetails);
        return "case Details updated Successfully";
    }


    @GetMapping("/{advocateId}/name")
    public String getAdvocateName(@PathVariable("advocateId") String advocateId){
        return caseModelService.getAdvocateNameById(advocateId);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{advocateId}")
    public ResponseEntity<String> deleteAdvocateDetailsById(@PathVariable("advocateId")String advocateId) throws GlobalExceptionHandler {
        caseModelService.deleteAdvocateById(advocateId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{advocateId}/cases/{ncrNumber}")
    public ResponseEntity<?> deleteCase(@PathVariable String advocateId, @PathVariable String ncrNumber) {
        caseModelService.deleteCaseByNcrNumber(advocateId, ncrNumber);
        return ResponseEntity.ok().build();
    }


}
