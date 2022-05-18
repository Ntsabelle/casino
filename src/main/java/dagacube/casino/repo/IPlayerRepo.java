package dagacube.casino.repo;

import dagacube.casino.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepo extends JpaRepository<Player,Long> {
}
