package io;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * <p>
 * Clase estática para leer de teclado con comprobación de tipo de datos y
 * escribir en pantalla.
 * </p>
 * 
 * <p>
 * Los tipos de dato que maneja son:
 * </p>
 * 
 * <ul>
 * <li>Integer
 * <li>IntegerOrNull
 * <li>Double
 * <li>DoubleOrNull
 * <li>Character
 * <li>Byte
 * <li>Short
 * <li>Long
 * <li>Float
 * <li>Boolean (true, false)
 * <li>String (admite tira vacía)
 * <li>LocalDateOrNull (null si la fecha está vacía)
 * </ul>
 * 
 * @author Amadeo
 * @version 1.1
 * @since 2018-07-01
 */
public class IO {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Constructor
	 */
	IO() {
		sc.useDelimiter("\n");
	}

	/**
	 * Muestra un objeto
	 * 
	 * @param objeto
	 */
	static public void print(Object o) {
		System.out.print(o);
	}

	/**
	 * Muestra un objeto y salta de línea
	 * 
	 * @param objeto
	 */
	static public void println(Object o) {
		System.out.println(o);
	}

	/**
	 * Muestra objetos según un formato
	 * 
	 * @param objeto
	 */
	static public void printf(String format, Object... objects) {
		System.out.printf(format, objects);
	}

	/**
	 * Lee un valor de tipo byte
	 * 
	 * @return
	 */
	static public Byte readByte() {
		while (true) {
			try {
				return Byte.parseByte(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo byte ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo short
	 * 
	 * @return
	 */
	static public Short readShort() {
		while (true) {
			try {
				return Short.parseShort(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo short ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo int
	 * 
	 * @return
	 */
	static public Integer readInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
//				System.err.print("ERROR: No es de tipo int ? ");
				System.err.println("ERROR: Option invalida");
			}
		}
	}

	/**
	 * Lee un valor de tipo int
	 * 
	 * @return
	 */
	static public Integer readIntOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Integer.parseInt(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo int ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo long
	 * 
	 * @return
	 */
	static public Long readLong() {
		while (true) {
			try {
				return Long.parseLong(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo long ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo float
	 * 
	 * @return
	 */
	static public Float readFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo float ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo double
	 * 
	 * @return
	 */
	static public Double readDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo double ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo double
	 * 
	 * @return
	 */
	static public Double readDoubleOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				return Double.parseDouble(in);
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo double ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo LocalDate
	 * 
	 * @return
	 */
	static public LocalDate readLocalDateOrNull() {
		while (true) {
			try {
				String in = sc.nextLine();
				if (in.isBlank()) {
					return null;
				}
				String s[] = in.split("-");
				return LocalDate.of(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			} catch (Exception e) {
				System.err.print("ERROR: No es de tipo fecha (aaaa-mm-dd) ? ");
			}
		}
	}

	/**
	 * Lee un valor de tipo boolean
	 * 
	 * @return
	 */
	static public Boolean readBoolean() {
		while (true) {
			String s = sc.nextLine().toLowerCase();
			if (s.equals("true")) return true;
			if (s.equals("false")) return false;
			System.err.print("ERROR: No es de tipo boolean (true o false) ? ");
		}
	}

	/**
	 * Lee un valor de tipo char
	 * 
	 * @return
	 */
	static public Character readChar() {
		while (true) {
			String s = sc.nextLine();
			if (s.length() == 1) {
				return s.toCharArray()[0];
			}
			System.err.print("ERROR: No es de tipo char ? ");
		}
	}

	/**
	 * Lee un valor de tipo String
	 * 
	 * @return
	 */
	static public String readString() {
		return sc.nextLine();
	}

	/**
	 * Lee un valor de tipo String
	 * 
	 * @return
	 */
	static public String readStringMandatory() {
		while (true) {
			String s = sc.nextLine();
			if (!s.isBlank()) {
				return s;
			}
			System.err.print("ERROR: Esta vacío ? ");
		}
	}

}