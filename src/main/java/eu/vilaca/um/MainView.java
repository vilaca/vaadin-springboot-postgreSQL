package eu.vilaca.um;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route
public class MainView extends VerticalLayout {

	public MainView(UserRepository repo) {
		final var grid = new Grid<>(Users.class);
		grid.setColumns("id", "name", "email");
		grid.setSelectionMode(Grid.SelectionMode.SINGLE);
		grid.setItems(getUsersAsList(repo));
		grid.addSelectionListener(this::showNotification);
		add(grid);
	}

	private void showNotification(SelectionEvent<Grid<Users>, Users> selectionEvent) {
		selectionEvent.getFirstSelectedItem()
				.ifPresent(person -> Notification.show(person.getName() + " is selected"));
	}

	private List<Users> getUsersAsList(UserRepository repo) {
		final List<Users> result = new ArrayList<>();
		repo.findAll().forEach(result::add);
		return result;
	}
}