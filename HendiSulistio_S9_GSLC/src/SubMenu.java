import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SubMenu {
	function func = new function();
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Data> data = new ArrayList<>();
	ArrayList<DHis> his = new ArrayList<>();
	
	GregorianCalendar date = new GregorianCalendar();
    String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
	
	kucing kucing = new kucing();
	anjing anjing = new anjing();
    
    int p=0;
    public void Input() {
		String nama; //Nama Pemesan
		int berat; //Berat anjing atau Kucing
		String type; //Jenis anjing atau kucing
		String des; //Catatan Penting untuk pekerja
		String call; //Nomor telepon customer
		
		int harga;
		int uang;
		int kembalian;
		
		//Input nama tidak boleh kosong, awalan tidak berupa angka, dan juga tidak full angka
		System.out.println("Data Customer");
		System.out.println("-------------\n");
		do {
			System.out.print("Nama Customer          :");
			nama = scan.nextLine();
		}while(nama.matches("[0-9]*") || nama.isBlank());
		
		//Input nomor telepon wajib angka dan tidak boleh kosong
		do {
			System.out.print("Nomor Telepon Customer :");
			call = scan.nextLine();
		}while(!call.matches("[0-9]*") || call.isBlank() || call.length()>15);
		
		System.out.println("\nData Hewan");
		System.out.println("-----------\n");
		
		//Input type hewan (case sensitive)
		do {
			System.out.print("Type Hewan [anjing | kucing](case sensitive) :");
			type = scan.nextLine();
		}while(!type.matches("anjing") && !type.matches("kucing"));
		
		do {
			System.out.print("Berat Hewan [dalam Kg](bilangan bulat) : ");
			berat = scan.nextInt();
			scan.nextLine();
		}while(berat<0);
		
		System.out.println("Deskripsi Hewan(Optional): ");
		des = scan.nextLine();
	
		harga = func.counting(berat, type);		
		
		System.out.println("-----------");
		System.out.println("   HARGA   ");
		System.out.println("-----------");
		System.out.printf("Harga     : Rp%d\n", harga);
		
		//persetujuan
		String s;
		do {
			System.out.print("Persetujuan [Y | T] : ");
			s = scan.nextLine();
		}while(!(s.matches("Y") || s.matches("T")) || s.isBlank());
		
		if(s.matches("T")) return;
		
		System.out.println("---------------------");
		System.out.println("     PEMBAYARAN     ");
		System.out.println("---------------------");
		do {
			System.out.printf("Jumlah Uang  <=%d : Rp", harga);
			uang = scan.nextInt(); scan.nextLine();
		}while(uang<harga);
		
		kembalian = func.kembalian(uang, harga);
		System.out.printf("Kembalian anda   : Rp%d\n", kembalian);
		
		String tgl = date.get(Calendar.DAY_OF_MONTH) + " " + namabulan[date.get(Calendar.MONTH)] + " " + date.get(Calendar.YEAR) ;
		String waktu = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
		
		System.out.printf ("Order anda terdata pada %s pukul %s\n",tgl, waktu);
		
		System.out.println("Press Enter to Continue");
		scan.nextLine();
		
		String tx = "-";
		if(type.matches("anjing")) tx = anjing.render();
		else if (type.matches("kucing")) tx= kucing.render();
		
		Data data1 = new Data(nama, berat, type, des, call, harga, uang, kembalian, tgl, waktu, "Dalam Antrian", tx);
		data.add(data1);
		
		DHis his1 = new DHis(nama, berat, type, des, call, harga, uang, kembalian, tgl, waktu, "Dalam Antrian", "-", "-", tx);
		his.add(his1);
	}
	
	public void Selesai() {
		
		if(data.isEmpty()) {
			System.out.println("No Data!\n");
			System.out.println("Press Enter to Continue");
			scan.nextLine();
			return;
		}
		
		String tgl = date.get(Calendar.DAY_OF_MONTH) + " " + namabulan[date.get(Calendar.MONTH)] + " " + date.get(Calendar.YEAR) ;
		String waktu = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);

		
		System.out.printf("%s dengan nama %s telah selesai pada %s %s\n",data.get(0).getTx() ,data.get(0).getNama()
				, tgl, waktu);
		
		data.remove(0);
		
		his.get(p).setTgl1(tgl);
		his.get(p).setWaktu1(waktu);
		his.get(p).setStatus("Selesai");
		p = p+1;
		
		
		
		System.out.println("\nPress Enter to Continue");
		scan.nextLine();
		
	}
	
	public void View() {
		
		if(data.isEmpty()) {
			System.out.println("NO Data!\n");
			System.out.println("Press Enter to Continue");
			scan.nextLine();
			return;
		}
		
		System.out.println("LIHAT ANTRIAN");
		System.out.println("-------------\n");
		
		System.out.println("DALAM PROSES");
		System.out.printf("TRANSACTION ID %s\n", data.get(0).getTx());
		System.out.printf("Nama          : %s\n", data.get(0).getNama());
		System.out.printf("Nomor Telepon : %s\n", data.get(0).getCall());
		System.out.printf("Jenis Hewan   : %s\n", data.get(0).getType());
		System.out.printf("Berat Hewan   : %d kg\n\n", data.get(0).getBerat());		
		
		for(int i=1; i<data.size(); i++) {
			System.out.printf("%d Antrian Lagi\n", i);
			System.out.printf("TRANSACTION ID %s\n", data.get(i).getTx());
			System.out.printf("Nama          : %s\n", data.get(i).getNama());
			System.out.printf("Nomor Telepon : %s\n", data.get(i).getCall());
			System.out.printf("Jenis Hewan   : %s\n", data.get(i).getType());
			System.out.printf("Berat Hewan   : %d kg\n\n", data.get(i).getBerat());
			
		}
		System.out.println("Press Enter to Continue");
		scan.nextLine();
		
	}

	public void History() {
		System.out.println("LIHAT RIWAYAT");
		System.out.println("-------------");
		
		if(his.isEmpty()) {
			System.out.println("NO Data!\n");
			System.out.println("Press ENter to Continue");
			scan.nextLine();
			return;
		}	
		
		for(int i=0; i<his.size(); i++) { 
			System.out.printf("TRANSACTION ID %s\n", his.get(i).getTx());
			System.out.printf("Status           : %s\n", his.get(i).getStatus());
			System.out.printf("Nama             : %s\n", his.get(i).getNama());
			System.out.printf("Nomor Telepon    : %s\n", his.get(i).getCall());
			System.out.printf("Jenis Hewan      : %s\n", his.get(i).getType());
			System.out.printf("Berat Hewan      : %d kg\n", his.get(i).getBerat());
			System.out.printf("Deskripsi        : %s\n", his.get(i).getDes());
			System.out.printf("Harga            : %d\n", his.get(i).getHarga());
			System.out.printf("Jumlah Uang      : %d\n", his.get(i).getUang());
			System.out.printf("Jumlah Kembalian : %d\n", his.get(i).getKembalian());
			
			System.out.printf("Tanggal & Waktu Order   : %s pukul %s\n", his.get(i).getTgl(), his.get(i).getWaktu());
			System.out.printf("Tanggal & Waktu Selesai : %s pukul %s\n\n", his.get(i).getTgl1(), his.get(i).getWaktu1());
			
			
		}	
		
		System.out.println("Press Enter to Continue");
		scan.nextLine();
		
	}
}
