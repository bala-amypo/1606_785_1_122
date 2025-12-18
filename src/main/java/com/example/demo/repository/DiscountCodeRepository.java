package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DiscountCode;
import java.util.List;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    List<DiscountCode> findByInfluencerId(Long influencerId);
    List<DiscountCode> findByCampaignId(Long campaignId);
}
