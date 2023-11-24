package hu.unideb.inf.dto;

import java.util.Objects;

public class ProductDTO {
    private int id;
    private String name;
    private String type;
    private int amountAvailable;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String type, int amountAvailable) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amountAvailable = amountAvailable;
    }

    public int getId() {
        return id;
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
        ProductDTO that = (ProductDTO) o;
        return id == that.id && amountAvailable == that.amountAvailable && Objects.equals(name, that.name) && Objects.equals(type, that.type);
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
