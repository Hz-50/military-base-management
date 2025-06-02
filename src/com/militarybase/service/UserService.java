package com.militarybase.service;

import com.militarybase.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String USER_FILE = "users.dat";
    private List<User> users;

    // Constructor that accepts a list (optional)
    public UserService(List<User> users) {
        this.users = users;
    }

    // Default constructor: always load from file
    public UserService() {
        this.users = loadUsers();
    }

    // Deserialization: load user list from file
    public List<User> loadUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            return (List<User>) in.readObject();
        } catch (Exception e) {
            // If file not found or deserialization fails, return empty list
            return new ArrayList<>();
        }
    }

    // Serialization: save user list to file
    private void saveUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Register a new user if ID is not taken
    public boolean registerUser(String id, String password, String role) {
        if (getUserById(id) != null) {
            return false; // user already exists
        }
        users.add(new User(id, password, role));
        saveUsers();
        return true;
    }

    // Find user by ID
    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // Authenticate user by ID, password, and role
    public User authenticate(String id, String password, String role) {
        for (User user : users) {
            if (user.getId().equals(id) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equals(role)) {
                return user;
            }
        }
        return null;
    }
}