package dagacube.casino.controller;

import dagacube.casino.entity.Player;
import dagacube.casino.entity.Transaction;
import dagacube.casino.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "player")
public class Controller {

    private final Service playerService;
    private final Service transactionService;

    @Autowired
    public Controller(Service playerService, Service transactionService) {

        this.playerService = playerService;
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("{id}/balance")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") long id) {
        return new ResponseEntity<Player>(playerService.getPlayerById(id), HttpStatus.OK);
    }

    @PutMapping("{id}/balance/update")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id
            ,@RequestBody Player player){
        return new ResponseEntity<Player>(playerService.updatePlayer(player, id), HttpStatus.OK);
    }



}

