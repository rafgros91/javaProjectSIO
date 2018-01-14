package fr.centralesupelec.sio.hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

/**
 * A simple method to write the hashed password and the salt to distinct files.
 */

//Unfortunately I couldn't make the hashing work
public class StorePassword {

    public static void main(String[] args) {

        byte b1 = 100;
        byte b2 = 101;
        byte b3 = 111;
        byte[] salt = {b1, b2, b3};
        File saltFile = new File("salt");
        byte[] hashedPassword = Hash.hashPassword("password".toCharArray(), salt, 15, 256);
        File hashPassFile = new File("hashedPassword");

        try {

            OutputStream os1 = new FileOutputStream(hashPassFile);
            os1.write(hashedPassword);
            System.out.println("Write hashed password to file.");
            os1.close();

            OutputStream os2 = new FileOutputStream(saltFile);
            os2.write(hashedPassword);
            System.out.println("Write salt to file");
            os2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
