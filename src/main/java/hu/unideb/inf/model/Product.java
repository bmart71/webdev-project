package hu.unideb.inf.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "AMOUNT_AVAILABLE")
    private int amountAvailable;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCER_ID")
    private Producer producer;

    public Product() {
    }

    public Product(int id, String name, String type, int amountAvailable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amountAvailable = amountAvailable;
    }

    public int getId() {
        return id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && amountAvailable == product.amountAvailable && Objects.equals(name, product.name) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, amountAvailable);
    }

    @Override
    public String toString(){
        return "Product{ id = "+id
                +", name = "+name
                +", type = "+type
                +", amount available = "+amountAvailable
                +"}";
    }
}
