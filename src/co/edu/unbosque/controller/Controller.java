package co.edu.unbosque.controller;

import co.edu.unbosque.model.Lista;
import co.edu.unbosque.model.Node;
import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.view.VistaConsola;

public class Controller {
	private VistaConsola Vista;
	private Paciente Paciente;
	private Lista Lista;

	public Controller() {
		Vista = new VistaConsola();
		Lista = new Lista();
	}

	public void Funcionar() {

		String menu = "Menú de Opciones: \n " + "1. Agregar Paciente\n " + "2. Agregar Paciente Prioritario \n "
				+ "3. Eliminar paciente \n " + "4. Consultar paciente \n " + "5. Editar paciente \n"
				+ "6. Agregar paciente antes de otro \n" + "7. Agregar paciente despues de otro \n" + "8. Listado \n" + "9. Salir... \n"
				+ "Ingrese la Opcion: ";
		int option = 0;
		do {
			option = Vista.ReadInteger(menu);
			switch (option) {
			case 1:
				System.out.println("Ingrese los datos del paciente:");
				int codigo = Vista.ReadInteger("Código único:");
				String nombreApellidos = Vista.ReadString("Nombre y apellidos:");
				String remitido = Vista.ReadString("Remitido:");
				String dondeRemitido = Vista.ReadString("Donde remitido:");
				String diagnostico = Vista.ReadString("Diagnóstico:");
				String genero = Vista.ReadString("Género:");
				String fechaIngreso = Vista.ReadString("Fecha de ingreso:");
				String medicoTratante = Vista.ReadString("Médico tratante:");

				Paciente nuevoPaciente = new Paciente(codigo, nombreApellidos, remitido, dondeRemitido, diagnostico,
						genero, fechaIngreso, medicoTratante);

				Lista.agregarPaciente(nuevoPaciente);

				System.out.println("Paciente agregado con éxito.");
				break;

			case 2:
				System.out.println("Ingrese los datos del paciente prioritario:");
				int codigoPrioritario = Vista.ReadInteger("Código único:");
				String nombreApellidosPrioritario = Vista.ReadString("Nombre y apellidos:");
				String remitidoPrioritario = Vista.ReadString("Remitido:");
				String dondeRemitidoPrioritario = Vista.ReadString("Donde remitido:");
				String diagnosticoPrioritario = Vista.ReadString("Diagnóstico:");
				String generoPrioritario = Vista.ReadString("Género:");
				String fechaIngresoPrioritario = Vista.ReadString("Fecha de ingreso:");
				String medicoTratantePrioritario = Vista.ReadString("Médico tratante:");

				Paciente nuevoPacientePrioritario = new Paciente(codigoPrioritario, nombreApellidosPrioritario,
						remitidoPrioritario, dondeRemitidoPrioritario, diagnosticoPrioritario, generoPrioritario,
						fechaIngresoPrioritario, medicoTratantePrioritario);

				Lista.agregarPacientePrioritario(nuevoPacientePrioritario);

				System.out.println("Paciente prioritario agregado con éxito.");
				break;
			case 3:
			    String codigoPrioritario1 = Vista.ReadString("Código:");
			    try {
			        int codigo1 = Integer.parseInt(codigoPrioritario1);
			        boolean eliminado = Lista.eliminarporcodigo(codigo1);
			        if (eliminado) {
			            System.out.println("Paciente eliminado con éxito.");
			        } else {
			            System.out.println("No se encontró un paciente con el código especificado.");
			        }
			    } catch (NumberFormatException e) {
			        System.out.println("Error: El código debe ser un número válido.");
			    }
			    break;

			case 4:
			    String codigoPrioritario11 = Vista.ReadString("Código:");
			    try {
					int codigo1 = Integer.parseInt(codigoPrioritario11);
			        Node nodoPaciente = Lista.buscar(codigo1);

			        if (nodoPaciente != null) {
			            System.out.println("Paciente encontrado:");
			            System.out.println(nodoPaciente.dato.toString());
			        } else {
			            System.out.println("No se encontró un paciente con el código especificado.");
			        }
			    } catch (NumberFormatException e) {
			        System.out.println("Error: El código debe ser un número válido.");
			    }
			    break;


			case 5:
			    String codigoEditar = Vista.ReadString("Código del paciente a editar:");
			    try {
			        int codigo1 = Integer.parseInt(codigoEditar);
			        Node nodoPaciente = Lista.buscar(codigo1);

			        if (nodoPaciente != null) {
			            System.out.println("Paciente encontrado:");
			            System.out.println(nodoPaciente.dato.toString());
			            int nuevoCodigo = Vista.ReadInteger("Nuevo código único:");
			            String nuevoNombreApellidos = Vista.ReadString("Nuevo nombre y apellidos:");
			            String nuevoRemitido = Vista.ReadString("Nuevo remitido:");
			            String nuevoDondeRemitido = Vista.ReadString("Nuevo donde remitido:");
			            String nuevoDiagnostico = Vista.ReadString("Nuevo diagnóstico:");
			            String nuevoGenero = Vista.ReadString("Nuevo género:");
			            String nuevaFechaIngreso = Vista.ReadString("Nueva fecha de ingreso:");
			            String nuevoMedicoTratante = Vista.ReadString("Nuevo médico tratante:");
			            Paciente nuevoPaciente1 = new Paciente(
			                nuevoCodigo, nuevoNombreApellidos, nuevoRemitido,
			                nuevoDondeRemitido, nuevoDiagnostico, nuevoGenero,
			                nuevaFechaIngreso, nuevoMedicoTratante
			            );
			            Lista.editarPaciente(codigo1, nuevoPaciente1);

			            System.out.println("Paciente editado con éxito.");
			        } else {
			            System.out.println("No se encontró un paciente con el código especificado.");
			        }
			    } catch (NumberFormatException e) {
			        System.out.println("Error: El código debe ser un número válido.");
			    }
			    break;

			case 6:
			    String codigoAntesStr = Vista.ReadString("Código del paciente antes del cual desea agregar otro paciente:");
			    try {
			        int codigoAntes = Integer.parseInt(codigoAntesStr);
			        Paciente nuevoPacienteAntes = pedirDatosPaciente(); // Solicitar datos del nuevo paciente
			        Lista.insertarAntescodigo(codigoAntes, nuevoPacienteAntes);
			        System.out.println("Paciente agregado antes del paciente con código " + codigoAntes + " con éxito.");
			    } catch (NumberFormatException e) {
			        System.out.println("Error: El código debe ser un número válido.");
			    }
			    break;
			case 7:
			    String codigoDespuesStr = Vista.ReadString("Código del paciente después del cual desea agregar otro paciente:");
			    try {
			        int codigoDespues = Integer.parseInt(codigoDespuesStr);
			        Paciente nuevoPacienteDespues = pedirDatosPaciente(); // Solicitar datos del nuevo paciente
			        Lista.insertarDespcodigo(codigoDespues, nuevoPacienteDespues);
			        System.out.println("Paciente agregado después del paciente con código " + codigoDespues + " con éxito.");
			    } catch (NumberFormatException e) {
			        System.out.println("Error: El código debe ser un número válido.");
			    }
			    break;
			case 8:
				Lista.mostrarLista();
				break;
			case 9:
				Vista.SeeInfo("Saliendo del programa...");
				break;
			default:
				Vista.SeeInfo("Opcion incorrecta , ingrese nuevamente");

			}

		} while (option != 6);

	}
	
	private Paciente pedirDatosPaciente() {
	    int codigo = Vista.ReadInteger("Código único:");
	    String nombreApellidos = Vista.ReadString("Nombre y apellidos:");
	    String remitido = Vista.ReadString("Remitido:");
	    String dondeRemitido = Vista.ReadString("Donde remitido:");
	    String diagnostico = Vista.ReadString("Diagnóstico:");
	    String genero = Vista.ReadString("Género:");
	    String fechaIngreso = Vista.ReadString("Fecha de ingreso:");
	    String medicoTratante = Vista.ReadString("Médico tratante:");
	    return new Paciente(codigo, nombreApellidos, remitido, dondeRemitido, diagnostico, genero, fechaIngreso, medicoTratante);
	}

}
