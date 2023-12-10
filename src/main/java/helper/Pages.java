package helper;

public class Pages {
    private static final String Prefix = "file:///" + System.getProperty("user.dir")+"\\src\\web\\";

    public static String home(){
         final String HOME = Prefix + "index.html";
        return HOME;
    }
    public static String loans(){
        final String LOANS = Prefix + "loans.html";
        return LOANS;
    }

    public static String savings(){
        final String SAVINGS = Prefix + "savings.html";
        return SAVINGS;
    }
}
