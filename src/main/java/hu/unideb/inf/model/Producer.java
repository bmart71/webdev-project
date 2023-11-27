package hu.unideb.inf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCER")
public class Producer implements Serializable {
    @Id
    @GeneratedValue
    private int producerId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "WEB_ADDRESS")
    private String webAddress;

    public Producer() {
    }

    public Producer(int producerId, String name, String webAddress) {
        this.producerId = producerId;
        this.name = name;
        this.webAddress = webAddress;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return producerId == producer.producerId && Objects.equals(name, producer.name) && Objects.equals(webAddress, producer.webAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerId, name, webAddress);
    }

    @Override
    public String toString() {
        return "Producer{ producerId = "+ producerId
                +", name = "+name
                +", webaddress = "+webAddress
                +"}";
    }
}
