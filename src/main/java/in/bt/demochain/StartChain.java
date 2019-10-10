package in.bt.demochain;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import in.bt.demochain.model.Transaction;
import in.bt.demochain.utils.CommonConstants;
import in.bt.demochain.utils.CommonUtils;

/**
 * Blockchain Trainer (www.blockchaintrainer.in)
 * 
 * This is start blockchain spring boot class
 * it adds four blocks after setting the mining difficulty level 
 */

@SpringBootApplication
public class StartChain implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StartChain.class).headless(false)
            .run(args);
    }

    @Override
    public void run(String... args) {
        System.err.println("starting chain...");
        Blockchain blockchain = new Blockchain(CommonConstants.DIFFICULTY);
        //create a few transactions
        List<Transaction> transactions = CommonUtils.createTransactions(4);
        //add them to a block , and add the block to the chain
        blockchain.addBlock(blockchain.newBlock(transactions));
        //create a few more
        transactions = CommonUtils.createTransactions(2); 
        //add again
        blockchain.addBlock(blockchain.newBlock(transactions));
        //few more
        transactions = CommonUtils.createTransactions(5);
        //add again
        blockchain.addBlock(blockchain.newBlock(transactions));
        //lastly another 2
        transactions = CommonUtils.createTransactions(3);
        //add them too
        blockchain.addBlock(blockchain.newBlock(transactions));
        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        System.out.println(blockchain);

    }
}
