package fhbrs.ooka.ateam.components;

import java.io.*;
import java.util.ArrayList;

public class RTEMenu {

	private enum MenuName {MAIN, COMPONENTS, COMPONENT, ADD, EXIT};
	private MenuName name = MenuName.MAIN;
	private ComponentManager manager;
    private ArrayList<IComponent> components;
    private boolean running;
    
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private String input;
	    
	public RTEMenu(ComponentManager manager){
		this.manager = manager;
	}	
	
	public void menu() throws Exception{
		switch (name){
			case MAIN: mainMenu();
			break;
	
			case COMPONENTS: componentsMenu();
			break;
			
			case COMPONENT: componentMenu();
			break;
			
			case ADD: addMenu();
			break;

			case EXIT: exitMenu();
			break;
		}
	}
	
	private void mainMenu() throws IOException{
		System.out.println("Please enter a number to choose an option:");
		System.out.println("0: Exit");
		System.out.println("1: Show all loaded Components");
		System.out.println("2: Show all running Components");
		System.out.println("3: Add a component");
		input = in.readLine();
		if(input.equals("1")){
			running = false;
			name = MenuName.COMPONENTS;
		}
		else if(input.equals("2")){
			running = true;
			name = MenuName.COMPONENTS;
		}
		else if(input.equals("3")){
			name = MenuName.ADD;
		}
		else if(input.equals("0") || input.equals("exit")){
			name = MenuName.EXIT;
		}
		else{
			System.out.println(input);
			System.out.println("Invalid input!");
		}
	}
	
	private void componentsMenu() throws IOException{
		if (running){
			components = manager.getRunningComponents();
			System.out.println("Currently running components.");
		}
		else{
			components = manager.getAllComponents();
			System.out.println("List of all components.");			
		}
		for (int i=0; i<components.size(); i++){
			System.out.println("Component "+(i+1)+": "+components.get(i).getName());
		}
		System.out.println("\nFor more information on a component " +
				"please enter the name or number of it.");
		System.out.println("Enter 0 or 'back' to return to the main Menu.");

		input = in.readLine();
		if (input.equals("0") || input.equals("back")){
			name = MenuName.MAIN;
		}
		else if(manager.findByName(input) != null){
			name = MenuName.COMPONENT;
		}
		else{
			System.out.println("Invalid input!");
		}
	}
	
	private void componentMenu() throws Exception{
		String state = "stopped";
		String toggle = "start";
		IComponent comp = manager.findByName(input);
		if (comp.getState()==ComponentState.Running){
			state="running";
			toggle = "stop";
		}
		System.out.println("Component name: "+comp.getName());
		System.out.println("Component description: "+comp.getDescription());
		System.out.println("Component state: "+state);
		System.out.println("\nEnter 1 or '"+toggle+"'to "+toggle+"the component");
		System.out.println("Enter 2 or 'remove' to remove the component from the RTE");
		System.out.println("Enter 0 or 'back' to return to the main Menu.");

		input = in.readLine();
		if (input.equals("0") || input.equals("back")){
			name = MenuName.MAIN;
		}
		else if(input.equals("1") || input.equals(toggle)){
			if (comp.getState()==ComponentState.Running)
				comp.stop();
			else
				comp.start();
		}
		else if(input.equals("2") || input.equals("remove")){
			manager.remove(comp);
			System.out.println("Component "+comp.getName()+" has been removed from the RTE.");
			name = MenuName.MAIN;
		}
		else{
			System.out.println("Invalid input!");
		}
	}

	private void addMenu() throws IOException{
		System.out.println("Please enter the URL or system file path to the" +
				" Component you want to add");
		input = in.readLine();
		if (input.equals("0") || input.equals("back")){
			name = MenuName.MAIN;
		}
		//manager.add();
		name = MenuName.MAIN;
	}
	
	private void exitMenu() throws IOException{
		System.out.println("Are you sure you want to close the RTE? (yes/no)");
		input = in.readLine();
		if (input.equals("yes") || input.equals("y")){
			System.out.println("Goodbey!");
			System.exit(0);
		}
		else if (input.equals("no") || input.equals("n")){
			name = MenuName.MAIN;
		}
		else{
			System.out.println("Invalid input!");
		}
	}
}
