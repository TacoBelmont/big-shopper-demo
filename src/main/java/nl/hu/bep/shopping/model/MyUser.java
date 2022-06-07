package nl.hu.bep.shopping.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyUser implements Principal {
    private String name;
    private String username;
    private String password;
    private String role;

    private static List<MyUser> allUsers = new ArrayList<MyUser>();

    public String getRole() {
        return role;
    }

    public MyUser(String name, String username, String password, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;

        if (!allUsers.contains(this)){
            allUsers.add(this);
        }
    }

    public String getName() {
        return name;
    }

    public static List<MyUser> getAllUsers(){
        return Collections.unmodifiableList(allUsers);
    }

    public static MyUser getUserByName(String name){
        for (MyUser user : allUsers) {
            if (user.username.equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static String validateLogin(String username, String password){
        for (MyUser user : allUsers) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user.role;
            }
        }
        return null;
    }
}
