import com.example.demo.model.Campaign;
import com.example.demo.service.CampaignService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping
    public Campaign create(@RequestBody Campaign campaign) {
        return campaignService.createCampaign(campaign);
    }

    @PutMapping("/{id}")
    public Campaign update(@PathVariable Long id, @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(id, campaign);
    }

    @GetMapping("/{id}")
    public Campaign getById(@PathVariable Long id) {
        return campaignService.getCampaignById(id);
    }

    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.getAllCampaigns();
    }
}
