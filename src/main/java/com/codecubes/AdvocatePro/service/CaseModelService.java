package com.codecubes.AdvocatePro.service;

import com.codecubes.AdvocatePro.model.CaseModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
@Service
public class CaseModelService {
    private static final String COLLECTION_NAME = "caseModel";

    public String saveProduct(CaseModel caseModel) throws ExecutionException, InterruptedException {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(COLLECTION_NAME);

        // Use CompletableFuture to handle async operations
        CompletableFuture<String> future = new CompletableFuture<>();

        // Add the product to the database
        databaseReference.child(caseModel.getName()).setValue(caseModel, (databaseError, databaseReference1) -> {
            if (databaseError != null) {
                future.completeExceptionally(databaseError.toException());
            } else {
                future.complete("Product saved successfully");
            }
        });

        // Wait for the async operation to complete
        return future.get();
    }
}
