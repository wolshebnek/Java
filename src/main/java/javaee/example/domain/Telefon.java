package javaee.example.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Telefon {

    private int id;
    @NotEmpty(message = "Introduceti Denumirea")
    @Size(min = 2, max = 15, message = "Sirul de caractere nu corespunde min 2 max 15")
    private String denumire;
    @NotEmpty(message = "Introduceti Producatorul")
    @Size(min = 2, max = 15, message = "Sirul de caractere nu corespunde min 2 max 15")
    private String producator;
    @NotEmpty(message = "Introduceti Modelul")
    @Size(min = 2, max = 15, message = "Sirul de caractere nu corespunde min 2 max 15")
    private String model;
    private int pretul;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPretul() {
        return pretul;
    }

    public void setPretul(int pretul) {
        this.pretul = pretul;
    }

}
