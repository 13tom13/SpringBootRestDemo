package ru.netology.springbootrestdemo.model;


import javax.validation.constraints.Size;
import java.util.Objects;

public final class User {
    @Size(min = 10, max = 30)
    private final String user;
    @Size(min = 4, max = 30)
    private final String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String user() {
        return user;
    }

    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.user, that.user) &&
                Objects.equals(this.password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "User[" +
                "user=" + user + ", " +
                "password=" + password + ']';
    }


}
