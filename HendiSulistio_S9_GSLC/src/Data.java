
public class Data implements datainterface {
	private String nama;
	private int berat;
	private String type;
	private String des;
	private String call;
	private int harga;
	private int uang;
	private int kembalian;
	private String status;
	
	private String tgl;
	private String waktu;
	
	private String tx;
	
	public Data(String nama, int berat, String type, String des, String call, int harga, int uang, int kembalian,
		String tgl, String waktu, String status, String tx) {
		this.nama = nama;
		this.berat = berat;
		this.type = type;
		this.des = des;
		this.call = call;
		this.harga = harga;
		this.uang = uang;
		this.kembalian = kembalian;
		this.tgl = tgl;
		this.waktu = waktu;
		this.status = status;
		this.tx = tx;
	}
	
	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getBerat() {
		return berat;
	}

	public void setBerat(int berat) {
		this.berat = berat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getUang() {
		return uang;
	}

	public void setUang(int uang) {
		this.uang = uang;
	}

	public int getKembalian() {
		return kembalian;
	}

	public void setKembalian(int kembalian) {
		this.kembalian = kembalian;
	}

	public String getTgl() {
		return tgl;
	}

	public void setTgl(String tgl) {
		this.tgl = tgl;
	}

	public String getWaktu() {
		return waktu;
	}

	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}
	
	
	
	

}
