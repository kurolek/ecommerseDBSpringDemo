package org.kurolek.ecommerseDBSpringDemo.Entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private long id;
//    @Column(name = "first_name", length = 25)
//    private String firstName;
//    @Column(name = "last_name", length = 25)
//    private String lastName;
//    @Column(name = "login", length = 25)
//    private String login;
//    @Column(name = "password", length = 20)
//    private String password;
//    @Column(name = "phone_number", length = 25)
//    private String phoneNumber;
//    @Column(name = "email", length = 50)
//    private String email;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
//    private Role role;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="user_addresses")
//    private Set<Address> addresses = new HashSet<>(0);
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name="user_credit_cards")
//    private Set<CreditCard> creditCards = new HashSet<>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "login", length = 25)
    private String login;
    @Column(name = "password", length = 20)
    private String password;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_credit_cards")
    private Set<CreditCard> creditCards = new HashSet<>(0);
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DeliveryData> deliveryDataSet = new HashSet<>(0);

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User() {
    }

    public Set<DeliveryData> getDeliveryDataSet() {
        return deliveryDataSet;
    }

    public void setDeliveryDataSet(Set<DeliveryData> deliveryDataSet) {
        this.deliveryDataSet = deliveryDataSet;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
