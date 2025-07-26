package com.todo.todo.modelos;

//importamos esto para poder añadir una subclase a una entidad (la dirección, que pertenece a la entidad "USER"):
import jakarta.persistence.Embeddable;

//con "@embeddable" le estamos diciendo a java que adress no es una tabla sino un objeto dentro de un User:
@Embeddable
public class Address {
    
//definimos atribs. de nuestra clase:

private String street;
private String city;
private String zipcode;
private String country;

//getters & setters:

public String getStreet(){
    return street;
}

public void setStreet(String street){
    this.street=street;
}

public String getCity(){
    return city;
}

public void setCity (String city){
    this.city=city;
}

public String getZipcode() {
    return zipcode;
}

public void setZipcode(String zipcode){
    this.zipcode=zipcode;
}

public String getCountry() {
    return country;
}

public void setCountry(String country){
    this.country=country;
}

}
