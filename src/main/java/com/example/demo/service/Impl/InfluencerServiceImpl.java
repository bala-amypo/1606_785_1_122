package com.example.demo.service.impl;

import com.example.demo.model.Influencer;
import com.example.demo.repository.InfluencerRepository;
import com.example.demo.service.InfluencerService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    private final InfluencerRepository repository;

    public InfluencerServiceImpl(InfluencerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        repository.findBySocialHandle(influencer.getSocialHandle())
                .ifPresent(i -> {
                    throw new RuntimeException("Duplicate social handle");
                });
        return repository.save(influencer);
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return repository.findAll();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Influencer not found"));
    }
}
