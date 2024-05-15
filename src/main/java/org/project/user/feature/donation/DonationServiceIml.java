package org.project.user.feature.donation;

import lombok.RequiredArgsConstructor;
import org.project.user.feature.donation.dto.DonationRequest;
import org.project.user.feature.donation.dto.DonationResponse;
import org.project.user.mapper.DonationMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonationServiceIml implements DonationService{

    private final DonationRepository donationRepository;

    private final DonationMapper donationMapper;
    @Override
    public DonationResponse donate(DonationRequest donationRequest) {
        var donate = donationMapper.mapToDonations(donationRequest);
        return donationMapper.mapToDonationResponse(donationRepository.save(donate));
    }
}
