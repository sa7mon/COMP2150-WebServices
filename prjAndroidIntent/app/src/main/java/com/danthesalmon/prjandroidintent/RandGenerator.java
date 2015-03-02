package com.danthesalmon.prjandroidintent;

import java.util.Random;

/**
 * Created by Dan on 3/1/2015.
 *
 *  RandGenerator - Contains all the functions for creating random strings
 */
public class RandGenerator {

    static Random rndGen = new Random();
    /**
     *  generateRandStr() - The function that does the generating.
     *  @param length - How many characters long we want the string to be.
     *  @param charList - The allowed charactes to generate the string from.
     * @return randStr - The random string at the specified length.
     *
     */
    public String generateRandStr(int length,String charList) {

        // Create a new StringBuffer with capacity @param:length
        StringBuffer sbRandString = new StringBuffer(length);

        // Until the StringBuffer is filled to capacity, do the following
        for (int i=0; i<length; i++) {

        }

    }
}
