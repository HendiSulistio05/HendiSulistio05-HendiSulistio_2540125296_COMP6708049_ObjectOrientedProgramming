/* Aplikasi Perawatan Anjing dan Kucing
 * Aplikasi ini hanya menyediakan mandi kucing dan anjing
 */
import java.util.Scanner;

public class Main {
	SubMenu pil = new SubMenu(); 
	
	Scanner scan = new Scanner(System.in);

	public Main() {
		// TODO Auto-generated constructor stub
		Menu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	private void Menu() {
		int t;
		while(true) {
			System.out.println("================");
			System.out.println("|     MENU     |");
			System.out.println("================");
			
			System.out.println("1. Order");
			System.out.println("2. Selesai");
			System.out.println("3. Lihat Antrian");
			System.out.println("4. Riwayat");
			System.out.println("5. Exit");
			System.out.print("Choose [1-5]: ");
			t = scan.nextInt();
			//Agar '\0' tidak masuk ke sacnner selanjutnya
			scan.nextLine(); 
			
			//Jika t=5 maka aplikasi langsung berhenti
			if(t == 5) return; 
			
			//untuk memasukkan ke subMenu
			switch(t) {
			case 1:
				pil.Input();
				break;
				
			case 2:
				pil.Selesai();
				break;
				
			case 3:
				pil.View();
				break;
				
			case 4:
				pil.History();
				break;
				
				
			}
		}
	}

}
