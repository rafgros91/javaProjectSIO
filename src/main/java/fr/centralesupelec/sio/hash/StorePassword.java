package fr.centralesupelec.sio.hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;

public class StorePassword {

    public static void main(String[] args) {

        byte b1 = 100;
        byte b2 = 101;
        byte b3 = 111;
        byte[] salt = {b1, b2, b3};
        byte[] bytes = Hash.hashPassword("password".toCharArray(), salt, 15, 256);
        File file = new File("./hashedPassword.txt");

        try {

            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            System.out.println("Write bytes to file.");

            //printContent(file);
            //os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printContent(File file) throws Exception {
        //System.out.println("Print File Content");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

}
