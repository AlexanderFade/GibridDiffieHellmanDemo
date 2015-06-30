package com.alfadeprojects;

import java.math.BigInteger;

/**
 * Created by macbookpro on 19.11.14.
 */
public class Bob {
    private static BigInteger b; // Закрытый ключ Х2
    private static BigInteger bob; //Открытый ключ У2
    public static BigInteger p; // Открытый параметр
    public static BigInteger q; // Открытый параметр
    private static BigInteger secret; // Общий секретный ключ Z

    public static BigInteger getSecret() {
        return secret;
    }

    public static void setSecret(BigInteger secret) {
        Bob.secret = secret;
        //System.out.println("Bob knows SECRET: " + Bob.secret);
    }

    public static BigInteger get_b() {
        return b;
    }

    public static void set_b(BigInteger b) {
        Bob.b = b;
        //System.out.println("Bob set b = " + Bob.b);
    }

    public static BigInteger get_p() {
        return p;
    }

    public static void set_p(BigInteger p) {
        Bob.p = p;
        //System.out.println("Bob set p = " + Bob.p);
    }

    public static BigInteger get_q() {
        return q;
    }

    public static void set_q(BigInteger q) {
        Bob.q = q;
        //System.out.println("Bob set q = " + Bob.q);
    }

    public static BigInteger getBob() {
        return bob;
    }

    public static void setBob(BigInteger bob) {
        Bob.bob = bob;
        //System.out.println("Bob set B (bob) = " + Bob.bob);
    }

    public static BigInteger get_A_fromAlice(){
        BigInteger alice = Alice.getAlice();
        //System.out.println("Bob get A (alice) = " + alice);
        return alice;
    }

    public static BigInteger get_q_fromAlice(){
        BigInteger q = Alice.get_q();
        //System.out.println("Bob get q (alice) = " + q);
        set_q(q);
        return q;
    }
    public static BigInteger get_p_fromAlice(){
        BigInteger p = Alice.get_p();
        //System.out.println("Bob get p (alice) = " + p);
        set_p(p);
        return p;
    }



//    public static void work(){
//        get_p_fromAlice();
//        get_q_fromAlice();
//        do{
//            b = Functions.primeNumberGen();
//        } while(b.compareTo(get_p()) == -1);
//        set_b(b);
//        setBob(Functions.powMod(get_q(), get_b(), get_p())); // B = (g^b) mod p
//        System.out.println("(Bob) B = " + get_q() + " ^ " + get_b() + " mod " + get_p() + " is " + getBob());
//
//        setSecret(Functions.powMod(get_A_fromAlice(), get_b(), get_p()));
//
//
//
//    }


}
