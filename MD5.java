package md5;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class MD5 {
    
    public static String getMD5(String msg)  {

        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md_obj = MessageDigest.getInstance("MD5");
            
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] md_byteArray = md_obj.digest(msg.getBytes());
            
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, md_byteArray);
            
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
            }
            return hashtext;
            }
            
            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

            }
         
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the message : ");
        
        String msg = sc.nextLine();

        System.out.println("Generated MD5 hash : " + getMD5(msg));
               
    }
}
