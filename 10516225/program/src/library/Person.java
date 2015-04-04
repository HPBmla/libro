package library;

public interface Person {
	public static final String fname = null;
	public static final String lname = null;
	public static final String address = null;
	public static final int tel = 0;
	public static final int NIC = 0;
	public abstract void  log(String name,String pass);
   public abstract void searchBook(String bkName);
    public abstract int signUp(String fnme,String lnme,String addOne,String addTwo,String addThree,String telNum,String nic,String usernm,String passwrd);

}
