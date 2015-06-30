package com.alfadeprojects;

import java.math.BigInteger;

/**
 * Created by macbookpro on 19.11.14.
 */
public class Alice {
    public static BigInteger q;  // Закрытый ключ А
    public static BigInteger p;  // Открытый параметр
    private static BigInteger a; // Закрытый ключ - Х1
    private static BigInteger alice; // Открытый ключ У1
    private static BigInteger secret; // Общий секретный ключ Z

    public static BigInteger getSecret() {
        return secret;
    }

    public static void setSecret(BigInteger secret) {
        Alice.secret = secret;
        //System.out.println("Alice knows SECRET: " + Alice.secret);
    }

    public static BigInteger get_q() {
        return q;
    }

    public static void set_q(BigInteger q) {
        Alice.q = q;
        //System.out.println("Alice set q = " + Alice.q);
        //System.out.println("q = " + Alice.q + "\nlength of q(in bits) = " + Alice.q.bitLength());
    }

    public static BigInteger get_p() {
        return p;
    }

    public static void set_p(BigInteger p) {
        Alice.p = p;
        //System.out.println("Alice set p = " + Alice.p);
        //System.out.println("p = " + Alice.p + "\nlength of p(in bits) = " + Alice.p.bitLength());
    }

    public static BigInteger get_a() {
        return a;
    }

    public static void set_a(BigInteger a) {
        Alice.a = a;
        //System.out.println("Alice set a = " + Alice.a);
        //System.out.println("a = " + Alice.a + "\nlength of a(in bits) = " + Alice.a.bitLength());
    }

    public static BigInteger getAlice() {
        return alice;
    }

    public static void setAlice(BigInteger alice) {
        Alice.alice = alice;
        //System.out.println("Alice set A (alice) = " + Alice.alice);
    }

    public static BigInteger get_B_fromBob(){
        BigInteger bob = Bob.getBob();
        //System.out.println("Alice get B (bob) = " + bob);
        return bob;
    }

//    public static void work(){
//        p = Functions.primeNumberGen();
//        System.out.println("Alice: p = " + p);
//        set_p(p);
//        Functions.testRM(p);
//        //BigInteger q;
//        do{
//            q = Functions.primeNumberGen();
//        } while(q.compareTo(p) == -1);
//        set_q(q);
//        System.out.println("Alice: q = " + q);
//        //BigInteger a;
//        do{
//            set_a(Functions.primeNumberGen());
//        } while(get_a().compareTo(p) == -1);
//        System.out.println("(in Alice) a = " + a);
//        set_a(a);
//        BigInteger alice = Functions.powMod(q, a, p); // A = (g^a) mod p
//        System.out.println("(Alice) A = " + q + " ^ " + a + " mod " + p + " is " + alice);
//        setAlice(alice);
//
//        setSecret(Functions.powMod(get_B_fromBob(), get_a(), get_p()));
//
//    }
}
