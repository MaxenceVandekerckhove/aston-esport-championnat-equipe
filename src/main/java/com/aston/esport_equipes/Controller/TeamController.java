package com.aston.esport_equipes.Controller;

import com.aston.esport_equipes.DTO.MemberRequest;
import com.aston.esport_equipes.Model.Team;
import com.aston.esport_equipes.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @PostMapping("")
    public String addTeam(@RequestBody Team team) {
        teamService.save(team);
        return "Team created successfully";
    }

    @PutMapping("/{equipeId}")
    public String addPlayersToTeam(@PathVariable("equipeId") String equipeId, @RequestBody Team updatedTeam) {

        Optional<Team> optionalTeam = teamService.findById(equipeId);

        if (optionalTeam.isPresent()) {

            updatedTeam.setId(optionalTeam.get().getId());

            List<String> memberList  = updatedTeam.getMembres();
            int numberOfIds = memberList.size();

            for (int i = 0; i < numberOfIds; i++ ) {
                String membreId = memberList.get(i);
                teamService.addPlayer(equipeId, membreId);
            }
            teamService.save(updatedTeam);
            return "Team members has been added";
        }
        else {
            return "There is no Teams with ID " + equipeId;
        }
    }

    @GetMapping("/{id}/players")
    public String getPlayersByTeam(@PathVariable("id")String teamId) {
        Optional<Team> optionalTeam = teamService.findById(teamId);

        if (optionalTeam.isPresent()) {
            List<String> playersIdsTeam = optionalTeam.get().getMembres();
        }

        return "";
    }
}
