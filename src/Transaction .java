import lombok.Data;

/**
 * 交易类
 **/
@Data
public class Transaction {

	private Trader trade;
	private int year;
	private int value;

	public Transaction(){

	}

	public Transaction(Trader trade, int year, int value){
		this.trade = trade;
		this.year = year;
		this.value = value;
	}
}
