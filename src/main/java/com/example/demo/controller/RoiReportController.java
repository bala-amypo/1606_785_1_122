package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @PostMapping("/generate/{codeId}")
    public RoiReport generateRoi(@PathVariable Long codeId) {
        return roiService.generateReportForCode(codeId);
    }

    @GetMapping("/{id}")
    public RoiReport getRoiById(@PathVariable Long id) {
        return roiService.getReportById(id);
    }

    @GetMapping("/influencer/{influencerId}")
    public List<RoiReport> getRoiByInfluencer(@PathVariable Long influencerId) {
        return roiService.getReportsForInfluencer(influencerId);
    }

    @GetMapping("/campaign/{campaignId}")
    public List<RoiReport> getRoiByCampaign(@PathVariable Long campaignId) {
        return roiService.getReportsForCampaign(campaignId);
    }
}
