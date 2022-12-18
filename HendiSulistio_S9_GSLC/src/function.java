
public class function {

	public int counting(int berat, String type){
		int hasil = 0;
		if(type.matches("anjing")) {
			//anjing kecil
			if(berat < 5) {
				hasil = 50000;
			}
			else if(berat < 15) {
				hasil = 75000;
			}
			else if(berat < 25){
				hasil = 150000;
			}
			else {
				hasil = 250000;
			}
		}
		else {
			if(berat < 2) {
				hasil = 50000;
			}
			else if(berat < 5) {
				hasil = 80000;
			}
			else if(berat < 8) {
				hasil = 130000;
			}
			else if(berat < 15) {
				hasil = 200000;
			}
			else {
				hasil = 250000;
			}
		}
		return hasil;
	}

	
	public int kembalian(int uang, int harga) {
		int come = 0;
		come = uang - harga;
		return come; 
	}
	
	

}
