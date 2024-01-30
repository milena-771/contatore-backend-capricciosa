package co.simplon.contatore.dtos;

import java.util.Set;

public class CommandsDto {

    private Set<PizzaDto> allComands;

    public CommandsDto() {
    }

    public Set<PizzaDto> getAllComands() {
	return allComands;
    }

    public void setAllComands(Set<PizzaDto> allComands) {
	this.allComands = allComands;
    }

    @Override
    public String toString() {
	return " {allComands=" + allComands + "}";
    }
}
