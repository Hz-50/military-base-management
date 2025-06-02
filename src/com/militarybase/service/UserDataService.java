package com.militarybase.service;

import com.militarybase.model.UserData;
import java.io.*;

public class UserDataService {
    public static void saveUserData(String userId, UserData userData) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userdata_" + userId + ".dat"))) {
            out.writeObject(userData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserData loadUserData(String userId) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userdata_" + userId + ".dat"))) {
            return (UserData) in.readObject();
        } catch (Exception e) {
            return new UserData(); // Return empty if file not found/corrupt
        }
    }
}