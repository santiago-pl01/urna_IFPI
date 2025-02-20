package Elementos;

import java.util.ArrayList;

public class Mesario {
	private ArrayList<Eleitor> eleitores = new ArrayList<>();
	
	public Mesario() {}
	//TODO-LIST
	//procurar um eleitor pelo ID
	public Eleitor getEleitorByID(int id) {
		for (Eleitor eleitor : eleitores) {
			if (eleitor.getId() == id) {
				return eleitor;
			}
		}
		return null;
	}
	//Procurar um eleitor pelo Nome
	public Eleitor getEleitorByName(String nome) {
		for (Eleitor eleitor : eleitores) {
			
			if (eleitor.getNome().equals(nome)) { // Trocado == para equals
				return eleitor;
			}
		}
		//senão, retorne nulo
		return null;
	}
	
	//Adicionar um eleitor
	public void addEleitor(String nome, int id) {
		Eleitor e = new Eleitor(nome, id);
		eleitores.add(e);
	}
	//deletar um eleitor
	public void removeEleitor(int id) {
		Eleitor e = getEleitorByID(id);
		eleitores.remove(e);
	}
	
	//contar quantidade de eleitores
	public int contarEleitores() {
		int contador = 0;
		for (Eleitor _ : eleitores) {
			contador += 1;
		}
		return contador;
	}
	
	//printar um eleitor 
	public void printEleitor(int id) {
		Eleitor e = getEleitorByID(id);
		if (e != null) {
			System.out.println("Nome eleitor: " + e.getNome() + " | ID eleitor: " + e.getId());
		}
	}
	public void printAll() {
		for (Eleitor e : eleitores) {
			printEleitor(e.getId());
		}
	}
}
