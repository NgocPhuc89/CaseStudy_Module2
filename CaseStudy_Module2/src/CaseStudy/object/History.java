package CaseStudy.object;

import java.time.LocalDateTime;

public class History {
    private long id;
    private String name ;
    private String idCard;
    private String phone;
    private LocalDateTime payment_time;
    private int quantity ;
    private int total_money;

    public History(){}

    public static History fileHistory(String addHistory){
        String[] data = addHistory.split(",");
        long id = Long.parseLong(data[0]);
        String name = data[1];
        String idCard = data[2];
        String phone = data[3];
        LocalDateTime payment_time = LocalDateTime.parse(data[4]);
        int quantity = Integer.parseInt(data[5]);
        int total = Integer.parseInt(data[6]);
        History history = new History()
                .setId(id)
                .setName(name)
                .setIdCard(idCard)
                .setPhone(phone)
                .setPayment_time(payment_time)
                .setQuantity(quantity)
                .setTotal_money(total);
        return history;
    }

    public long getId() {
        return id;
    }

    public History setId(long id) {
        this.id = id;
        return this;
    }

    public int getTotal_money() {
        return total_money;
    }

    public History setTotal_money(int total_money) {
        this.total_money = total_money;
        return this;
    }

    public String getName() {
        return name;
    }

    public History setName(String name) {
        this.name = name;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public History setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public History setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDateTime getPayment_time() {
        return payment_time;
    }

    public History setPayment_time(LocalDateTime rental_hours) {
        this.payment_time = rental_hours;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public History setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }


    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",id,name,idCard,phone,payment_time,quantity,total_money);
    }
}

