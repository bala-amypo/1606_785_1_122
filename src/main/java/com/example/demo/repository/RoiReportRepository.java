package com.example.demo.repository;

import com.example.demo.model.RoiReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {

    List<RoiReport> findByDiscountCodeInfluencerId(Long influencerId);
}
