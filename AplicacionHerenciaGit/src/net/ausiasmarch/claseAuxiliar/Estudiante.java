package net.ausiasmarch.claseAuxiliar;

import java.util.*;

public class Estudiante extends Persona {
	private String nombreCentroEducativo;
	private Map<String, Float> notasAsignaturas = new HashMap<String, Float>();

	public Estudiante(String dni, String apellidos, String nombres, String sexo, int edad, double peso) {
		super(dni, apellidos, nombres, sexo, edad, peso);
	}

	public Estudiante(String dni, String apellidos, String nombres, String sexo, int edad, double peso,
			String nombreCentroEducativo) {
		super(dni, apellidos, nombres, sexo, edad, peso);
		this.nombreCentroEducativo = nombreCentroEducativo;

	}

	public String getNombreCentroEducativo() {
		return nombreCentroEducativo;
	}

	public void setNombreCentroEducativo(String nombreCentroEducativo) {
		this.nombreCentroEducativo = nombreCentroEducativo;
	}

	public Map<String, Float> getNotasAsignaturas() {
		return notasAsignaturas;
	}

	public void setNotasAsignaturas(Map<String, Float> notasAsignaturas) {
		this.notasAsignaturas = notasAsignaturas;
	}
	public Float notaMedia() {
		Float suma = new Float(0);
		int cont=0;
		Iterator<String>
		it=notasAsignaturas.keySet().iterator();
		while(it.hasNext()) {
			String clave=it.next();
			Float valor= notasAsignaturas.get(clave);
			suma+=valor;
			cont++;
		}
		Float media=suma/cont;
		return media;
	}
	public String toString() {
		return "El centro educativo en el que estudia se llama "+nombreCentroEducativo;
		
	}
	
}
