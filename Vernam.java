/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vernam;

import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Vernam {

    /**
     * @param args the command line arguments
     */
    static String alphs = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message : ");
        String message = sc.nextLine();

        System.out.print("Enter the key : ");
        String key = sc.nextLine();

        if(message.length() != key.length()) {
            System.out.println("Length of key and message doesn't match");
            return;
        }

        String encryptedMsg = encrypt(message, key);
        System.out.println("Encrypted message is : " + encryptedMsg);

        String decryptedMsg = decrypt(encryptedMsg, key);
        System.out.println("Decrypted message is : " + decryptedMsg);
    }

    private static String encrypt(String message, String key) {
        
        String result = "";
        
        for(int i = 0; i<message.length(); i++) {

            char curCharMsg = message.charAt(i);
            char curCharKey = key.charAt(i);

            int curCharMsgVal = alphs.indexOf(curCharMsg);
            int curCharKeyVal = alphs.indexOf(curCharKey);
            
            int sum = curCharMsgVal + curCharKeyVal;

            if(sum >= 26)
                sum -= 26;

            result += alphs.charAt(sum);
            
        }

        return result;
    }

    private static String decrypt(String message, String key) {
        
        String result = "";
        
        for(int i = 0; i<message.length(); i++) {

            char curCharMsg = message.charAt(i);
            int curCharMsgVal = alphs.indexOf(curCharMsg);

            char curCharKey = key.charAt(i);
            int curCharKeyVal = alphs.indexOf(curCharKey);
            
            int sub = curCharMsgVal - curCharKeyVal;

            if(sub < 0)
                sub += 26;

            result += alphs.charAt(sub);
            
        }

        return result;
    }
    
}
