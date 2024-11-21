import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    List<Block> chain;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        this.chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        List<Transaction> genesisTransactions = new ArrayList<>();
        genesisTransactions.add(new Transaction("System", "User1", 100));  // Initial allocation
        return new Block("0", genesisTransactions);
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}

