package org.kurolek.ecommerseDBSpringDemo;

import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.SessionFactory;
import org.kurolek.ecommerseDBSpringDemo.Entity.*;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();
        System.out.println("Start");



        //region Role creating and persist
        Role role1 = new Role();
        role1.setName("user");
        Role role2 = new Role();
        role2.setName("admin");

        entityManager.getTransaction().begin();
        entityManager.persist(role1);
        entityManager.persist(role2);
        entityManager.getTransaction().commit();
        //endregion

        //region Category creating and persist
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setName("Food");
        category2.setName("Drink");

        entityManager.getTransaction().begin();
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.getTransaction().commit();

        //endregion

        //region Creating and persist person
        Person person1 = new Person();
        Person person2 = new Person();
        person1.setEmail("email@example.com");
        person1.setFirstName("Anton");
        person1.setLastName("Filipov");
        person1.setPhoneNumber("+45111222333");
        person2.setEmail("someemail@gmail.com");
        person2.setFirstName("Name");
        person2.setLastName("Last_name");
        person2.setPhoneNumber("111222333444");

        entityManager.getTransaction().begin();
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.getTransaction().commit();
        //endregion

        //region Creating user without credit card
        User user1 = new User();
        User user2 = new User();
        user1.setPerson(person1);
        user2.setPerson(person2);
        user1.setLogin("defaultLogin");
        user1.setPassword("defaultPassword");
        user1.setRole(role1);
        user2.setLogin("ghbd1234");
        user1.setPassword("somePassword");
        user2.setRole(role2);
        //endregion

        //region Creating and persist credit cards
        CreditCard creditCard1 = new CreditCard();
        CreditCard creditCard2 = new CreditCard();
        creditCard1.setFirstName("DEFAULT");
        creditCard1.setLastName("USER");
        creditCard2.setFirstName("AKIM");
        creditCard2.setLastName("AKIMOV");
        creditCard1.setCvv2(123);
        creditCard2.setCvv2(525);
        creditCard1.setNumber("2152 2458 2752 2732");
        creditCard2.setNumber("1111 2222 3333 4444");


        entityManager.getTransaction().begin();
        entityManager.persist(creditCard1);
        entityManager.persist(creditCard2);
        entityManager.getTransaction().commit();
        //endregion

        //region Creating and persist addresses
        Address address1 = new Address();
        Address address2 = new Address();
        address1.setCity("DefaultCity");
        address1.setCountry("Default");
        address1.setStreet("Default street 1/6");
        address1.setCountry("Default country");
        address2.setCity("Moscow");
        address2.setCountry("Russia");
        address2.setStreet("Lenina 123");

        entityManager.getTransaction().begin();
        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.getTransaction().commit();

        //endregion

        //region add credit card to user and persist
        user1.getCreditCards().add(creditCard1);
        user1.getCreditCards().add(creditCard2);
        user2.getCreditCards().add(creditCard2);

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        //endregion

        //region Creating and persist delivery data
        DeliveryData deliveryData1 = new DeliveryData();
        DeliveryData deliveryData2 = new DeliveryData();
        deliveryData1.setAddress(address1);
        deliveryData1.setUser(user1);
        deliveryData1.setPerson(deliveryData1.getUser().getPerson());
        deliveryData2.setAddress(address2);
        deliveryData2.setUser(user2);
        deliveryData2.setPerson(deliveryData2.getUser().getPerson());

        entityManager.getTransaction().begin();
        entityManager.persist(deliveryData1);
        entityManager.persist(deliveryData2);
        entityManager.getTransaction().commit();
        //endregion

        //region Create and persist producers
        Producer producer1 = new Producer();
        Producer producer2 = new Producer();
        producer1.setAddress(address1);
        producer2.setAddress(address2);
        producer1.setName("Hey");
        producer2.setName("Orange");

        entityManager.getTransaction().begin();
        entityManager.persist(producer1);
        entityManager.persist(producer2);
        entityManager.getTransaction().commit();
        //endregion

        //region creating and persist products and product details
        Product product1 = new Product();
        Product product2 = new Product();
        ProductDetails productDetails1 = new ProductDetails();
        ProductDetails productDetails2 = new ProductDetails();

        product1.setCategory(category1);
        product1.setName("Product1");
        product1.setPrice(10.02);
        product1.setProducer(producer1);
        product1.setProductDetails(productDetails1);
        product2.setCategory(category2);
        product2.setName("Product2");
        product2.setPrice(27.00);
        product2.setProducer(producer2);
        product2.setProductDetails(productDetails2);

        productDetails1.setDescription("Description product1");
        productDetails1.setImage("srcimg1");
        productDetails1.setProduct(product1);
        productDetails2.setDescription("Description product2");
        productDetails2.setImage("srcimg2");
        productDetails2.setProduct(product2);


        entityManager.getTransaction().begin();
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(productDetails1);
        entityManager.persist(productDetails2);
        entityManager.getTransaction().commit();
        //endregion

        Order order1 = new Order();
        Order order2 = new Order();

        //region Creating and persist order
        order1.setOrderDate(LocalDateTime.now());
        order1.setUser(user1);
        order1.setStatus("Prepared");
        order1.setCommentary("");
        order1.setPaymentMethod("card");
        order2.setOrderDate(LocalDateTime.now());
        order2.setUser(user2);
        order2.setStatus("Prepared");
        order2.setCommentary("");
        order2.setPaymentMethod("PayPal");

        entityManager.getTransaction().begin();
        entityManager.persist(order1);
        entityManager.persist(order2);
        entityManager.getTransaction().commit();
        //endregion

        //region Creating and persist ordered products
        OrderedProduct orderedProduct1 = new OrderedProduct();
        OrderedProduct orderedProduct2 = new OrderedProduct();

        orderedProduct1.setOrder(order1);
        orderedProduct1.setQuantity(5);
        orderedProduct1.setProduct(product1);
        orderedProduct2.setOrder(order2);
        orderedProduct2.setQuantity(1);
        orderedProduct2.setProduct(product2);

        entityManager.getTransaction().begin();
        entityManager.persist(orderedProduct2);
        entityManager.persist(orderedProduct1);
        entityManager.getTransaction().commit();
        //endregion

        Delivery delivery1 = new Delivery();
        Delivery delivery2 = new Delivery();

        delivery1.setOrder(order1);
        delivery1.setDeliveryData(deliveryData1);
        delivery1.setStatus("Prepared");
        delivery1.setUser(user1);
        delivery2.setOrder(order2);
        delivery2.setDeliveryData(deliveryData2);
        delivery2.setStatus("Waiting for pickup");
        delivery2.setUser(user2);

        entityManager.getTransaction().begin();
        entityManager.persist(delivery1);
        entityManager.persist(delivery2);
        entityManager.getTransaction().commit();
    }
}
