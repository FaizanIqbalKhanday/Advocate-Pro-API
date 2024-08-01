package com.codecubes.AdvocatePro.controller;

import com.codecubes.AdvocatePro.exception.GlobalExceptionHandler;
import com.codecubes.AdvocatePro.model.AdvocateDetails;
import com.codecubes.AdvocatePro.model.Cases;
import com.codecubes.AdvocatePro.service.CaseModelService;
import org.apache.catalina.connector.Response;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    @GetMapping("/{advocatePhoneNumber}")
    public AdvocateDetails getCaseDetails(@PathVariable("advocatePhoneNumber") String advocatePhoneNumber){
        AdvocateDetails advocateDetails=caseModelService.getCaseDetails(advocatePhoneNumber);
        return new ResponseEntity<>(advocateDetails, HttpStatus.OK).getBody();
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody AdvocateDetails advocateDetails){

        caseModelService.updateCloudVendor(advocateDetails);
        return "case Details updated Successfully";
    }


    @GetMapping("/{advocateEmail}/name")
    public String getAdvocateName(@PathVariable("advocateEmail") String advocateEmail){
        return caseModelService.getAdvocateNameById(advocateEmail);
    }
    @GetMapping("/{ncrNumber}/ncr")
    public ResponseEntity<Cases> getCaseByNcrNumber(@PathVariable String ncrNumber) {
        Optional<Cases> caseDetails = caseModelService.getCaseByNcrNumber(ncrNumber);
        return caseDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{firNumber}/fir")
    public ResponseEntity<Cases> getCaseByFirNumber(@PathVariable int firNumber) {
        Optional<Cases> caseDetails = caseModelService.getCaseByFirNumber(firNumber);
        return caseDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{registrationNumber}/reg")
    public ResponseEntity<Cases> getCaseByRegistrationNumber(@PathVariable String registrationNumber) {
        Optional<Cases> caseDetails = caseModelService.getCaseByRegistrationNumber(registrationNumber);
        return caseDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{filingNumber}/fil")
    public ResponseEntity<Cases> getCaseByFilingNumber(@PathVariable String filingNumber) {
        Optional<Cases> caseDetails = caseModelService.getCaseByFilingNumber(filingNumber);
        return caseDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{advocatePhoneNumber}")
    public ResponseEntity<String> deleteAdvocateDetailsById(@PathVariable("advocatePhoneNumber")String advocatePhoneNumber) throws GlobalExceptionHandler {
        caseModelService.deleteAdvocateById(advocatePhoneNumber);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{advocatePhoneNumber}/cases/{ncrNumber}")
    public ResponseEntity<?> deleteCase(@PathVariable String advocatePhoneNumber, @PathVariable String ncrNumber) {
        caseModelService.deleteCaseByNcrNumber(advocatePhoneNumber, ncrNumber);
        return ResponseEntity.ok().build();
    }


}
