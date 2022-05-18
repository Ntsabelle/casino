package dagacube.casino.service;

import dagacube.casino.entity.Player;
import dagacube.casino.entity.Transaction;
import dagacube.casino.exception.PlayerNotFound;
import dagacube.casino.repo.IPlayerRepo;
import dagacube.casino.repo.ITransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service

public class Service {

    private final IPlayerRepo playerRepo;
    private final ITransactionRepo transactRepo;

    @Autowired
    public Service(IPlayerRepo playerRepo, ITransactionRepo transactRepo) {
        this.playerRepo = playerRepo;
        this.transactRepo = transactRepo;
    }

    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    public Player getPlayerById(long id) {
        return playerRepo.findById(id).orElseThrow(() ->
                new PlayerNotFound(
                        "Player with id " + id + " does not exists"));
    }

    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }

    public Player updatePlayer(Player player, long id) {
        Player existingPlayer = playerRepo.findById(id).orElseThrow(
                () -> new PlayerNotFound(
                        "Player with id " + id + " does not exists"));
        existingPlayer.setBalance(player.getBalance());
        playerRepo.save(existingPlayer);
        return existingPlayer;
    }


}
