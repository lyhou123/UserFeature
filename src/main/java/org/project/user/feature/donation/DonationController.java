package org.project.user.feature.donation;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.donation.dto.DonationRequest;
import org.project.user.feature.donation.dto.DonationResponse;
import org.project.user.utils.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/donation")
@RequiredArgsConstructor
public class DonationController {

    private final DonationService donationService;

    @PostMapping
    public BaseResponse<DonationResponse> donate(DonationRequest donationRequest) {
        return BaseResponse.<DonationResponse>createSuccess()
                .setPayload(donationService.donate(donationRequest));
    }
}
