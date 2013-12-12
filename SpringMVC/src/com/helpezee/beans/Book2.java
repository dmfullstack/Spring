package com.helpezee.beans;

public class Book2 {
	private String Author;
    public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	private Integer year;
	
	public String toString(){
		return "Book{" +
        "Author='" + Author + '\'' +
        ", year=" + year +
        '}';
}
}
