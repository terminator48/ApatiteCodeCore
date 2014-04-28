/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apatitecodecore.keyValueStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniil
 */
public class keyValueStorage {

    public static Map database = null;
    private static String filename;

    private void createNewDatabase() {
        database =  new HashMap< String, Object>();
    }

    public keyValueStorage(String filename2) {
        filename = filename2;
        File fl = new File(filename);
        if (fl.exists()) {
            try {
                FileInputStream fout = null;
                fout = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fout);
                database = (Map) ois.readObject();
                ois.close();
            } catch (Exception ex) {
                System.out.println("Error loading database");
                System.out.println("Backuping old and creating new database...");
                fl.renameTo(new File(filename+".bak"));
                createNewDatabase();
            }
        } else {
            System.out.println("Database not found. Creting new database");
            createNewDatabase();
        }
    }

    public void save() {
        try {
            File fl = new File(filename);
            fl.getParentFile().mkdirs();
            if(!fl.exists()) fl.createNewFile();
            FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(database);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(keyValueStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object getObject(String key) {
        return database.get(key);
    }

    public void setObject(String key, Object what) {
        database.put(key, what);
    }

    public void removeKey(String key) {
        database.remove(key);
    }

    public boolean hasKey(String key) {
        return database.containsKey(key);
    }
}
