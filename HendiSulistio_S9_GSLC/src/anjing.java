import java.util.Random;

public class anjing extends randomed{
	Random rand = new Random();
	
	String hasilrand;
	public anjing() {
		
	}

	@Override
	public String render() {
		hasilrand = "TXA" + rand.nextInt(9) + rand.nextInt(9) + rand.nextInt(9) + 
				rand.nextInt(9) + rand.nextInt(8)+1;
		
		return hasilrand;	
	}

}
