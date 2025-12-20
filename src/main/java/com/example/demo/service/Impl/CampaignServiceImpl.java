package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Override
public Campaign createCampaign(Campaign campaign) {

    if (campaign.getStartDate() != null && campaign.getEndDate() != null) {
        if (campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("Invalid date range");
        }
    }

    return campaignRepository.save(campaign);
}
