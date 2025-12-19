package com.example.demo.service.impl;

import com.example.demo.model.Campaign;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository repository;

    public CampaignServiceImpl(CampaignRepository repository) {
        this.repository = repository;
    }

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        Campaign existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));

        if (campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("Invalid date range");
        }

        existing.setCampaignName(campaign.getCampaignName());
        existing.setStartDate(campaign.getStartDate());
        existing.setEndDate(campaign.getEndDate());

        return repository.save(existing);
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found"));
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return repository.findAll();
    }
}
