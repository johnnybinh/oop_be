package org.nguyenbinh.spendingmanger.controller;

import org.nguyenbinh.spendingmanger.model.Spending;
import org.nguyenbinh.spendingmanger.service.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/spending")
public class SpendingController {
    private SpendingService spendingService;
    @Autowired
    public SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @PostMapping
    public ResponseEntity<Spending> createSpending(@RequestBody Spending spending){
        Spending saveSpending = spendingService.SaveSpending(spending);
        return ResponseEntity.ok(saveSpending);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spending> getSpendingById(@PathVariable Long id) {
        Optional<Spending> spending = spendingService.getSpendingById(id);
        if (spending.isPresent()) {
            return ResponseEntity.ok(spending.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSpendingById(@PathVariable Long id){
        Optional<Spending> spending =spendingService.getSpendingById(id);
        if(spending.isPresent()){
            spendingService.deleteSpending(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Spending>> getAllSpendings() {
        List<Spending> spendings = spendingService.getAllSpendings();
        return ResponseEntity.ok(spendings);
    }
}
