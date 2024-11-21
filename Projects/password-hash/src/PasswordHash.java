import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHash {
	public static String hashPassword(String password) throws NoSuchAlgorithmException{
		SecureRandom random = new SecureRandom();
		//16 bit salt
		byte[] salt = new byte[16];
		
		//Generates unique salt each type
		random.nextBytes(salt);
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(salt);
		byte[] hashedPassword = messageDigest.digest(password.getBytes());
		
		return Base64.getEncoder().encodeToString(salt)+"$"+Base64.getEncoder().encodeToString(hashedPassword);
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = "admin";
		System.out.println(PasswordHash.hashPassword(password));
	}
}
