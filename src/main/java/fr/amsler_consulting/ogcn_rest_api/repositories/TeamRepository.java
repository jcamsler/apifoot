package fr.amsler_consulting.ogcn_rest_api.repositories;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import fr.amsler_consulting.ogcn_rest_api.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Page<Team> findAll(Pageable pageable);
}
