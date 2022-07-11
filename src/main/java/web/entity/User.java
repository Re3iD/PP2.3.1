package web.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="last_name")
    private String lastName;

    public User(){

    }
    public User(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return id+": "+ name+" "+lastName;
    }
}
