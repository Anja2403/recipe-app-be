package com.onboarding.anja.recipes.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;

    //new

    @OneToMany(mappedBy = "user")
    private List<RecipeEntity> recipes;
    // unidirectional mapping
    // we are not able to access user from recipes
    // new additional helper table was generated for us

    @OneToMany(mappedBy = "user")
    private List<TypeEntity> types;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;


    public UserEntity() {

    }
    public UserEntity(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<RecipeEntity> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeEntity> recipes) {
        this.recipes = recipes;
    }

    public List<TypeEntity> getTypes() {
        return types;
    }

    public void setTypes(List<TypeEntity> types) {
        this.types = types;
    }
}
