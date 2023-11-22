package com.ecommarce.api.utility;

import java.util.UUID;

import org.springframework.stereotype.Component;

//Java program generate a random AlphaNumeric String
//using Math.random() method
@Component
public class RandomStringValue {

//function to generate a random string of length n
public static String getAlphaNumericString()
{

//choose a Character random from this String
String AlphaNumericString = "VEDAKSHI01234";

//create StringBuffer size of AlphaNumericString
StringBuilder sb = new StringBuilder(6);

for (int i = 0; i < 6; i++) {

//generate a random number between
//0 to AlphaNumericString variable length
int index
	= (int)(AlphaNumericString.length()
	* Math.random());

//add Character one by one in end of sb
sb.append(AlphaNumericString
	.charAt(index));
}

return sb.toString();
}


public static String getRandomNumber()
{

//choose a Character random from this String
String RendomNumbers = "0123456789";

//create StringBuffer size of AlphaNumericString
StringBuilder sb = new StringBuilder(6);

for (int i = 0; i < 6; i++) {

//generate a random number between
//0 to AlphaNumericString variable length
int index
	= (int)(RendomNumbers.length()
	* Math.random());

//add Character one by one in end of sb
sb.append(RendomNumbers
	.charAt(index));
}
System.out.println("Random Number Is : "+sb);
return sb.toString();
}


public   String generateToken() {
	StringBuilder token = new StringBuilder();

	return token.append(UUID.randomUUID().toString())
			.append(UUID.randomUUID().toString()).toString();
}

public static void main(String[] args)
{

//Get the size n
int n = 20;

//Get and display the alphanumeric string
System.out.println(RandomStringValue
	.getRandomNumber());

}
}
