package Bank.model;

public class Bank {
	private int id;
	private String name;
	private long accNo;
	private double balance;
	private int amount;
	private long fromAccNo;
	private long toAccNo;

	public Bank(int id, String name, long accNo, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.accNo = accNo;
		this.balance = balance;
	}

	public Bank(String name, long accNo, double balance) {
		super();
		this.name = name;
		this.accNo = accNo;
		this.balance = balance;
	}

	public Bank(long accNo, double balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}

	public Bank(long accNo, int amount) {
		super();
		this.accNo = accNo;
		this.amount = amount;
	}

	public Bank(long fromAccNo, long toAccNo, int amount) {
		super();
		this.fromAccNo = fromAccNo;
		this.toAccNo = toAccNo;
		this.amount = amount;
	}

	public long getFromAccNo() {
		return fromAccNo;
	}

	public void setFromAccNo(long fromAccNo) {
		this.fromAccNo = fromAccNo;
	}

	public long getToAccNo() {
		return toAccNo;
	}

	public void setToAccNo(long toAccNo) {
		this.toAccNo = toAccNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Bank() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + accNo + "\t" + balance;
	}

}
