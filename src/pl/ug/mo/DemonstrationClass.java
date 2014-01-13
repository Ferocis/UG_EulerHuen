package pl.ug.mo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DemonstrationClass {

	//*****************************************************************************************
	//Jeste Kamilke, tu jest Euler gotowy, razem z zabezpieczeniami, jakie mi przyszly do glowy
	//ponownym wczytywaniem N i chyba wszystkim, co ma byc. Ty musisz tu dopisac Huena
	//Wyniki dzialania Eulera sa w tablicy ynEuler[0...N], mo¿esz sobie je stamtad wziac do
	//Hujena. Zaznaczylem Ci nizej w kodzie gdzie imo powinny byc wszystkie Twoje obliczenia
	//zrobione, nie widze powodu, zeby wciskac je gdzie indziej. Jak bedziesz potrzebowal zmienne
	//tylko na uzytek Huena to dopisz sobie tutaj, tak jak ja do Eulera. Tam gdzie mozna, korzystaj
	//ze zmiennych wspolnych dla calego programu (nie potrzeba Ci np. deklarowac drugiej dlugosci
	//kroku, zwroc tez uwage, ze funkcja i dane z zalozen sa w klasie ConstantsContainer). 
	//Ja zrobilem ju¿ linie wypisujaca wynik, potem tylko w miejsce gdzie dla Huena na 
	//sztywno wypisuje 0 wstaw swoja tablice czy w czym tam umiescisz wyniki. Uzywaj doubli, wynik
	//sformatuj przy pomocy format.format (tak jak ja, zobaczysz w moim kodzie jak przejrzysz).
	//Na razie nie ma jeszcze wyliczenia bledu, bo mi sie juz nie chce. Potem to dopisze jak bedzie
	//Huen. Also protip: projekt jest na githubie, wiec commitujesz tu zmiany, i tak musisz w 
	//koncu ogarnac GitHuba na zespolowy. Pozdrawiam serdecznie z XVIII wieku, Caryca Katarzyna II
	//Wielka, pierwsza programistka telefonow komorkowych, ale Ty i tak znasz ja tylko z tego, ze
	//zabila papieza Georga Busha.
	//*******************************************************************************************
	
	//Zmienne programu (Euler i Huen)
	static double dlKroku;
	static double N;
	static int wynikDla;
	static DecimalFormat format = new DecimalFormat("#.####");
	static String odp = "";
	static boolean again = false;
	
	//Zmienne dla programu (Euler)
	static double[] xnEuler;
	static double[] ynEuler;
	
	//Zmienna dla programu (Huen)
	static double[] ynHuen;
	
	
	//Zmienne do wczytywania z klawiatury
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String [ ] args) {
		
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Metody Obliczeniowe");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Mis Maciej");
		System.out.println("Skarzynski Lukasz");
		System.out.println("Szynkaruk Kamil");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Metody Eulera i Huena.");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Dane z ktorymi dziala program:");
		System.out.println("Funkcja: 2*sqrt(y-(2*x))+2;");
		System.out.println("Przedzial: [1, 2]");
		System.out.println("y(1) = 3");
		System.out.println();
		
		while(true) {
			
			N = 0;
			while(N<1) {
				System.out.print("Podaj N (minimalnie 1): ");
				N = scanner.nextDouble();
			}
			
			//Wyliczamy dlugosc kroku
			dlKroku = (ConstantsContainer.b - ConstantsContainer.X0)/N;
			
			//Ustalamy liste xn przy podanym N
			xnEuler = new double[(int) N];
			for(int i=0; i<N; i++) xnEuler[i] = ConstantsContainer.X0 + i*dlKroku;
			
			//Obliczamy kolejne yn
			ynEuler = new double[(int) N+1];
			ynEuler[0] = 3;
			for(int i=1; i<=N; i++) {
				ynEuler[i] = ynEuler[i-1] + dlKroku * ConstantsContainer.f(xnEuler[i-1], ynEuler[i-1]);
			}
			
			
			// poczatek w chuj skomplikowanego i zajebiscie dlugiego kodu
			ynHuen = new double[(int) N+1];
			ynHuen[0] = 3;
				for(int i = 1; i <= N; i++){
					ynHuen[i] = ynHuen[i - 1] + dlKroku * 	
							 (ConstantsContainer.f(xnEuler[i - 1], ynHuen[i - 1]) +
									 ConstantsContainer.f(ConstantsContainer.X0 + i*dlKroku, ynEuler[i])
											/ 2);
				}
			// koniec w chuj skomplikowanego i zajebiscie dlugiego kodu
			
			
			//Wypisuje wybrany wynik
			while(true) {
				System.out.print("Obliczenia zakonczone. Dla jakiego n chcesz zobaczyc wynik? [-1 aby kontynuowac]: ");
				wynikDla = scanner.nextInt();
				if(wynikDla == -1) break;
				else if(wynikDla < -1 || wynikDla > N) {
					System.out.println("Nie istnieje taki wynik.");
					continue;
				}
				System.out.println("n\tEuler\tHuen\tBlad Eulera\tBlad Huena");
				System.out.println(wynikDla + "\t" + format.format(ynEuler[wynikDla]) + "\t" + format.format(ynHuen[wynikDla]) + "\t" + format.format(ynEuler[wynikDla] - ConstantsContainer.f2(xnEuler[wynikDla - 1])) + "\t\t" + format.format(ynHuen[wynikDla] - ConstantsContainer.f2(xnEuler[wynikDla - 1])));
			}
			
			odp = scanner.nextLine(); //Zostawic to tu, nie zastanawiac sie, po co, ma byc, bo tak mowi Konio.
			while(!odp.equals("t") && !odp.equals("n")) {
				System.out.print("Czy powtorzyc obliczenia dla innego N? [t/n]: ");
				odp = scanner.nextLine();
				if(odp.equals("t")) again = true;
				else if(odp.equals("n")) again = false;
			}
			
			odp = "";
			if(!again) break;
		}
	}
	
}
