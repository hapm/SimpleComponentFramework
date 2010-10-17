package fhbrs.ooka.ateam.components;

public class RTEMain {

	private static ComponentManager manager = new ComponentManager();
	private static ComponentRepository repo = new ComponentRepository();
	private static RTEMenu menu = new RTEMenu(manager, repo);

	public static void main (String[] args)throws Exception{
		System.out.println("Welcome to the A-Team RTE!");
	
		while (true){
			menu.menu();
		}
	}
}