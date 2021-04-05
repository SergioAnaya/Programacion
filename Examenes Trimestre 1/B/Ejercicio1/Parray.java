package Ejercicio1;

import java.nio.charset.IllegalCharsetNameException;

/**
 * Clase Parray que complementa el array nativo de java
 * @author Basilio David Gómez Fernándezç
 * @version 1.0
 */
public class Parray {
	private final static IllegalArgumentException BAD_INDEX = new IllegalCharsetNameException("El index tiene que ser" +
			"mayor que 0 y menor que la longitud del array");

	private int[] array;

	/**
	 * Constructor que inicializa el array con un tamaño
	 * @param tamano Tamaño del array que queremos incializar
	 */
	public Parray(int tamano){
		this.array = new int[tamano];
	}

	/**
	 * Constructor que dado un array copia todos sus datos
	 * @param arrayCopiar Array al que queremos realizar una copia
	 */
	public Parray(int[] arrayCopiar){
		this.array = arrayCopiar;
	}

	/**
	 * Metodo count que devuelve la longitud del array
	 * @return La longitud del array
	 */
	public int count(){
		return this.array.length;
	}

	/**
	 * Metodo que dado un indice devuelve el valor aosciado
	 * @param indice Indice del cual queremos obtener el valor del array
	 * @return valor del array sobre el indice
	 */
	public int getIndex(int indice){
		this.index_valid(indice);
		return this.array[indice];
	}

	/**
	 * Metodo donde introducimos en el indice especificado el valor dado por parametros
	 * @param indice Indice donde se va a comprobar introducir el valor
	 * @param valor Valor que queremos añadir
	 */
	public void setIndex(int indice, int valor){
		this.index_valid(indice);
		this.array[indice] = valor;
	}

	/**
	 * Metodo que dado un valor busca si existe y devuelve un booleano
	 * @param needle Valor del que queremos saber si existe en el array al menos una vez
	 * @return true si el valor existe en el array y false si no lo hace
	 */
	public boolean in_array(int needle){
		for (int actual_value: this.array){
			if (actual_value == needle)
				return true;
		}
		return false;
	}

	/**
	 * Metodo donde introducimos a partir de un indice tantos valores como sea indicado
	 * @param start_index Indice por donde empezamos a añadir los valores
	 * @param num Cantidad de veces que queremos añadir el valor
	 * @param value valor que queremos añadir
	 */
	public void array_fill(int start_index, int num, int value){
		this.index_valid(start_index);
		this.times_to_add_valid(start_index, num);
		for (int index = start_index; index < start_index + num; index++){
			this.setIndex(index, value);
		}
	}

	/**
	 * Metodo auxiliar que comprueba si el indice dado está dentro del array
	 * @param index Indice a conprobar si está dentro del array
	 */
	private void index_valid(int index){
		if (index < 0 || index > this.count() - 1)
			throw BAD_INDEX;
	}

	/**
	 * Metodo auxiliar que revisa si se pueden añadir la cantidad de valores especificado
	 * empezando por la posicion especificada
	 * @param start_index Indice donde empezamos a añadir valores
	 * @param times_value_to_add veces que vamos a añadir el valor
	 */
	private void times_to_add_valid(int start_index, int times_value_to_add){
		final IllegalArgumentException BAD_TIMES_TO_ADD = new IllegalCharsetNameException("La cantidad de " +
				"valores que vas a añadir a tu array no puede ser superior a la diferencia entre el indice" +
				" de inicio y la longitud del array");

		if (times_value_to_add + start_index > this.count())
			throw  BAD_TIMES_TO_ADD;
	}


	/**
	 * Metodo un array con los valores invertidos respecto a nuestro parray
	 * @return Array invertido
	 */
	public int[] array_reverse(){
		int[] array_invertido = new int[this.count()];
		int indice_anadir;
		for (int indice = this.count() - 1; indice >= 0; indice--){
			indice_anadir = Math.abs(indice - (this.count() - 1));
			array_invertido[indice_anadir] = this.getIndex(indice);
		}
		return array_invertido;
	}

	/**
	 * Metodo que dado un array devuelve otro array con todos los valores que no coincidan con nuestro Parray
	 * @param arrayParam Array con el que vamos a comparar nuestro parray
	 * @return Array con los valores que no coinciden con nuestro parray
	 */
	public int[] array_diff(int[] arrayParam){
		int[] array_auxiliar = new int[arrayParam.length];
		int index_using_array_auxiliar = 0;
		for (int value: arrayParam){
			if (!(this.in_array(value))){
				array_auxiliar[index_using_array_auxiliar] = value;
				index_using_array_auxiliar++;
			}
		}
		return this.array_beautifier(array_auxiliar, index_using_array_auxiliar);
	}

	/**
	 * Metodo auxiliar que dado un array y su indice de llenado devuelve un array sin valores nulos
	 * @param array_to_beautifier Array al que queremos eliminar los valores nulos
	 * @param fulled indice de llenado del array
	 * @return array sin valores nulos
	 */
	private int[] array_beautifier(int[] array_to_beautifier, int fulled){
		int[] array_retornar = new int[fulled];
		for (int i = 0; i < fulled; i++){
			array_retornar[i] = array_to_beautifier[i];
		}
		return array_retornar;
	}

}
