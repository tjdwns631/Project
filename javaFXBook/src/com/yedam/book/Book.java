package com.yedam.book;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
 private SimpleStringProperty title;
 private SimpleStringProperty name;
 private SimpleStringProperty pub;
 private SimpleIntegerProperty price;
public Book(String title, String name, String pub, int price) {
	super();
	this.title = new SimpleStringProperty(title);
	this.name = new SimpleStringProperty(name);
	this.pub = new SimpleStringProperty(pub);;
	this.price = new SimpleIntegerProperty(price);
}
public String getTitle() {
	return this.title.get();
}
public void setTitle(String title) {
	this.title.set(title);
}
public String getName() {
	return this.name.get();
}
public void setName(String name) {
	this.name.set(name);
}
public String getPub() {
	return this.pub.get();
}
public void setPub(String pub) {
	this.pub.set(pub);
}
public int getPrice() {
	return this.price.get();
}
public void setPrice(int price) {
	this.price.set(price);
}
 
 
}
