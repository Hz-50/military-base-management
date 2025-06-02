package com.militarybase.service;

import com.militarybase.model.UserData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
This class provides service of saving and loading data for each account
 */

public class UserDataService {

    public static void saveUserData(String userId, UserData data){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userdata_" + userId + ".dat"))) {

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    public static UserData loadUserData(String userId){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userdata_" + userId + ".dat"))){
            return (UserData) in.readObject();
        }
        catch (Exception e){
            return new UserData(); // return empty if not found
        }
    }


}
