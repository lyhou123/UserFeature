package org.project.user.feature.donation;

import org.project.user.domain.Donations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donations,String> {
}
