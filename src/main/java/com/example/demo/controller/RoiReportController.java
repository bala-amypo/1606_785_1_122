package com.example.demo.controller;

import com.example.demo.model.RoiReport;
import com.example.demo.service.RoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roi")
public class RoiReportController {

    private final RoiService roiService;

    public RoiReportController(RoiService roiService) {
        this.roiService = roiService;
    }

    @GetMapping("/influencer/{id}")
    public ResponseEntity<List<RoiReport>> getReportsForInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(roiService.getReportsForInfluencer(id));
    }
    @PostMapping("/generate/{codeId}")
    public ResponseEntity<RoiReport> generateRoi(@PathVariable Long codeId) {
        RoiReport report = roiService.generateRoiForCode(codeId);
        return ResponseEntity.ok(report);
    }
    @GetMapping("/campaign/{campaignId}")
    public ResponseEntity<List<RoiReport>> getReportsForCampaign(@PathVariable Long campaignId) {
        return ResponseEntity.ok(roiService.getReportsForCampaign(campaignId));
    }
    @PostMapping("/create")
public ResponseEntity<RoiReport> createRoi(@RequestBody RoiReport roiReport) {
    RoiReport savedReport = roiService.saveRoiReport(roiReport);
    return ResponseEntity.ok(savedReport);
}
}

