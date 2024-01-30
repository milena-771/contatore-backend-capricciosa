package co.simplon.contatore.services;

import java.util.List;

import co.simplon.contatore.dtos.AllLabels;
import co.simplon.contatore.dtos.CommandsDto;
import co.simplon.contatore.dtos.ReceiptDto;

public interface PizzaService {

    ReceiptDto createCommand(CommandsDto inputs);

    AllLabels getAllLabels();

    ReceiptDto getClientCommand(Long clientId);

    void delete(List<Long> ids);

}
