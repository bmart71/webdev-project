package hu.unideb.inf.dto;

import java.util.Objects;

public class ProducerDTO {
    private int producerId;
    private String name;
    private String webAddress;

    public ProducerDTO() {
    }

    public ProducerDTO(int producerId, String name, String webAddress) {
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
        ProducerDTO that = (ProducerDTO) o;
        return producerId == that.producerId && Objects.equals(name, that.name) && Objects.equals(webAddress, that.webAddress);
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
