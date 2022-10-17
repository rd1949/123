/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author josep
 */
public class JavaApplication1 {

    private static final String HMAC_SHA1 = "HmacSHA1";


/* -------------------------------------------------------------------------- */
/*                              // convert to hex                             */
/* -------------------------------------------------------------------------- */

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

/* -------------------------------------------------------------------------- */
/*                                   // hmac                                  */
/* -------------------------------------------------------------------------- */

    public static String calculateHMAC(String msg, String key)
        throws InvalidKeyException, SignatureException, NoSuchAlgorithmException 
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA1 );
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(secretKeySpec);
        return toHexString(mac.doFinal(msg.getBytes()));
    }

/* -------------------------------------------------------------------------- */
/*                                   // main                                  */
/* -------------------------------------------------------------------------- */

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a message: ");
        String msg = sc.nextLine();
        System.out.println("Enter a key: ");
        String key = sc.nextLine();

        String hmac = calculateHMAC(msg, key);
        System.out.println("Output hash :\n" +hmac);
}
    
}
