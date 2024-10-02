package fr.amsler_consulting.ogcn_rest_api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.amsler_consulting.ogcn_rest_api.controller.TeamController;
import fr.amsler_consulting.ogcn_rest_api.model.Team;
import fr.amsler_consulting.ogcn_rest_api.repositories.TeamRepository;

@Service
@Transactional
public class TeamService {

    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    public Page<Team> getTeams(Pageable pageable) {
        logger.info("getTeams called");
        return teamRepository.findAll(pageable);
    }

    public Team addTeam(Team team) {
        logger.info("addTeam called");
        return teamRepository.save(team);
    }
}