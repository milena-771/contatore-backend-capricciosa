package co.simplon.contatore.dtos;

import java.util.Collection;

public class ReceiptDto {

    private Collection<CommandDetails> allCommand;

    private String price;

    private int time;

    public ReceiptDto() {
    }

    public Collection<CommandDetails> getAllCommand() {
	return allCommand;
    }

    public void setAllCommand(
	    Collection<CommandDetails> allCommand) {
	this.allCommand = allCommand;
    }

    public String getPrice() {
	return price;
    }

    public void setPrice(String price) {
	this.price = price;
    }

    public int getTime() {
	return time;
    }

    public void setTime(int time) {
	this.time = time;
    }

    @Override
    public String toString() {
	return " {allCommand=" + allCommand + ", price="
		+ price + ", time=" + time + "}";
    }

}
