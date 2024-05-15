package org.project.user.feature.donation.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record DonationRequest(
      String material,
      String Amount,
      String screenShot,
      String post
) {
}
