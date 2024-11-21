import java.util.ArrayList;
import java.util.List;

public class CryptoSimulator {
    public static void main(String[] args) {
        int difficulty = 4;  // Adjust difficulty for mining time
        Blockchain blockchain = new Blockchain(difficulty);

        System.out.println("Creating initial transactions...");
        List<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(new Transaction("User1", "User2", 10));
        transactions1.add(new Transaction("User1", "User3", 20));

        System.out.println("Mining Block 1...");
        Block block1 = new Block(blockchain.getLatestBlock().getHash(), transactions1);
        blockchain.addBlock(block1);

        List<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(new Transaction("User2", "User1", 5));
        transactions2.add(new Transaction("User3", "User2", 15));

        System.out.println("Mining Block 2...");
        Block block2 = new Block(blockchain.getLatestBlock().getHash(), transactions2);
        blockchain.addBlock(block2);

        System.out.println("\nBlockchain is valid: " + blockchain.isChainValid());
        System.out.println("\nBlockchain contents:");
        for (Block block : blockchain.chain) {
            System.out.println("Block Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Transactions: " + block.getTransactions());
            System.out.println();
        }
    }
}
