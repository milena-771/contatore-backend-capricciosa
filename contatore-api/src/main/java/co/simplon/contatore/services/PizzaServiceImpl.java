package co.simplon.contatore.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.contatore.dtos.AllLabels;
import co.simplon.contatore.dtos.BaseDetail;
import co.simplon.contatore.dtos.CommandDetails;
import co.simplon.contatore.dtos.CommandsDto;
import co.simplon.contatore.dtos.IngredientDetails;
import co.simplon.contatore.dtos.IngredientDto;
import co.simplon.contatore.dtos.IngredientLabel;
import co.simplon.contatore.dtos.PizzaDto;
import co.simplon.contatore.dtos.ReceiptDto;
import co.simplon.contatore.dtos.ShapeDetail;
import co.simplon.contatore.dtos.SizeDetail;
import co.simplon.contatore.entities.Base;
import co.simplon.contatore.entities.Client;
import co.simplon.contatore.entities.Command;
import co.simplon.contatore.entities.Ingredient;
import co.simplon.contatore.entities.Pizza;
import co.simplon.contatore.entities.Possess;
import co.simplon.contatore.entities.Shape;
import co.simplon.contatore.entities.Size;
import co.simplon.contatore.repositories.BaseRepository;
import co.simplon.contatore.repositories.ClientRepository;
import co.simplon.contatore.repositories.CommandRepository;
import co.simplon.contatore.repositories.IngredientRepository;
import co.simplon.contatore.repositories.PizzaRepository;
import co.simplon.contatore.repositories.PossessRepository;
import co.simplon.contatore.repositories.ShapeRepository;
import co.simplon.contatore.repositories.SizeRepository;
import co.simplon.contatore.services.PizzaService;

@Service
@Transactional(readOnly = true)
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzas;

    private final BaseRepository bases;

    private final ShapeRepository shapes;

    private final SizeRepository sizes;

    private final IngredientRepository ingredients;

    private final PossessRepository possess;

    private final ClientRepository clients;

    private final CommandRepository command;

    public PizzaServiceImpl(PizzaRepository pizzas,
	    BaseRepository bases, ShapeRepository shapes,
	    SizeRepository sizes,
	    IngredientRepository ingredients,
	    PossessRepository possess,
	    ClientRepository clients,
	    CommandRepository command) {
	this.pizzas = pizzas;
	this.bases = bases;
	this.shapes = shapes;
	this.sizes = sizes;
	this.ingredients = ingredients;
	this.possess = possess;
	this.clients = clients;
	this.command = command;
    }

    @Override
    @Transactional
    public ReceiptDto createCommand(CommandsDto inputs) {

	Client client = new Client();
	Client clientSaved = clients.save(client);

	Collection<CommandDetails> details = new ArrayList<>();
	ReceiptDto receipt = new ReceiptDto();

	double price = 0;
	int time = 0;

	Set<PizzaDto> allPizzas = inputs.getAllComands();

	for (PizzaDto pizza : allPizzas) {
	    Command commandEntity = new Command();

	    Pizza entity = new Pizza();
	    CommandDetails oneCommand = new CommandDetails();
	    entity.setCommandNumber(
		    pizza.getCommandNumber());
	    entity.setInitial(pizza.getInitial());

	    String identifier = pizza.getCommandNumber()
		    + "-" + pizza.getInitial();
	    oneCommand.setIdentifier(identifier);

	    Long sizeId = pizza.getSizeId();
	    if (sizeId.equals(1L)) {
		price += 10;
		time += 120;
	    } else if (sizeId.equals(2L)) {
		price += 12;
		time += 170;
	    } else {
		price += 13;
		time += 210;
	    }

	    Size oneSize = sizes.getReferenceById(sizeId);
	    entity.setSize(oneSize);
	    oneCommand.setSizeName(oneSize.getSizeName());

	    Long baseId = pizza.getBaseId();
	    if (baseId.equals(1L)) {
		price = price - 0.80;
		time = time - 5;
	    }
	    Base oneBase = bases.getReferenceById(baseId);
	    entity.setBase(oneBase);
	    oneCommand.setBaseName(oneBase.getBaseName());

	    Shape oneShape = shapes
		    .getReferenceById(pizza.getShapeId());
	    entity.setShape(oneShape);
	    oneCommand
		    .setShapeName(oneShape.getShapeName());

	    entity.setStatus("En préparation");
	    Pizza pizzaSaved = pizzas.save(entity);

	    commandEntity.setClient(clientSaved);
	    commandEntity.setPizza(pizzaSaved);
	    command.save(commandEntity);

	    oneCommand.setStatus("En préparation");
	    oneCommand.setId(pizzaSaved.getId());

	    Set<IngredientDetails> ingredientReceipt = new HashSet<>();

	    for (IngredientDto oneIngredient : pizza
		    .getIngredientDetails()) {
		if (!oneIngredient.getQuantity()
			.equals('0')) {
		    IngredientDetails ingredientDetails = new IngredientDetails();

		    price += 0.80;
		    if (oneIngredient.getQuantity()
			    .equals('2')) {
			price += 0.80;
		    }
		    Possess possessIngredient = new Possess();
		    Ingredient ingredient = ingredients
			    .getReferenceById(oneIngredient
				    .getIngredientId());

		    ingredientDetails.setIngredientName(
			    ingredient.getIngredientName());
		    ingredientDetails.setQuantity(
			    oneIngredient.getQuantity());
		    ingredientReceipt
			    .add(ingredientDetails);

		    possessIngredient
			    .setIngredient(ingredient);
		    possessIngredient.setPizza(pizzaSaved);

		    possess.save(possessIngredient);
		}
	    }
	    oneCommand.setIngredientList(ingredientReceipt);
	    details.add(oneCommand);
	}
	receipt.setAllCommand(details);

	String roundedPrice = String.format("%.2f", price);
	receipt.setPrice(roundedPrice);

	int timeMin = time / 60;
	receipt.setTime(timeMin);
	return receipt;
    }

    @Override
    public AllLabels getAllLabels() {
	Collection<BaseDetail> baseLabels = bases
		.findAllProjectedByOrderByBaseName();
	Collection<ShapeDetail> shapeLabels = shapes
		.findAllProjectedByOrderByShapeName();
	Collection<SizeDetail> sizeLabels = sizes
		.findAllProjectedByOrderBySizeName();
	Collection<IngredientLabel> ingredientLabels = ingredients
		.findAllProjectedByOrderByIngredientName();
	AllLabels labels = new AllLabels();
	labels.setBaseLabels(baseLabels);
	labels.setShapeLabels(shapeLabels);
	labels.setIngredientLabel(ingredientLabels);
	labels.setSizeLabel(sizeLabels);
	return labels;
    }

    @Override
    public ReceiptDto getClientCommand(Long clientId) {
	ReceiptDto receipt = new ReceiptDto();
	Collection<CommandDetails> allCommands = new ArrayList<>();
	List<Command> commands = command
		.findByClientId(clientId);
	for (Command oneCommand : commands) {
	    CommandDetails oneCommandDetail = new CommandDetails();
	    Set<IngredientDetails> allIngredient = new HashSet();

	    Pizza pizza = oneCommand.getPizza();
	    String number = pizza.getCommandNumber();
	    String initial = pizza.getInitial();
	    oneCommandDetail
		    .setIdentifier(number + "-" + initial);
	    oneCommandDetail.setSizeName(
		    pizza.getSize().getSizeName());
	    oneCommandDetail.setBaseName(
		    pizza.getBase().getBaseName());
	    oneCommandDetail.setShapeName(
		    pizza.getShape().getShapeName());
	    oneCommandDetail.setStatus(pizza.getStatus());

	    Long pizzaId = pizza.getId();
	    List<Possess> possessList = possess
		    .findByPizzaId(pizzaId);
	    for (Possess onePossess : possessList) {
		IngredientDetails oneIngredient = new IngredientDetails();
		Ingredient ingredient = onePossess
			.getIngredient();
		oneIngredient.setIngredientName(
			ingredient.getIngredientName());
		allIngredient.add(oneIngredient);
	    }
	    oneCommandDetail
		    .setIngredientList(allIngredient);
	    allCommands.add(oneCommandDetail);
	}
	receipt.setAllCommand(allCommands);
	return receipt;
    }

    @Override
    @Transactional
    public void delete(List<Long> ids) {
	// command.deleteByPizzaIdIn(listId);
	pizzas.deleteByIdIn(ids);
	/*
	 * for (Long oneId : listId) { command.deleteByPizzaId(oneId);
	 * pizzas.deleteById(oneId); }
	 */
    }

}
