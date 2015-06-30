package com.alfadeprojects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import com.alfadeprojects.Functions;

public class Main {

    // http://www.intuit.ru/studies/courses/691/547/lecture/12391?page=2
    // Хорошее подробное описание алгоритмв Диффи-Хеллмана
    private static String secretKey;
    public static void main(String[] args) {
	// write your code here
//        Random rnd = new SecureRandom();
//        Random rnd2 = new Random();
//        BigInteger p = new BigInteger(50, rnd2);
////        do{
////            p = new BigInteger(n.bitLength(), rnd);
////        } while (p.compareTo(n) >= 0);
//
//        //BigInteger p = new BigInteger(n, rnd);
//        System.out.print("p = " + p);

        //BigInteger p = Functions.primeNumberGen();
        //System.out.println("p = " + p + "\nlength of p(in bits) = " + p.bitLength());
        //Functions.testLehmann(p);
        //Functions.naturalNumberGen();
        //Functions.testRM(p);
        //Alice.work();
        //Bob.work();
        //Dialog.dialog();

        if (Dialog.dialog() == true){
            secretKey = Alice.getSecret().toString();
        }
        System.out.println("Секретный ключ в виде строки : " + secretKey);
        try{
            FileInputStream fis = new FileInputStream("Data/ОтчетРМСС.docx");
            FileOutputStream fos = new FileOutputStream("Data/encryptedRMSS.docx");
            DesEncrypter.encrypt(secretKey, fis, fos);

            FileInputStream fis2 = new FileInputStream("Data/encryptedRMSS.docx");
            FileOutputStream fos2 = new FileOutputStream("Data/decrypted.docx");
            DesEncrypter.decrypt(secretKey, fis2, fos2);
        } catch(Throwable e){
            e.printStackTrace();
        }



    }
}
