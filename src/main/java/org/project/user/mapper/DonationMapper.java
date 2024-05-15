package org.project.user.mapper;

import org.mapstruct.Mapper;
import org.project.user.domain.Donations;
import org.project.user.feature.donation.dto.DonationRequest;
import org.project.user.feature.donation.dto.DonationResponse;

@Mapper(componentModel = "spring")
public interface DonationMapper {
    DonationResponse mapToDonationResponse(Donations donations);

    Donations mapToDonations(DonationRequest donationRequest);
}
