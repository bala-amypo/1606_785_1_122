package com.example.demo.repository;

import com.example.demo.model.SaleTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {

    List<SaleTransaction> findByDiscountCodeId(Long discountCodeId);

    List<SaleTransaction> findByDiscountCodeInfluencerId(Long influencerId);

    List<SaleTransaction> findByDiscountCodeCampaignId(Long campaignId);
}

