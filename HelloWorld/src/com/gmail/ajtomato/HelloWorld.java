package com.gmail.ajtomato;

import java.math.*;
import java.util.*;

/**
 * Constructor &amp; initialization
 * 1. static definition
 * 2. static initializer block
 * 3. field definition
 * 4. initializer block
 * 5. constructor
 */
class Constructor {
    
    Constructor() {
        System.out.println("Default constructor");
        mConstantStr = "Hello world";
    }
    
    Constructor(int field) {
        // This must be the first thing.
        this();
        
        System.out.println("Constructor: " + mField1 + ", " + mField2 + ", " + mField3);
        mField3 = field;
    }
    
    
    @SuppressWarnings("unused")
    private final String mConstantStr;
    
    private int mField1 = 3;
    private int mField2 = initialize(mField1);
    private int mField3;
    
    // Initializer block
    {
        System.out.println("Initializer block: " + mField1 + ", " + mField2 + ", " + mField3);
    }
    
    private int initialize(int field) {
        System.out.println("field definition");
        return (field - 1);
    }
    
    private static int sField1 = initializeStatic();
    
    private static int initializeStatic() {
        System.out.println("Static field definition");
        return 5;
    }
    
    // Static initializer block
    static {
        System.out.println("Static initializer block: " + sField1);
    }
}

/**
 * Enumerated type
 */
enum EnumType {
    CONST_1,
    CONST_2
}

/**
 * Base class
 */
class Base {
    
    private int mField = init();
    
    private int init() {
        System.out.println(mField);
        return 1;
    }
    
    {
        System.out.println(mField);
        mField = 2;
    }
    
    Base(int field) {
        System.out.println(mField);
        mField = 3;
    }
    
    void method1() {
        System.out.println("Base.method1");
    }
    
    private void method2() {
        System.out.println("Base.method2");
    }
    
    void method3() {
        method1();
        method2();
    }
    
    Base method4() {
        return this;
    }
    
    void dispose() {
        System.out.println("Base.dispose()");
    }
    
    protected void protectedMethod() {
        System.out.println("Base.protectedMethod");
    }
    
    static void staticMethod() {
        System.out.println("Base.staticMethod");
    }
}

/**
 * Derived class
 */
class Derived extends Base {
    
    private int mField1 = init();
    
    private int init() {
        System.out.println(mField1);
        return 10;
    }
    
    {
        System.out.println(mField1);
        mField1 = 11;
    }
    
    Derived(int field) {
        super(field);
        System.out.println(mField1);
        mField1 = 12;
    }
    
    @Override
    void method1() {
        System.out.println("Derived.method1");
    }
    
    void method2() {
        System.out.println("Derived.method2");
    }
    
    @Override
    Derived method4() {
        return this;
    }
    
    @Override
    void dispose() {
        System.out.println("Derived.dispose()");
        super.dispose();
    }
    
    static void staticMethod() {
        System.out.println("Derived.staticMethod");
    }
}

/**
 * Abstract class
 */
abstract class AbstractClass {
    
    AbstractClass() {
        System.out.println("AbstractClass.AbstractClass");
    }
    
    void method1() {
        System.out.println("AbstractClass.method1");
    }
    
    abstract void method2();
}

/**
 * Interface
 */
interface Interface {
    
    // static & final
    int VALUE_C = 5;
    
    void method3();
}

interface Interface1 {
    void method4();
}

interface Interface2 {
    void method5();
}

interface Interface3 extends Interface1, Interface2 {
    void method6();
}

/**
 * Concrete class
 */
class ConcreteClass extends AbstractClass
        implements Interface {
    
    @Override
    void method2() {
        System.out.println("ConcreteClass.method2");
    }
    
    /**
     * The method in an interface is public.
     */
    @Override
    public void method3() {
        System.out.println("ConcreteClass.method3");
    }
}

/**
 * OuterClass & InnerClass
 */
class OuterClass {
    
    class InnerClass {
        
        OuterClass getOuter() {
            System.out.println(mOuterField);
            return OuterClass.this;
        }
        
    }
    
    Interface getInterface() {
        return new Interface() {
            @Override
            public void method3() {
                System.out.println("Anonymous Class in OuterClass for Interface");
            }
        };
    }
    
    Base getBase(int field, String s) {
        return new Base(field) {
            {
                System.out.println("Anonymous class instance initializer: " + s);
            }
            
            @Override
            void method1() {
                System.out.println("Anonymous class in OuterClass for Base: "
                        + s);
            }
        };
    }
    
    private int mOuterField = 3;
}

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
    
    int     mId;
    boolean mRelease = false;
    
    /**
     * finalize() can be used to detect some resources are released as expected.
     */
    @Override
    public void finalize() {
        if (!mRelease) {
            System.out.println("mRelease should be set before the object is"
                    + " destructor.");
        }
    }

    /**
     * The scope and the default value of primitive types.
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    private static void random() {
        Random rand = new Random();
        System.out.println("Random integer: " + rand.nextInt(100));
        // Between 0.0 and 1.0
        System.out.println("Random float: " + rand.nextFloat());
    }
    
    /**
     * == &amp; equals()
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    private static void foreach() {
        int[] array = {5, 6, 7}, array1 = new int[] {1, 2, 3};
        for (int i: array) {
            System.out.println(i);
        }
        for (int i = 0; i < array1.length; ++i) {
            System.out.println(array1[i]);
        }
        System.out.println(Arrays.toString(array1));
    }
    
    /**
     * Label: the only reason to use labels in Java is when you have nested
     * loops and you want to break or continue through more than one nested level.
     */
    @SuppressWarnings("unused")
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
     * Right shift
     */
    @SuppressWarnings("unused")
    private static void rightShift() {
        int i = -1;
        System.out.println(i >> 3);
        System.out.println(i >>> 3);
    }
    
    /**
     * Fibonacci
     */
    @SuppressWarnings("unused")
    private static void fibonacci(int n) {
        if (n < 3) {
            for (int i = 0; i < n; ++ i) {
                System.out.println(1);
            }
            return;
        }
        
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.println("1\n1");
        for (n -= 2; n > 0; -- n) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(c);
        }
    }
    
    /**
     * Vampire number
     */
    @SuppressWarnings("unused")
    private static void vampireNumber() {
        for (int i = 10; i < 100; ++ i) {
            for (int j = 10; j < 100; ++ j) {
                int m = i * j;
                if ((m >= 1000) && (m < 10000)) {
                    ArrayList<Integer> a1 = new ArrayList<Integer>(4);
                    a1.add(i / 10);
                    a1.add(i % 10);
                    a1.add(j / 10);
                    a1.add(j % 10);
                    a1.sort(null);
                    ArrayList<Integer> a2 = new ArrayList<Integer>(4);
                    for (; m > 0 ; m /= 10) {
                        a2.add(m % 10);
                    }
                    a2.sort(null);
                    if (a1.equals(a2)) {
                        System.out.println(i + " * " + j + " = " + (i * j));
                    }
                }
            }
        }
    }
    
    /**
     * test finalize()
     */
    @SuppressWarnings("unused")
    private static void testFinalize() {
        HelloWorld h = new HelloWorld();
        h = null;
        System.gc();
    }
    
    /**
     * Constructor & initialization
     */
    @SuppressWarnings("unused")
    private static void constructorInitialization() {
        Constructor c = new Constructor(10);
        c = null;
    }
    
    /**
     * Variable argument list
     */
    private static void variableArgumentLst(String... strings) {
        for (String s: strings) {
            System.out.println(s);
        }
    }
    
    @SuppressWarnings("unused")
    private static void testVariableArgumentLst(String... strings) {
        variableArgumentLst();
        variableArgumentLst("Hello", "world");
        variableArgumentLst(new String[] {"Come", "on"});
    }
    
    /**
     * Enumerated type
     */
    @SuppressWarnings("unused")
    private static void enumeratedType() {
        EnumType e1 = EnumType.CONST_2;
        System.out.println("Enum: " + e1 + ", " + e1.ordinal() + ", "
                + Arrays.toString(EnumType.values()));
    }
    
    /**
     * Initialize order of base class and derived class
     */
    @SuppressWarnings("unused")
    private static void initializeOrder() {
        Derived d = new Derived(20);
    }
    
    /**
     * Dispose order of base class and derived class
     */
    @SuppressWarnings("unused")
    private static void disposeOrder() {
        Derived d = new Derived(20);
        d.dispose();
    }
    
    /**
     * Protected also provides package access.
     */
    @SuppressWarnings("unused")
    private static void protectedAccess() {
        Base b = new Base(3);
        b.protectedMethod();
    }
    
    @SuppressWarnings("unused")
    private static final int CONSTANT_ONE = 1;
    
    /**
     * dynamic bind
     */
    @SuppressWarnings("unused")
    private static void dynamicBind() {
        Derived d = new Derived(3);
        d.method3();
    }
    
    /**
     * static method does not dynamic bind
     */
    @SuppressWarnings({ "unused", "static-access" })
    private static void staticMethodNotDynamic() {
        Derived d = new Derived(3);
        Base b = d;
        d.staticMethod();
        b.staticMethod();
    }
    
    /**
     * Covariant return type
     */
    @SuppressWarnings("unused")
    private static void covariantReturnType() {
        Derived d = new Derived(3);
        d.method4();
    }
    
    /**
     * Abstract class
     */
    @SuppressWarnings("unused")
    private static void abstractClass() {
        AbstractClass a = new ConcreteClass();
        a.method2();
    }
    
    /**
     * Interface
     */
    @SuppressWarnings("unused")
    private static void implmentInterface() {
        Interface i = new ConcreteClass();
        i.method3();
    }
    
    /**
     * Create outer class and inner class.
     */
    @SuppressWarnings("unused")
    private static void createOuterClassInnerClass() {
        OuterClass o = new OuterClass();
        OuterClass.InnerClass i = o.new InnerClass();
        o = i.getOuter();
        System.out.println("Done");
    }
    
    /**
     * Anonymous class
     */
    private static void anonymousClass() {
        OuterClass o = new OuterClass();
        Interface i = o.getInterface();
        i.method3();
        Base b = o.getBase(5, "Hello");
        b.method1();
    }

    /**
     * Main entry.
     * @param args  The arguments of main as the format of a string array.
     */
    public static void main(String[] args) {
        anonymousClass();
    }

}
