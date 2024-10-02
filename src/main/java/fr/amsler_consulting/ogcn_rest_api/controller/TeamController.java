package fr.amsler_consulting.ogcn_rest_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import fr.amsler_consulting.ogcn_rest_api.model.Team;
import fr.amsler_consulting.ogcn_rest_api.services.TeamService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;

    /**
     * Renvoie la liste des équipe de foot
     * 
     * @param page   numéro de page
     * @param size   nb d elements retournés
     * @param sortBy tri sur un des champs dispo
     * @return Renvoie la liste des équipe de foot
     */
    @RequestMapping(method = { RequestMethod.GET })
    @Operation(summary = "getTeams", description = "Get list of teams")
    public List<Team> getTeams(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        logger.info("Call getTeams");
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return teamService.getTeams(pageable).getContent();
    }

    /**
     * Ajout une nouvelle équipe
     * 
     * @param team
     * @return
     */
    @RequestMapping(method = { RequestMethod.PUT })
    @Operation(summary = "addTeam", description = "Add a team")
    public Team addTeam(@RequestBody Team team) {
        logger.info("Call addTeam");
        Team savedTeam = teamService.addTeam(team);
        logger.info("new Team saved");
        return savedTeam;
    }

}
