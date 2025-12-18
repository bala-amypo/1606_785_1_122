package com.example.demo.controller;

import com.example.demo.model.DiscountCode;
import com.example.demo.service.DiscountCodeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount-codes")
public class DiscountCodeController {

    private final DiscountCodeService discountCodeService;

    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    // GET /discount-codes/{id}
    @GetMapping("/{id}")
    public DiscountCode getDiscountCodeById(@PathVariable Long id) {
        return discountCodeService.getDiscountCodeById(id);
    }

    // PUT /discount-codes/{id}
    @PutMapping("/{id}")
    public DiscountCode updateDiscountCode(
            @PathVariable Long id,
            @RequestBody DiscountCode updated) {

        return discountCodeService.updateDiscountCode(id, updated);
    }

    // GET /discount-codes/influencer/{influencerId}
    @GetMapping("/influencer/{influencerId}")
    public List<DiscountCode> getCodesForInfluencer(
            @PathVariable Long influencerId) {

        return discountCodeService.getCodesForInfluencer(influencerId);
    }

    // GET /discount-codes/campaign/{campaignId}
    @GetMapping("/campaign/{campaignId}")
    public List<DiscountCode> getCodesForCampaign(
            @PathVariable Long campaignId) {

        return discountCodeService.getCodesForCampaign(campaignId);
    }
}
