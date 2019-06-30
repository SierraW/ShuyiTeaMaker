package shuyi.data;

import java.io.*;

public class DataModule {
    public DataModule() {
        File file = new File("data/data_tracker.dat");

    }

    public static boolean write(File file, DataModule dataModule) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(dataModule);

            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static DataModule read(File file) {
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            return (DataModule) object;
        }catch (Exception e) {
            System.out.println("error at read");
        }
        return null;
    }
}
