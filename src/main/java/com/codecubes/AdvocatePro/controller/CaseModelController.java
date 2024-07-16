package com.codecubes.AdvocatePro.controller;

import com.codecubes.AdvocatePro.model.CaseDetails;
import com.codecubes.AdvocatePro.service.CaseModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/advocatepro")
public class CaseModelController {
    @Autowired
    private CaseModelService clientService;
    @PostMapping("/{casemodedl}")
    public String saveProduct(@RequestBody CaseDetails caseDetails) throws InterruptedException, ExecutionException {
        return clientService.saveProduct(caseDetails);
    }
}
