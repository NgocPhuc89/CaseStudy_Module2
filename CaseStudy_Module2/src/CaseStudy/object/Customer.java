package CaseStudy.object;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Customer {
    private long id ;
    private String name ;
    private String idCard;
    private String phone;
    private LocalDateTime rental_hours;
    private LocalDateTime payment_time;
    private int quantity ;
    private int total;
    private int total_time;

    public Customer(){}

    public Customer(long id, String name, String idCard, String phone, LocalDateTime rental_hours, LocalDateTime payment_time, int quantity, int total, int total_time ){
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.rental_hours = rental_hours;
        this.payment_time = payment_time;
        this.quantity = quantity;
        this.total = total;
        this.total_time = total_time;
    }


    public static Customer fileAll(String addNew){
        String[] data = addNew.split(",");
        long id = Long.parseLong((data[0]));
        String name = data[1];
        String idCard = data[2];
        String phone = data[3];
        LocalDateTime rental_hours = LocalDateTime.parse(data[4]);
        int quantity = Integer.parseInt(data[5]);
        Customer customer = new Customer()
                .setId(id)
                .setName(name)
                .setIdCard(idCard)
                .setPhone(phone)
                .setRental_hours(rental_hours)
                .setQuantity(quantity);
        return customer;
    }

    public long getId() {
        return id;
    }

    public Customer setId(long id) {
        this.id = id;
        return this ;
    }

    public String getName() {
        return this.name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public Customer setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getPhone() {
        return this.phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDateTime getRental_hours() {
        return rental_hours;
    }

    public Customer setRental_hours(LocalDateTime date_of_hire) {
        this.rental_hours = date_of_hire;
        return this;
    }

    public LocalDateTime getPayment_time() {
        return LocalDateTime.now();
    }

    public Customer setPayment_time(LocalDateTime payment) {
        this.payment_time = payment;
        return this;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Customer setQuantity(int price) {
        this.quantity = price;
        return this;
    }

    public int getTotal() {
        total = 200 * getTotal_time() * getQuantity() ;
        return this.total;
    }

    public Customer setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getTotal_time() {
        return (int) ChronoUnit.MINUTES.between(getRental_hours(),getPayment_time());
    }



    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idCard, phone, rental_hours, quantity);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",id,name,idCard,phone,rental_hours,quantity);
    }
}
