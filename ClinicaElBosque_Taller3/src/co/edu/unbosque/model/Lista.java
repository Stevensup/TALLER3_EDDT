package co.edu.unbosque.model;

public class Lista {
	Node cabeza;
	int cantElementos;

	public Lista() {

		cabeza = null;
		cantElementos = 0;
	}
	
	 public void agregarPaciente(Paciente paciente) {
	        Node nuevoNodo = new Node(paciente, cabeza);
	        cabeza = nuevoNodo;
	    }
	 public void agregarPacientePrioritario(Paciente paciente) {
	        Node nuevoNodo = new Node(paciente, cabeza);
	        cabeza = nuevoNodo;
	    }
	 
	public Lista insertarxcabeza(Paciente x) {
		Node nuevo = new Node(x);
		nuevo.siguiente = cabeza;
		cabeza = nuevo;
		return this;
	}

	public Lista insertarxcola(Paciente x) {

		Node nuevo = new Node(x);
		if (cabeza == null) {

			cabeza = nuevo;
		} else {

			Node actual = cabeza;
			while (actual.siguiente != null) {
				actual = actual.siguiente;

			}
			actual.siguiente = nuevo;
		}

		return this;

	}

	public Lista insertarDespcodigo(int codigo, Paciente x) {
	    Node nuevo = new Node(x);

	    if (cabeza == null) {
	        cabeza = nuevo;
	        return this;
	    }

	    Node actual = cabeza;
	    while (actual != null) {
	        if (actual.dato.getCodigoUnico() == codigo) {
	            nuevo.siguiente = actual.siguiente;
	            actual.siguiente = nuevo;
	            return this;
	        }
	        actual = actual.siguiente;
	    }

	    return this;
	}

	public Lista insertarAntescodigo(int codigo, Paciente x) {
	    Node nuevo = new Node(x);
	    if (cabeza == null) {
	        cabeza = nuevo;
	        return this;
	    }

	    if (cabeza.dato.getCodigoUnico() == codigo) {
	        nuevo.siguiente = cabeza;
	        cabeza = nuevo;
	        return this;
	    }

	    Node actual = cabeza;
	    while (actual.siguiente != null) {
	        if (actual.siguiente.dato.getCodigoUnico() == codigo) {
	            nuevo.siguiente = actual.siguiente;
	            actual.siguiente = nuevo;
	            return this;
	        }
	        actual = actual.siguiente;
	    }

	    return this;
	}


	public Node buscar(int cod) {
	    for (Node indice = cabeza; indice != null; indice = indice.siguiente) {
	        if (cod == indice.dato.getCodigoUnico()) {
	            System.out.println(indice.dato.toString());
	            return indice; 
	        }
	    }
	    return null; 
	}


	public boolean eliminarporcodigo(int cod) {
	    Node anterior = null;
	    Node actual = cabeza;

	    while (actual != null) {
	        if (actual.dato.getCodigoUnico() == cod) {
	            if (anterior == null) {
	                // Si el paciente a eliminar es el primero en la lista
	                cabeza = actual.siguiente;
	            } else {
	                // Si el paciente a eliminar no es el primero en la lista
	                anterior.siguiente = actual.siguiente;
	            }
	            return true; // Se ha eliminado el paciente
	        } else {
	            anterior = actual;
	            actual = actual.siguiente;
	        }
	    }
	    
	    return false; // No se encontró un paciente con el código especificado
	}


	public void editarPaciente(int codigo, Paciente nuevoPaciente) {
		Node actual = cabeza;

		while (actual != null) {
			if (actual.dato.getCodigoUnico() == codigo) {

				actual.dato = nuevoPaciente;

				return;
			}
			actual = actual.siguiente;
		}

		System.out.println("Paciente con código " + codigo + " no encontrado.");
	}

	public void mostrarLista() {
		Node actual = cabeza;

		while (actual != null) {
			System.out.println(actual.dato.toString());
			actual = actual.siguiente;
		}
	}

}
