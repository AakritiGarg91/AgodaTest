package agodaTest.agoda;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePasswordTest 
{

       
        @Test(dataProvider="Testdata")
        public void TestChangePassword(String oldPassword,String newPassword,Boolean expectedResult)
        {
//        	String oldPassword = "AAkritiGarg123878767687877";
//            String newPassword = "AAkritiGarg13457877";
        	Assert.assertEquals(expectedResult.booleanValue(), ChangePasswordClass.ChangePassword(oldPassword, newPassword));
        }
        
        
        @DataProvider(name="Testdata")
        public Object[][] testData()
        {
        	return new Object[][] 
        	{
        		
        		{ "", "",Boolean.FALSE},  										//Both Empty
        		{ "", "Agoda@123456AgodaA",Boolean.FALSE},						//OldPassword is empty
        		{ "Agoda@123456AgodaA", "",Boolean.FALSE},						//NewPassword is empty
        		{ "Agoda@123456AgodaA", "Agoda@123456AgodaA",Boolean.FALSE},	//both Passwords are same
        		{ "Agoda@123456AgodaA", "Agoda@123456Agoda",Boolean.FALSE},		//Length is less than 18 chars
        		{ "Agoda@123456AgodaA", "abcdefgt165678@#j8",Boolean.FALSE},	//No Upper Case in NwePassword					
        		{ "Agoda@123456AgodaA", "ABCDEFGHIJ1234@7KL",Boolean.FALSE},	//No Lower Case Char in New Password
        		{ "Agoda@123456AgodaA", "ASDFGHJKLPOIUYTRe@",Boolean.FALSE},	//No Numeric value
        		{ "Agoda@123456AgodaA", "1234567890asdfgh@34",Boolean.FALSE},	//More than 50 % numeric values present
        		{ "Agoda@123456AgodaA", "asdfghjklzxcvbnmqwertyuiopASDFGHJKLZXCVBNMQWERTYUIOP1234567890@#$12345678901234567890asdfghjklzxcvbnmqwertyuiop./[]",Boolean.TRUE},	//More than 100 character in NewPassword
        		{ "Agoda@123456AgodaA", "   A12hjphffhg90asdfgh@34",Boolean.TRUE},	//Leading spaces in newPassword
        		{ "Agoda@123456AgodaA", "12Ajhjkhkbnbjnasdfgh@34   ",Boolean.TRUE},	//Trailing spaces in newPassword
        		{ "Agoda@123456AgodaA", "  Ahgyghyhkjl890asdfgh@34 ",Boolean.TRUE},	//Leading and Trailing spaces and in between spaces in newPassword
        		{ "Agoda@123456AgodaA", "Aghftfsdvxjhj n 987 b4#@",Boolean.TRUE},	//In between space in newPassword
        		{ "Agoda@123456AgodaA", "asdfghjkluqytwrvbjjhhjhj",Boolean.FALSE},	//Only alphabets
        		{ "Agoda@123456AgodaA", "012345678901234567890123456789",Boolean.FALSE},	//Only numbers
        		{ "Agoda@123456AgodaA", "!@#$&*!@#$&*!@#$&*!@#$&*!@#$&*!@#$&*",Boolean.FALSE},	//Only valid special Characters
        		{ "Agoda@123456AgodaA", "!@#$&*ghjjjggA576775656ghhjjjgt",Boolean.FALSE},	//More than 4 special characters
        		{ "Agoda@123456Agodfg", "Agoda@123456Agosdfjhg",Boolean.FALSE},	//More than 80% password is same
        		{ "Agoda@123456AgodaA", "AakritiGargTest12#@*",Boolean.TRUE},	//Both password different and valid
        		{ "Agoda@123456AgodaA", "AakritiGargTeeeest12#@*",Boolean.TRUE},	//Contains more than 4 characters of same type

        		        	
        	
        	
        	};       			
        }
        
}
