package org.project.user.feature.authority;

import org.project.user.domain.role.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities,String> {
}
