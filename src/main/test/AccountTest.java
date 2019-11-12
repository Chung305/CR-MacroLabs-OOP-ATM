
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


// Test the expected Account class from ATM.
public class AccountTest {

    @Test
    public void testA0() {
        Account a = new Account(0.0);
        assertEquals(0.0, a.balance(), 0.0001);
    }

    @Test
    public void testA00() {
        Account a = new Account(10.0);
        assertEquals(10.0, a.balance(), 0.0001);
    }

    @Test
    public void testA01() {
        Account a = new Account(0.0);
        assertEquals(true, a.closeAccount());
    }

    @Test
    public void testA02() {
        Account a = new Account(10.0);
        assertEquals(false, a.closeAccount());
    }

    @Test
    public void testA1() {
        Account a = new Account(0.0);
        a.deposit(100.0);
        assertEquals(100.0, a.balance(), 0.0001);
    }

    @Test
    public void testA2() {
        Account a = new Account(10.0);
        a.deposit(100.0);
        assertEquals(110.0, a.balance(), 0.0001);
    }

    @Test
    public void testA3() {
        Account a = new Account(200.0);
        Double actual = a.withdraw(100.0);
        assertEquals(100.0, actual, 0.0001);
    }

    @Test
    public void testA4() {
        Account a = new Account(0.0);
        Double actual = a.withdraw(1.0);
        assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void testA5() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 10.0);
        assertEquals(0.0, a.balance(), 0.0001);
        assertEquals(10.0, b.balance(), 0.0001);
    }

    @Test
    public void testA6() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 100.0); // nothing should happen
        assertEquals(10.0, a.balance(), 0.0001);
        assertEquals(0.0, b.balance(), 0.0001);
    }

    @Test
    public void testBuildTransactionReport() {
        Account account = new Account(1000.00, 2);
        String actual = account.buildTransactionReport(1000.00, 800.00, 200.00, "withdraw");
        String expected = "Transaction: withdraw $200.00\n" +
                "\tOld Balance:\t$1000.00\n" +
                "\tNew Balance:\t$800.00";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddTransactionReportToTransactionHistory1() {
        Account account = new Account(1000.00, 2);
        String report = account.buildTransactionReport(1000.00, 800.00, 200.00, "withdraw");
        account.addTransactionReportToTransactionHistory(report);
        Integer actualSize = account.getTransactionHistory().size();
        Integer expectedSize = 1;
        Assert.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testAddTransactionReportToTransactionHistory2() {
        Account account = new Account(1000.00, 2);
        String report = account.buildTransactionReport(1000.00, 800.00, 200.00, "withdraw");
        account.addTransactionReportToTransactionHistory(report);
        String actual = account.getPrintableHistory();
        String expected = "Transaction History:\nTransaction: withdraw $200.00\n" +
                "\tOld Balance:\t$1000.00\n" +
                "\tNew Balance:\t$800.00";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetAccountId() {
        Account account = new Account(1000.00, 2);
        account.setAccountID(4);
        Integer actual = account.getAccountID();
        Integer expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetUserName() {
        Account account = new Account(1000.00, 2);
        account.setUserName("Wes");
        String actual = account.getUserName();
        String expected = "Wes";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAccountString() {
        Account account = new Checking(1000.00, 2);
        account.setUserName("Wes");
        String actual = account.getAccountString();
        String expected = "2 Checking Wes";
        Assert.assertEquals(expected, actual);
    }


}
