package pl.ug.mo;

public abstract class ConstantsContainer {

	//y(1) = 3
	public static double X0 = 1; //X0 wynikajace z zalozen i podanych danych
	public static double Y0 = 3; //Y0 wynikajace z zalozen i podanych danych
	public static double b = 2;  //b wynikajace z przedzialu zadania [1,2]
	
	//Funkcja f - tutaj mozna ja zmienic
	public static double f(double x, double y) {
		return 2*Math.sqrt(y-(2*x))+2;
	}
}
