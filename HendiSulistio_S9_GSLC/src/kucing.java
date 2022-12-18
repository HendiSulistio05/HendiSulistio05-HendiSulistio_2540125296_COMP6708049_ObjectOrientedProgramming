import java.util.Random;

public class kucing extends randomed{
	Random rand = new Random();
	
	String hasilrand;
	
	public kucing() {

	}
	

	@Override
	public String render() {
		// TODO Auto-generated method stub
		hasilrand = "TXK" + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9) + 
				rand.nextInt(9) + rand.nextInt(8)+1;
		
		return hasilrand;		
	}
	
}
