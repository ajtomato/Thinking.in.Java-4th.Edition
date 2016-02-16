package com.gmail.ajtomato;

import java.math.*;

/**
 * The main entry of the whole project.
 */
public class HelloWorld {
    
    private static byte mB;
    private static short mS;
    private static int mI;
    private static long mL;
    private static float mF;
    private static double mD;
    private static boolean mBool;
    private static char mC;

    /**
     * The scope and the default value of primitive types.
     */
    private static void primitiveTypes() {
        System.out.println("There is no unsigned type");
        System.out.println("byte: " + Byte.MIN_VALUE + " - "+ Byte.MAX_VALUE
                + ", [Default]: " + mB);
        System.out.println("short: " + Short.MIN_VALUE + " - "+ Short.MAX_VALUE
                + ", [Default]: " + mS);
        System.out.println("int: " + Integer.MIN_VALUE + " - "+ Integer.MAX_VALUE
                + ", [Default]: " + mI);
        System.out.println("long: " + Long.MIN_VALUE + " - "+ Long.MAX_VALUE
                + ", [Default]: " + mL);
        System.out.println("float: " + Float.MIN_VALUE + " - "+ Float.MAX_VALUE
                + ", [Default]: " + mF);
        System.out.println("double: " + Double.MIN_VALUE + " - "+ Double.MAX_VALUE
                + ", [Default]: " + mD);
        System.out.println("boolean: " + Boolean.FALSE + " & "+ Boolean.TRUE
                + ", [Default]: " + mBool);
        System.out.println("char: " + (int)Character.MIN_VALUE + " - "
                + (int)Character.MAX_VALUE + ", [Default]: " + (int)mC);
    }
    
    /**
     * BigInteger &amp; BigDecimal
     */
    private static void arbitraryPrecision() {
        BigInteger bi = new BigInteger("-1111111111111");
        System.out.println("BigInteger: " + bi.abs());
        BigDecimal bd = new BigDecimal("1.12");
        System.out.println("BigDecimal: " + bd.add(new BigDecimal("2.22")));
    }

    /**
     * Main entry.
     * @param args  The arguments of main as the format of a string array.
     */
    public static void main(String[] args) {
        arbitraryPrecision();
    }

}
