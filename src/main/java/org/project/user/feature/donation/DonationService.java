package org.project.user.feature.donation;

import org.project.user.feature.donation.dto.DonationRequest;
import org.project.user.feature.donation.dto.DonationResponse;

public interface DonationService {
    DonationResponse donate(DonationRequest donationRequest);
}
