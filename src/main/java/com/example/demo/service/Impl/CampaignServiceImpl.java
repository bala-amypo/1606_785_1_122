package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import java.util.List;

public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        if (campaign.getStartDate() != null && campaign.getEndDate() != null) {
            if (campaign.getEndDate().isBefore(campaign.getStartDate())) {
                throw new IllegalArgumentException("Invalid date range");
            }
        }

        if (campaign.getCampaignName() != null) {
            existing.setCampaignName(campaign.getCampaignName());
        }

        if (campaign.getStartDate() != null) {
            existing.setStartDate(campaign.getStartDate());
        }

        if (campaign.getEndDate() != null) {
            existing.setEndDate(campaign.getEndDate());
        }

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }
}
