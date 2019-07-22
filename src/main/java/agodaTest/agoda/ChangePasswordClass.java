package agodaTest.agoda;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePasswordClass 
{
    
    
    public static boolean ChangePassword(String oldPassword , String newPassword) 
    {    	
    	if(oldPassword.length() == 0)
    	{
    		System.out.println("Old Password is blank");
    				return false;
    	}
    	if(newPassword.length() == 0)
    	{
    		System.out.println("New Password is blank");
    				return false;
    	}
    	if(IsValidPassword(newPassword) && MockSystemPassword(oldPassword) && MatchOldPassword(oldPassword , newPassword)) {
        	return true;
    	}
    	else
    		return false;
    }
    
    public static boolean IsValidPassword(String password) {
		if(IsPasswordLength(password) && VerifyPasswordValidity(password) && HasSpecialChar(password) )
			return true;
		else
		{
			System.out.println("Password not Valid");
			return false;
		}

    }
    
    public static boolean IsPasswordLength(String password) 
    {
    	if(password.length() >= 18)
        	return true;
    	else
		{
			System.out.println("Length Less than 18");
			return false;
		}
    }

    /**
     * Check for Upper Case
     * Check for Lower Case
     * Check for Numeric value
     * Check for 50% or more numeric password
     * Check for not more than 4 same characters
     * @param password
     * @return
     */
    public static boolean VerifyPasswordValidity(String password) 
    {
    	char ch;
    	int countUppercase =0;
    	int countLowercase =0;
    	int countNumericValue =0;
    	int countSameCharacter=0;
    	
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i =0; i< password.length(); i++)
    	{
    		ch = password.charAt(i);
    		if(map.containsKey(ch))
    		{
    			map.put(ch, map.get(ch)+1);
    		}
    		else
    			map.put(ch, 1);
    		if(Character.isUpperCase(ch))
    		{
    			countUppercase++;
    		}
    		if(Character.isLowerCase(ch))
    		{
    			countLowercase++;
    		}
    		if(Character.isDigit(ch))
    		{
    			countNumericValue++;
    		}

    	}
		for(Map.Entry<Character, Integer> m: map.entrySet())
		{
			if(m.getValue() >= 4)
			{
				System.out.println("Character " + m.getKey() + "has more than 4 occurence.");
				countSameCharacter++;
			}
			else
				countSameCharacter =0;
		}
    	if(countNumericValue == 0 || countLowercase ==0 ||  countUppercase ==0 || countSameCharacter>0)
    	{
    		System.out.println("Numeric, lowercase, Uppercase count is zero" + countNumericValue + " " + countLowercase + " "+ countUppercase);
    		System.out.println("Characters appears more than 4 times: " + countSameCharacter );

        	return false;
    	}
    	else {
    		if(countNumericValue< password.length()/2)
    			return true;
    		else
    		{
    			System.out.println("More than 50% numeric");
    			return false;
    		}
    	}
    }
    
   
    
    public static boolean HasSpecialChar(String password) 
    {
        Pattern special = Pattern.compile ("[!@#$&*]");
        Matcher hasSpecial = special.matcher(password);
        int count =0;
        while (hasSpecial.find()) {
        	count++;}
       if(count > 0 && count <=4)
    	   return true;
       else
		{
			System.out.println("Special character does not match or count is more than 4 or No special characer");
			return false;
		}
    }
    
    
    public static boolean MatchOldPassword(String oldPassword , String newPassword)
    {
    	String str_Old;
    	String str_New;
    	int beginIndexOld;
    	int beginIndexNew;
    	int endIndexOld;
    	int endIndexNew;
    	int countOld=1;
    	int countNew=1;
    	int matchPercent = 80;
    	
    	for(int i =0; i< oldPassword.length(); i++)
    	{
    		beginIndexOld =i;
    		
    		endIndexOld = i + countOld;
    		str_Old = oldPassword.substring(beginIndexOld, endIndexOld);    		
    		for(int j =0; j< newPassword.length();)
    		{
    			beginIndexNew =j;    
    			if(countNew + j < newPassword.length()-1 )
    				endIndexNew = j + countNew;
    			else
    				break;
        		str_New = newPassword.substring(beginIndexNew, endIndexNew);
        		if(str_Old.equals(str_New)) 
        		{
        			matchPercent = (countNew*100)/oldPassword.length();
        			if(matchPercent > 80)
        				break;

        			if(countOld + i < oldPassword.length()-1 ) {
            			countOld++;
            			endIndexOld = i + countOld;
                		str_Old = oldPassword.substring(beginIndexOld, endIndexOld);    	
        			}
        			else {
        				break;
        			}
        			if(countNew + j < newPassword.length()-1 )
            			countNew++;
        			else {
        				break;
        			}
        		}
        		else {
        			j++;
        		}
    		}
			countOld =1;
			countNew =1;
			if(matchPercent > 80) {
				break;
			}
    	}
		System.out.println("match Percent" + matchPercent + "%");
    	if(matchPercent > 80) {
    		System.out.println("matches more than 80%");
	    	return false;
		}
		else
			return true;
    }
    
    public static Boolean MockSystemPassword(String oldPassword) {
   		return true;
    }
}
