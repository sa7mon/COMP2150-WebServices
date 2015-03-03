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

    // ============ CONSTRUCTOR METHODS ============

    /**
     *
     */
    public RandStr () {


    }




    /**
     *  generateRandStr() - The function that does the generating.
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
