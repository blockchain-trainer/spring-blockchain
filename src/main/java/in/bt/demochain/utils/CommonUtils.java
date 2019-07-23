package in.bt.demochain.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import in.bt.demochain.model.Block;


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
    
    
}
