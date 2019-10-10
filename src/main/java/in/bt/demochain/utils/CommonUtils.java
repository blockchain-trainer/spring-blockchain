package in.bt.demochain.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import in.bt.demochain.model.Block;
import in.bt.demochain.model.Transaction;


/**
 * Blockchain Trainer (www.blockchaintrainer.in)
 * 
 * This is Utils class that holds the hash logic
 * We can plugin any hash logic which works on the Block object parameter 
 */


public class CommonUtils {

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
                    builder.append('0');                }

                builder.append(hex);
            }

            return builder.toString();
        }

        return null;
    }

    public static List<Transaction> createTransactions(int count) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        for (int i = 0; i < count; i++) {
            transactions.add(createSingleTransactions());
        }
        return transactions;
    }

    private static Transaction createSingleTransactions() {
        Transaction t = new Transaction();
        t.setFrom("BlockChain trainer");
        t.setData("Radom data "+ Math.random());
        t.setTimeStamp(Calendar.getInstance().getTime());
        return t;
    }
    
    
}
