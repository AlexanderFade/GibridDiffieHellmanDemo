package com.alfadeprojects;

import java.math.BigInteger;
import java.text.Bidi;
import java.util.Random;

/**
 * Created by macbookpro on 19.11.14.
 */
public class Functions {
    static Random rnd = new Random();
    public static int eilerFunction(int n){
            int result = n;
            for (int i = 2; i * i <= n; ++i)
                if (n % i == 0) {
                    while (n % i == 0)
                        n /= i;
                    result -= result / i;
                }
            if (n > 1)
                result -= result / n;
            return result;
    }
    public static int p_LengthGen(){
        int n;
        do {
            n = rnd.nextInt(1000);
        } while(n < 50);
        return n;
    }

    // Генерируем простое 50-тибитовое большое число
    public static BigInteger primeNumberGen(){
        BigInteger p;
        do{
            p = new BigInteger(p_LengthGen(), 1, rnd);
        }while(p.bitLength() < 50);
        //System.out.println("p = " + p + "\ np.bitLength = " + p.bitLength());
        return p;
    }
    public static int naturalNumberGen(){
        Random rnd = new Random();
        int x = rnd.nextInt(50);
        System.out.println("x = " + x);
        return x;
    }
    public static BigInteger powMod(BigInteger q, BigInteger a, BigInteger p){
        BigInteger pm = q.modPow(a, p);
        return pm;
    }
    // Тест Рабина-Миллера используется в методе isProbablePrime языка Java
    public static void testRM(BigInteger p) {
        int certainty = 948272723;
        System.out.println(p.toString() + " is " + (p.isProbablePrime(certainty) ? "probably prime" : "composite"));
    }
//    public static void testLehmann(BigInteger p){
//        BigInteger a;
//        int t = 0;
//        for(int i = 0; i < 5; i++){
//            do{
//                a = new BigInteger(p_LengthGen(), rnd);
//            } while (a.compareTo(p) == -1);
//
//            BigInteger res = a.modPow((p.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)), p);
//            System.out.println("a^((p-1)/2) = " + res);
//            System.out.println("a^((p-1)/2) mod(p) = " + res);
//            if (res.intValue() == 1 | res.intValue() == -1){
//                System.out.println("Вероятность того, что число р является простым, более 50 процентов");
//                t++;
//            } else{
//                System.out.print("p - не является простым числом.");
//            }
//        }
//        System.out.println("p - простое с вероятностью: " + 1/(2^t));
//    }
}
