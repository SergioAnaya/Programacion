package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		Parray miArray = new Parray(new int[] {1, 5, 7, 2});
		Main.mostrarParray(miArray);
		Main.mostrarArray(miArray.array_reverse());
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] diff = miArray.array_diff(array);
		Main.mostrarArray(diff);
		miArray.array_fill(2, 2, 3);
		Main.mostrarParray(miArray);

	}

	public static void mostrarParray(Parray parray){
		for (int i = 0; i < parray.count(); i++){
			System.out.printf("Index: %s -- Value: %s\n", i, parray.getIndex(i));
		}
		System.out.println();
	}

	public static void mostrarArray(int[] array){
		for (int i = 0; i < array.length; i++){
			System.out.printf("Index: %s -- Value: %s\n", i, array[i]);
		}
		System.out.println();
	}
}
