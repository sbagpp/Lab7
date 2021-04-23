package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());
		System.out.println(model.getPowerOutages(5, 300, new Nerc(14, "casa")));

	}

}
