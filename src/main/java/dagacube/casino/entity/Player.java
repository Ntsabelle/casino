package dagacube.casino.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {


    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "player_sequence",
            strategy = GenerationType.SEQUENCE)
    private Long id;

    private double balance;
    @OneToMany(targetEntity = Transaction.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pt_fk",referencedColumnName = "id")
    @Transient
    private List<Transaction> transactions;

    public Player(){

        transactions = new ArrayList<>();
    }

    public Player(Long id, double balance) {
        this.id = id;
        this.balance = balance;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if
        this.balance = balance;
    }
    //Average cal balance
    public double calcBal()
    {

        double sum =0.0;
        double bal =0.0;
        for (Transaction transaction:transactions)
        {
            sum+=transaction.getAmount();
            bal= Double.valueOf((sum/transactions.size()));
        }
        return bal;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
