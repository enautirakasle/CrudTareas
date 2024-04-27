package utils;

import modelo.Dificultad;
import modelo.Tarea;

public class FormValidador {
	public static boolean tareaValida(Tarea tarea) {
		if(tarea.getTitulo().isBlank()
				|| tarea.getTitulo() == null) {
			return false;
			
		}
		return true;
	}
	
	public static boolean dificultadValida(Dificultad dificultad) {
		if(dificultad.getNombre().isBlank()
				|| dificultad.getNombre() == null) {
			return false;
			
		}
		return true;
	}
}
