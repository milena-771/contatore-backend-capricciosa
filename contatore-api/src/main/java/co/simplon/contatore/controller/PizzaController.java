package co.simplon.contatore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.contatore.dtos.AllLabels;
import co.simplon.contatore.dtos.CommandsDto;
import co.simplon.contatore.dtos.ReceiptDto;
import co.simplon.contatore.services.PizzaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ReceiptDto post(
	    @RequestBody @Valid CommandsDto inputs) {
	return service.createCommand(inputs);
    }

    @GetMapping("/labels")
    public AllLabels getAllLabels() {
	return service.getAllLabels();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReceiptDto getClientCommand(
	    @PathVariable("id") Long id) {
	return service.getClientCommand(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(List<Long> ids) {
	service.delete(ids);
    }

}
