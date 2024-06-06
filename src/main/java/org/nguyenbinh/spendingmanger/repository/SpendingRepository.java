package org.nguyenbinh.spendingmanger.repository;

import org.nguyenbinh.spendingmanger.model.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long>
{
}
