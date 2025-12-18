package com.example.demo.service;

import com.example.demo.model.Campaign;
import java.util.List;

public interface CampaignService {
    Campaign updateCampaign(Long id, Campaign campaign);
    Campaign getCampaignById(Long id);
    List<Campaign> getAllCampaigns();
}
