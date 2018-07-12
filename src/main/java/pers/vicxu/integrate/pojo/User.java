package pers.vicxu.integrate.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Create by User on 7/12/2018
 */
public class User implements Serializable {
    private static final long serialVersionUID = 3119978570959192700L;

    private Integer id;
    private String uname;
    private int age;
//    @JsonIgnore
    private boolean sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    public User() {
    }

    public User(Integer id, String uname, int age, boolean sex, Date birth) {
        this.id = id;
        this.uname = uname;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birth=" + birth +
                '}';
    }
}
