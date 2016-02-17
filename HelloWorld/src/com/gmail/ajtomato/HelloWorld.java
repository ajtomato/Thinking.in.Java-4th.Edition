package com.gmail.ajtomato;

import java.math.*;
import java.util.*;

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
    
    int mId;

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
     * Autoboxing: convert a primitive value (an int, for example) into an
     *              object of the corresponding wrapper class (Integer).
     * Unboxing: Converting an object of a wrapper type (Integer) to its
     *              corresponding primitive (int) value.
     */
    private static void autoboxingUnboxing() {
        // Autoboxing
        List<Integer> lst = new ArrayList<Integer>();
        for (int i = 0; i < 10; ++ i) {
            lst.add(i);
        }
        
        // Unboxing
        int sum = 0;
        for (Integer i: lst) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
    
    /**
     * Demo how to use Random
     */
    private static void random() {
        Random rand = new Random();
        System.out.println("Random integer: " + rand.nextInt(100));
        // Between 0.0 and 1.0
        System.out.println("Random float: " + rand.nextFloat());
    }
    
    /**
     * == &amp; equals()
     */
    private static void equal() {
        HelloWorld h = new HelloWorld();
        h.mId = 0;
        HelloWorld w = h;
        HelloWorld w1 = new HelloWorld();
        w1.mId = 0;
        System.out.println("== means that two references points to one object: "
                + (h == w));
        System.out.println("equals() default behavior is the same as ==: "
                + h.equals(w) + " " + (!h.equals(w1)));
    }
    
    /**
     * HEX & Octal literal and string
     */
    private static void hexOctal() {
        long l1 = 0x99;
        long l2 = 077;
        Long l3 = Long.parseLong("1011", 2);
        System.out.println("HEX, OCTAL, BINARY: " + Long.toHexString(l1)
                + ", " + Long.toOctalString(l2) + ", " + Long.toBinaryString(l3));
    }
    
    /**
     * If you perform any mathematical or bitwise operations on primitive data
     * types that are smaller than an int (that is, char, byte, or short), those
     * values will be promoted to int before performing the operations, and the
     * resulting value will be of type int.
     */
    private static void autoPromote() {
        char c1 = 2;
        char c2 = 3;
        char c3 = 0;
        
        // char is automatically promoted to int
        c3 = (char)(c1 + c2);
        System.out.println("c1 + c2 is promoted to int, so the result has to be"
                + " casted back to char: " + c3);
    }
    
    /**
     * Foreach
     */
    private static void foreach() {
        int array[] = {5, 6, 7};
        for (int i: array) {
            System.out.println(i);
        }
    }
    
    /**
     * Label: the only reason to use labels in Java is when you have nested
     * loops and you want to break or continue through more than one nested level.
     */
    private static void label() {
        // label
        outer:
        for (int i = 0; i < 10; ++ i) {
            for(int j = 0; j < 10; ++ j) {
                System.out.println(i + ", " + j);
                if ((i == 2) && (j == i)) {
                    continue outer;
                }
                if (i == 7) {
                    break outer;
                }
            }
        }
    }

    /**
     * Main entry.
     * @param args  The arguments of main as the format of a string array.
     */
    public static void main(String[] args) {
        label();
    }

}
