package co.simplon.contatore.dtos;

import java.util.List;

public class ListId {

    private List<Long> listId;

    public ListId() {
    }

    public List<Long> getListId() {
	return listId;
    }

    public void setListId(List<Long> listId) {
	this.listId = listId;
    }

    @Override
    public String toString() {
	return " {listId=" + listId + "}";
    }

}
