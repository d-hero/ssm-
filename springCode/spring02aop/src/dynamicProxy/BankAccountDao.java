package dynamicProxy;

public class BankAccountDao implements IBankAccountDao {

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		System.out.println("这里进行转账");
	}

}
