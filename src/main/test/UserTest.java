import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void userContructorTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        Assert.assertEquals(id, user.getUserID());
        Assert.assertEquals(username, user.getUserName());
        Assert.assertEquals(password, user.getPassword());
    }

    @Test
    public void getUserIdTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        Integer expected = 2;
        user.setUserID(expected);

        Assert.assertEquals(expected, user.getUserID());
    }
    @Test
    public void getUsernameTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        String expected = "Chungsing";
        user.setUserName(expected);

        Assert.assertEquals(expected, user.getUserName());
    }
    @Test
    public void getPasswordTest(){
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);

        String expected = "expectedPassword";
        user.setPassword(expected);

        Assert.assertEquals(expected, user.getPassword());
    }

    @Test
    public void testAddingAccount1() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(5);
        ArrayList<Integer> actual = user.getAccountsIds();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(5);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testAddingAccount2() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        Boolean success = user.addingAccount(1);
        Assert.assertTrue(success);
    }

    @Test
    public void testRemoveAccount1() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(4);
        user.addingAccount(8);
        Integer before = user.getAccountsIds().size();
        user.removeAccount(4);
        Integer after = user.getAccountsIds().size();
        Assert.assertNotEquals(before, after);
    }
    @Test
    public void testRemoveAccount2() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(4);
        user.addingAccount(8);
        Integer before = user.getAccountsIds().size();
        user.removeAccount(3);
        Integer after = user.getAccountsIds().size();
        Assert.assertEquals(before, after);
    }

    @Test
    public void testCheckIfUserHasAccount1() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(4);
        Boolean actual = user.checkIfUserHasAccount(4);
        Assert.assertTrue(actual);
    }
    @Test
    public void testCheckIfUserHasAccount2() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(4);
        Boolean actual = user.checkIfUserHasAccount(6);
        Assert.assertFalse(actual);
    }

    @Test
    public void testGetAccountsIds() {
        Integer id = 0;
        String username = "Chung";
        String password = "chung";
        User user = new User(id, username, password);
        user.addingAccount(1);
        user.addingAccount(4);
        Integer actual = user.getAccountsIds().size();
        Assert.assertEquals((Integer) 2, actual);
    }



}
