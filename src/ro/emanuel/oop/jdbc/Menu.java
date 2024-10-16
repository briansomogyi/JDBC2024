package ro.emanuel.oop.jdbc;

public class Menu {
	
	private int id;
	private String firstMeal;
	private String secondMeal;
	private String desert;
	private int price;
	public Menu() {
	}
	public Menu(int id, String fel1, String fel2, String desert, int pret) {
		this.id = id;
		this.firstMeal = fel1;
		this.secondMeal = fel2;
		this.desert = desert;
		this.price = pret;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstMeal() {
		return firstMeal;
	}
	public void setFirstMeal(String fel1) {
		this.firstMeal = fel1;
	}
	public String getSecondMeal() {
		return secondMeal;
	}
	public void setSecondMeal(String fel2) {
		this.secondMeal = fel2;
	}
	public String getDesert() {
		return desert;
	}
	public void setDesert(String desert) {
		this.desert = desert;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int pret) {
		this.price = pret;
	}
	
	

}
