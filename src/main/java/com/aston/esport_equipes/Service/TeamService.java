package com.aston.esport_equipes.Service;

import com.aston.esport_equipes.Model.Team;
import com.aston.esport_equipes.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAll() {
        return  teamRepository.findAll();
    }

    public Optional<Team> findById(String equipeId) {
        return teamRepository.findById(equipeId);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public String addPlayer(String teamId,String idPlayer){
        Optional<Team> teamExist = teamRepository.findById(teamId);

        if(teamExist.isPresent())
        {
            teamExist.get().getMembres().add(idPlayer);
            return "Player added to the team";
        }
        else
        {
            return "Team doesn't exist";
        }
    }
}
