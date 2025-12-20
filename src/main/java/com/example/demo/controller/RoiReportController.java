package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/code/{discountCodeId}")
    public RoiReport generate(@PathVariable Long discountCodeId) {
        return roiService.generateReportForCode(discountCodeId);
    }

    @GetMapping("/{reportId}")
    public RoiReport getById(@PathVariable Long reportId) {
        return roiService.getReportById(reportId);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> byInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }
}
