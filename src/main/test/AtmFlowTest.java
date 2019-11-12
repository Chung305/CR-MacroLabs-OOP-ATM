//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//public class AtmFlowTest {
//    @Test
//    public void start() {
//        //dispatches to mainMenu()
//    }
//
//    @Test
//    public void mainMenu() {
//        // dispatches to logIn(), createAccount(), System.exit(0), start()
//    }
//
//    @Test
//    public void logIn() {
//        // dispatches to accountStart(), start()
//    }
//
//    @Test
//    public void accountStart() {
//        // dispatches to accountMenu()
//    }
//
//    @Test
//    public void accountMenu() {
//        // dispatches to createBankAccount(), withdraw(), deposit(),
//        // transfer(), closeAccount(), start(), System.exit(0), showTransactions()
//    }
//
//    @Test
//    public void showTransactions() {
//        AtmFlow flow = new AtmFlow();
//        User user = flow.userVillage.createUser("wes", "wes");
////        flow.c
//
//    }
//
//    @Test
//    public void createAccount() {
//    }
//
//    @Test
//    public void testCreateBankAccount() {
//        AtmFlow flow = new AtmFlow();
//        User user = flow.userVillage.createUser("wes", "wes");
//        setUserInput("1000.00\n1");
////        setUserInput("1");
//        String actual = flow.createBankAccount(user.getUserName());
//        String expected = "1 Checking wes";
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void withdraw() {
//    }
//
//    @Test
//    public void deposit() {
//    }
//
//    @Test
//    public void transfer() {
//    }
//
//    @Test
//    public void promptNewBalance() {
//    }
//
//    @Test
//    public void accountPrompt() {
//    }
//
//    @Test
//    public void targetAccount() {
//    }
//
//    @Test
//    public void buildAccountSelectionList() {
//    }
//
//    @Test
//    public void closeAccount() {
//    }
//
//    public void setUserInput(String input) {
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//    }
//}
