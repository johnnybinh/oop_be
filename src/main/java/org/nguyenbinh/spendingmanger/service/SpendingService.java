package org.nguyenbinh.spendingmanger.service;
import org.nguyenbinh.spendingmanger.model.Spending;
import org.nguyenbinh.spendingmanger.repository.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SpendingService {
    @Autowired
    private SpendingRepository spendingRepository;

    public Spending SaveSpending(Spending spending){
        return spendingRepository.save(spending);
    }

    public void deleteSpending(Long id) {
        spendingRepository.deleteById(id);
    }
    public Optional<Spending> getSpendingById(Long id) {
        return spendingRepository.findById(id);
    }

    public List<Spending> getAllSpendings() {
        return spendingRepository.findAll();
    }
}
