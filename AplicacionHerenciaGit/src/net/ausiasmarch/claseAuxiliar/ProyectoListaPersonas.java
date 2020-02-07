package net.ausiasmarch.claseAuxiliar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class ProyectoListaPersonas {

	private ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	private ArrayList<String> asignaturaImpartida = new ArrayList<String>();
	private Map<String, Float> notasAsignaturas = new HashMap<String, Float>();
	private Persona persona;

	public static void main(String[] args) {

		int opcion;

		ProyectoListaPersonas proyectoPersonas = new ProyectoListaPersonas();
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("\nLISTA DE PERSONAS:");
			System.out.println("[1] Registrar persona");
			System.out.println("[2] Buscar persona por DNI");
			System.out.println("[3] Eliminar persona");
			System.out.println("[4] Mostrar persona");
			System.out.println("[5] Leer personas de archivo");
			System.out.println("[6] Guardar personas en archivo");
			System.out.println("[7] Salir\n");
			System.out.print("Ingrese opción (1-7): ");
			opcion = entrada.nextInt();
			switch (opcion) {
			case 1:
				proyectoPersonas.registrarPersona();
				break;
			case 2:
				proyectoPersonas.buscarPersona();
				break;
			case 3:
				proyectoPersonas.eliminarPersona();
				break;
			case 4:
				proyectoPersonas.mostrarPersonas();
				break;
			case 5:
				proyectoPersonas.leerPersonas();
				break;
			case 6:
				proyectoPersonas.guardarPersonas();
				break;
			case 7:
				System.out.println("Saliendo del programa....");
				break;
			}
		} while (opcion != 7);
	}

	public void registrarPersona() {
		String dni, apellidos, nombres, sexo, departamento, asignaturas, centroEducativo;
		int edad, numeroPersonas, anyosTrabajados, asignaturasProfesor, asignaturasAlumno;
		double peso;
		Scanner entrada = new Scanner(System.in);

		System.out.println("¿Cuantas personas va a introducir?");
		numeroPersonas = entrada.nextInt();
		for (int i = 0; i < numeroPersonas; i++) {
			System.out.println("\nLa persona" + (i + 1) + "es Estudiante(0)"
					+ " o Profesor(1): Ingrese opción (0-1)");
			int tipoPersona=entrada.nextInt();
			if(tipoPersona==1) {
				System.out.println("\nDatos Persona " + (i + 1) + ":");
				System.out.print("\tDNI: ");
				dni = entrada.next();
				System.out.print("\tApellidos: ");
				apellidos = entrada.next();
				System.out.print("\tNombres: ");
				nombres = entrada.next();
				System.out.print("\tSexo: ");
				sexo = entrada.next();
				System.out.print("\tEdad: ");
				edad = entrada.nextInt();
				System.out.print("\tPeso: ");
				peso = entrada.nextDouble();
				System.out.print("\tAños Trabajados: ");
				anyosTrabajados = entrada.nextInt();
				System.out.print("\tDepartamento: ");
				departamento = entrada.next();
				System.out.print("\tCuántas asignaturas imparte el profesor: ");
				asignaturasProfesor= entrada.nextInt();
				for(int j=0;j<asignaturasProfesor;j++) {
					System.out.print("Nombre de la asignatura que imparte: ");
					asignaturas= entrada.next();
					asignaturaImpartida.add(asignaturas);
				}
				Persona profesor= new Persona(dni,apellidos,nombres,sexo,edad,peso);
				listaPersonas.add(profesor);

				
			}
			
			else if(tipoPersona==0) {
				System.out.println("\nDatos Persona " + (i + 1) + ":");
				System.out.print("\tDNI: ");
				dni = entrada.next();
				System.out.print("\tApellidos: ");
				apellidos = entrada.next();
				System.out.print("\tNombres: ");
				nombres = entrada.next();
				System.out.print("\tSexo: ");
				sexo = entrada.next();
				System.out.print("\tEdad: ");
				edad = entrada.nextInt();
				System.out.print("\tPeso: ");
				peso = entrada.nextDouble();
				System.out.print("\tCentro educativo: ");
				centroEducativo = entrada.next();
				System.out.print("\tDe cuántas asignaturas se ha matriculado el estudiante con DNI "+dni+":");
				asignaturasAlumno= entrada.nextInt();
				for(int j=0;j<asignaturasAlumno;j++) {
					System.out.print("Nombre de la asignatura matriculada"+j+":");
					asignaturas= entrada.next();
					System.out.print("Nota de la asignatura matriculada"+j+":");
					Float nota= entrada.nextFloat();
					notasAsignaturas.put(asignaturas, nota);
				}
				Persona estudiante= new Persona(dni,apellidos,nombres,sexo,edad,peso);
				listaPersonas.add(estudiante);
				
			}
			
		}
	}

	public void buscarPersona() {
		String dni;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese DNI a buscar: ");
		dni = entrada.next();

		/************************************************/
		/*
		 * Buscar persona en ArrayList listaPersonas Si existe devuelve los datos de la
		 * persona Si no existe devuelve por consola el texto
		 * "La persona no se encuentra"
		 */
		/************************************************/
		boolean encontrar = false;
		for (Persona p : listaPersonas) {
			if (dni.equalsIgnoreCase(p.getDni())) {
				System.out.println(p.toString());
				encontrar = true;
			}
		if (encontrar == false)
			System.out.println("La persona no se encuentra");
	}
	}

	public void eliminarPersona() {
		String dni;
		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese DNI para eliminar: ");
		dni = entrada.next();
		/************************************************/
		/*
		 * Elimina a persona con DNI introducido del ArrayList listaPersonas Si existe
		 * devuelve por consola el texto "Persona eliminada" junto con los datos de la
		 * persona eliminada Si no existe devuelve el texto "La persona no se encuentra"
		 */
		/************************************************/
		boolean existe = false;
		for (int i = 0; i < listaPersonas.size(); i++) {
			String dni2 = listaPersonas.get(i).getDni();
			if (dni.equalsIgnoreCase(dni2)) {
				System.out.println("Persona eliminada:");
				System.out.println(listaPersonas.get(i).toString());
				listaPersonas.remove(i);
				existe = true;
			}
		}
		if (!existe)
			System.out.println("La persona no se encuentra.");

	}

	public void mostrarPersonas() {
		/************************************************/
		/*
		 * Recorre las personas en el ArrayList listaPersonas y muestra por consola sus
		 * datos Si no existe devuelve por consola el texto
		 * "No existen personas registradas"
		 */
		/************************************************/
		boolean encontrar = false;
		for (Persona p : listaPersonas) {
			System.out.println(p.toString());
			encontrar=true;
		if (encontrar == false)
			System.out.println("La persona no se encuentra");
	}
		
	}

	public ProyectoListaPersonas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void leerPersonas() {
		listaPersonas = (ArrayList<Persona>) Helper.deserializaDesdeFichero("datosPersonas.dat");
	}
	public void guardarPersonas() {
		Helper.serializaEnFichero("datosPersonas.dat", listaPersonas);
	}

}
