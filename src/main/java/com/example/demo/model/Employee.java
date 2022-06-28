package com.example.demo.model;
import com.example.demo.dao.DAO;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String name;
    private String phone;
    private int age;
    private String email;

    private String password;

    public Employee(@RequestParam String password, @RequestParam long id,@RequestParam String name, @RequestParam String phone, @RequestParam int age,@RequestParam String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
