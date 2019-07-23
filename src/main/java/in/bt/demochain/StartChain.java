package in.bt.demochain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import in.bt.demochain.utils.CommonConstants;

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
        blockchain.addBlock(blockchain.newBlock("blockchain trainer"));
        blockchain.addBlock(blockchain.newBlock("IOTA data"));
        blockchain.addBlock(blockchain.newBlock("https://www.blockchaintrainer.in"));
        blockchain.addBlock(blockchain.newBlock("training@blockchaintrainer.in"));
        System.out.println("Blockchain valid ? " + blockchain.isBlockChainValid());
        System.out.println(blockchain);

    }
}
