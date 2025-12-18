package com.example.demo.controller;

import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    // PUT /campaigns/{id}
    @PutMapping("/{id}")
    public Campaign updateCampaign(
            @PathVariable Long id,
            @RequestBody Campaign campaign) {

        return campaignService.updateCampaign(id, campaign);
    }

    // GET /campaigns/{id}
    @GetMapping("/{id}")
    public Campaign getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    // GET /campaigns
    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }
}
