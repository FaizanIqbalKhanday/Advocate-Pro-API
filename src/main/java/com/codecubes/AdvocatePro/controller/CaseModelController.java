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
