package shuyi.product;

import shuyi.container.Container;
import shuyi.container.Cup;

import java.io.*;

public class ProductSerializer {
    public static boolean write(File file, Container cup) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(cup);

            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static Cup read(File file) {
        try{
           FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return (Cup) object;
        }catch (Exception e) {
            System.out.println("error at read");
        }
        return null;
    }
}
