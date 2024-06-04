package Beanpakg;

import java.sql.Blob;

public class Beanclls {


int id,phnno;
String firstname,lastname,email,username,password;

int pid,price,width,height,weight,quantity,shippingfee;
String name,description,category;
Blob image;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPhnno() {
	return phnno;
}
public void setPhnno(int phnno) {
	this.phnno = phnno;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getShippingfee() {
	return shippingfee;
}
public void setShippingfee(int shippingfee) {
	this.shippingfee = shippingfee;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob image) {
	this.image = image;
}




}
