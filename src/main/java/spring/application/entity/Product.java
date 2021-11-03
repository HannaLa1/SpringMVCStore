package spring.application.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @Size(min = 2, max = 50, message = "Name of product should be between 2 and 50 characters")
    @Pattern(regexp = "^[A-ZА-Я]\\s?([^\\d && \\S]\\s?)*(\\d\\s?)*$", message = "Name of product starts with a capital letter," +
            " may contain numbers, but only at the end," +
            " spaces between words and numbers, but not 2 in a row.")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater then 0")
    private int price;

    @Column(name = "localeDate")
    private String localeDate;

    @Column(name = "localeTime")
    private LocalTime localeTime;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocaleDate() {
        return localeDate;
    }

    public void setLocaleDate(String localeDate) {
        this.localeDate = localeDate;
    }

    public LocalTime getLocaleTime() {
        return localeTime;
    }

    public void setLocaleTime(LocalTime localeTime) {
        this.localeTime = localeTime;
    }
}
