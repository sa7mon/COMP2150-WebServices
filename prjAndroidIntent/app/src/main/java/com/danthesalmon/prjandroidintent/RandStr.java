package com.danthesalmon.prjandroidintent;

import java.util.Random;
/**
 *
 * @author Dan Salmon (https://danthesalmon.com)
 * Project: Android Intent (https://github.com/sa7mon/COMP2150-WebServices/tree/master/prjAndroidIntent)
 * Created On: 3/3/15
 *
 *  RandStr - A random string class. Contains 2 overloaded constructors
 *
 */
public class RandStr {

    // ============== VARIABLES ================
    final int DEFAULT_LENGTH = 10; // The length of the string to default to

    // ============ CONSTRUCTOR METHODS ============

    /**
     * RandStr() - The first constructor methods. Accepts 1 argument and assumes everything else.
     *
     * @param - A String containing the characters to use for the random string.
     * @return - A String of DEFAULT_LENGTH length of random characters.
     */
    public String RandStr (String charList) {
        String randomString = generateRandStr(DEFAULT_LENGTH,charList);

        return randomString;
    }




    /**
     *  generateRandStr() - The function that does the actual generate of the random string.
     *  @author - Dan Salmon (https://danthesalmon.com)
     *  @param length - How many characters long we want the string to be.
     *  @param charList - The allowed charactes to generate the string from.
     * @return randStr - The random string at the specified length.
     *
     */
    private String generateRandStr(int length,String charList) {

        // Instantiate a new Random object. It will give us random ints with a specified ceiling.
        Random rndGen = new Random();

        // Create a new StringBuffer with capacity @param:length
        StringBuffer sbRandString = new StringBuffer(length);

        // Until the StringBuffer is filled to capacity, do the following
        for (int i=0; i<length; i++) {
            // Get the character from charList at location specified by a random number
            char randChar = charList.charAt(rndGen.nextInt(charList.length()));
            // Add this random char to the StringBuffer
            sbRandString.append(randChar);
        }
        // Return the randomly generated string.
        return sbRandString.toString();
    } // End generateRandStr
} // End class RandStr
