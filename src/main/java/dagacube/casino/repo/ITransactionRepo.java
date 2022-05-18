package dagacube.casino.repo;

import dagacube.casino.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepo extends JpaRepository<Transaction,Long> {
}
