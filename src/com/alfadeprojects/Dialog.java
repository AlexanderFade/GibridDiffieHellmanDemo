package com.alfadeprojects;

import java.math.BigInteger;

/**
 * Created by macbookpro on 23.11.14.
 */
public class Dialog {

    public static boolean dialog(){
        Alice.set_p(Functions.primeNumberGen());
        System.out.println("Alice P = "+Alice.get_p() + "\nP.bitlength() = " + Alice.get_p().bitLength());
        Functions.testRM(Alice.get_p());
        // Генерируем число q такое, что q < p
//        do{
//            Alice.set_q(Functions.primeNumberGen());
//        } while (Alice.get_q().compareTo(Alice.get_p()) == 1 || Alice.get_q().compareTo(Alice.get_p()) == 0);
//
//        do{
//            Alice.set_a(Functions.primeNumberGen());
//        } while(Alice.get_a().compareTo(Alice.get_p()) == 1 || Alice.get_a().compareTo(Alice.get_p()) == 0);

        do{
            Alice.set_q(Functions.primeNumberGen());
        } while(Alice.get_q().bitLength() >= Alice.get_p().subtract(BigInteger.ONE).bitLength());
        System.out.println("Alice Q = " + Alice.get_q() + "\n Q.bitlength() = "  + Alice.get_q().bitLength());
        do{
            Alice.set_a(Functions.primeNumberGen());
        } while(Alice.get_a().bitLength() >= Alice.get_p().bitLength());
        System.out.println("Alice A = " + Alice.get_a() + "\n A.bitlength() = "  + Alice.get_a().bitLength());

        Alice.setAlice(Functions.powMod(Alice.get_q(), Alice.get_a(), Alice.get_p())); // A = (g^a) mod p
        System.out.println("Alice ALICE = " + Alice.getAlice() + "\nALICE.bitlength() = " + Alice.getAlice().bitLength());
        Bob.get_p_fromAlice();
        System.out.println("(gfa)Bob P = " + Bob.get_p());
        Bob.get_q_fromAlice();
        System.out.println("(gfa)Bob Q = " + Bob.get_q());
        Bob.get_A_fromAlice();
        System.out.println("(gfa)Bob ALICE = " + Bob.get_A_fromAlice());

//        do{
//            Bob.set_b(Functions.primeNumberGen());
//        } while(Bob.get_b().compareTo(Bob.get_p()) == 1 || Bob.get_b().compareTo(Bob.get_p()) == 0);
        do{
            Bob.set_b(Functions.primeNumberGen());
        } while(Bob.get_b().bitLength() >= Bob.get_p().subtract(BigInteger.ONE).bitLength());
        System.out.println("Bob B = " + Bob.get_b() + "\nB.bitlength() = "+Bob.get_b().bitLength());

        Bob.setBob(Functions.powMod(Bob.get_q(), Bob.get_b(), Bob.get_p())); // B = (g^b) mod p
        System.out.println("Bob BOB = " + Bob.getBob() + "\nBOB.bitlength() = "+Bob.getBob().bitLength());

        Alice.setSecret(Functions.powMod(Alice.get_B_fromBob(), Alice.get_a(), Alice.get_p()));
        System.out.println("Alice SECRETKEY = " + Alice.getSecret() + "\nSECRETKEY.bitlength() = " + Alice.getSecret().bitLength());
        Bob.setSecret(Functions.powMod(Bob.get_A_fromAlice(), Bob.get_b(), Bob.get_p()));
        System.out.println("Bob SECRETKEY = " + Bob.getSecret() + "\nSECRETKEY.bitlength() = " + Bob.getSecret().bitLength());
        return isEqual(Alice.getSecret(), Bob.getSecret());
    }

    public static boolean isEqual(BigInteger alice, BigInteger bob){
        if (Alice.getSecret().toString().equals(Bob.getSecret().toString())){
            System.out.println("Алиса и Боб имеют одинаковые ключи.\nTRUE!!!");
            return true;
        } else{
            System.out.println("Алиса и Боб имеют разные ключи.\nFALSE!!!");
            return false;
        }
    }
}
