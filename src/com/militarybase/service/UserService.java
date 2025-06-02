package com.militarybase.service;

import com.militarybase.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String USER_FILE = "users.dat";
    private List<User> users;

    public UserService(List<User> users) {
        this.users = loadUsers();
    }

    public UserService() {
    }

    // Deserialization
    public List<User> loadUsers(){
        try(
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(USER_FILE))
        ){
            return (List<User>) out.readObject();


        }
        catch (Exception e){
            return new ArrayList<>();

        }
    }

    // Serialization: saving users object list to "users.dat" file
    // FileOutputStream opens or create new file
    // ObjectOutputStream wraps the FileOutputStream to write whole java objects
    private void saveUsers(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE)))
        {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method adds a user to Users list, if the user with these credentials already exists, return false
    public boolean registerUser (String id, String password, String role)
    {
        if(getUserById(id) != null){
            return false; // user already exists
        }
        users.add(new User(id,password,role));
        saveUsers();
        return true;

    }

    // method to check whether user by given id exists or not
    public User getUserById (String id){
        for(User user : users){
            if(user.getId().equals(id)){
                return user;
            }

        }
        return null;
    }

    // method to authenticate
    // it iterates through list and check whether for eah user  the provided values match
    public User authenticate (String id, String password, String role){
        for(User user : users){
            if(user.getId().equals(id) && user.getPassword().equals(password) && user.getRole().equals(role)){
                return user;
            }

        }
        return null;
    }


}
