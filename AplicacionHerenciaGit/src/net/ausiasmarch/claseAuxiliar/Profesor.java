package net.ausiasmarch.claseAuxiliar;

import java.util.*;

public class Profesor extends Persona {
	private int anyosTrabajados;
	private String departamento;
	private ArrayList<String> asignaturasImpartidas = new ArrayList<String>();

	public Profesor(String dni, String apellidos, String nombres, String sexo, int edad, double peso) {
		super(dni, apellidos, nombres, sexo, edad, peso);
	}

	public Profesor(String dni, String apellidos, String nombres, String sexo, int edad, double peso,
			int anyosTrabajados, String departamento, ArrayList<String> asignaturasImpartidas) {
		super(dni, apellidos, nombres, sexo, edad, peso);
		this.anyosTrabajados = anyosTrabajados;
		this.departamento = departamento;
	}

	public int getAnyosTrabajados() {
		return anyosTrabajados;
	}

	public void setAnyosTrabajados(int anyosTrabajados) {
		this.anyosTrabajados = anyosTrabajados;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public ArrayList<String> getAsignaturasImpartidas() {
		return asignaturasImpartidas;
	}

	public void setAsignaturasImpartidas(ArrayList<String> asignaturasImpartidas) {
		this.asignaturasImpartidas = asignaturasImpartidas;
	}

	public String toString() {
		return "Ha trabajado " + anyosTrabajados + " años, pertenece al departamento " + departamento
				+ " y ha impartido estas aignaturas: " + asignaturasImpartidas;

	}

}