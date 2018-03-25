package by.tc.epam.model.entity;

import java.util.Objects;

public class User {

    private int id;
    private String name;
    private Double balance;
    private String email;
    private UserType userType;

    public User() {
    }

    public User(int id, String name, Double balance, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.email = email;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(balance, user.balance) &&
                Objects.equals(email, user.email) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, balance, email, userType);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }
}
