package in.bt.demochain.model;

/**
 * Blockchain Trainer (www.blockchaintrainer.in)
 * 
 * This is a model object for a Block, it has an index and a previous hash
 * The data can carry anything that we want on the block, like a coin transfer information, or IOT inputs.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Block {

    private int index;
    private long timestamp;
    private String hash;
    private String previousHash;
    private List<Transaction> transactions = new ArrayList<>();
    private int nonce;

    public Block(int index, long timestamp, String previousHash, List<Transaction> transactions) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.transactions.addAll(transactions);
        nonce = 0;
        hash = Block.calculateHash(this);
    }
    
    public Block(int index, long timestamp, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;        
        nonce = 0;
        hash = Block.calculateHash(this);
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return transactions.toString();
    }

    public String str() {
        return index + timestamp + previousHash + transactions.toString() + nonce;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Block #")
            .append(index)
            .append(" [previousHash : ")
            .append(previousHash)
            .append(", ")
            .append("timestamp : ")
            .append(new Date(timestamp))
            .append(", ")
            .append("data : ")
            .append(transactions.toString())
            .append(", ")
            .append("hash : ")
            .append(hash)
            .append("]");
        return builder.toString();
    }

    public static String calculateHash(Block block) {
        if (block != null) {
            MessageDigest digest = null;

            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                return null;
            }

            String txt = block.str();
            final byte bytes[] = digest.digest(txt.getBytes());
            final StringBuilder builder = new StringBuilder();

            for (final byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    builder.append('0');
                }

                builder.append(hex);
            }

            return builder.toString();
        }

        return null;
    }

    /**
     * mine the block passing the level of difficulty, this is very similar to bitcoin difficulty 
     * @param difficulty
     */
    public void mineBlock(int difficulty) {
        nonce = 0;
        String matcher = new String(new char[difficulty]).replace("\0", "0");
        while (!getHash().startsWith(matcher)) {
            nonce++;
            hash = Block.calculateHash(this);
        }
    }

}
