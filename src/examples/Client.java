package examples;

import com.gcapi.Gcapi;

public class Client {

	public static void main(String[] argv) {
		String key = "GBP";
		Gcapi result = new Gcapi(key);
		String value = result.getValue();
		
		System.out.println("### Result of Gcapi ###");
		System.out.println("Primary Currency  : USD => 1.00");
		System.out.println("Compared Currency : " + key + " => " + value);
	}
}
