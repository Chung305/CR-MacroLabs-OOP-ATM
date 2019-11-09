import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UserTest {
    @Test
    public void constructorTest1(){
        Integer expectedUserID = 1;
        String expectedUserName = "Bobby1";
        String expectedPassword = "pw123";
        User user = new User(1, "Bobby1", "pw123");
        Integer actualUserID = user.getUserID();
        String actualUserName =  user.getUserName();
        String actualPassword = user.getPassword();

        Assert.assertEquals(expectedUserID, actualUserID);
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void constructorTest2(){
        Integer expectedUserID = 2;
        String expectedUserName = "Kip1";
        String expectedPassword = "pw123?";
        User user = new User(2, "Kip1", "pw123?");
        Integer actualUserID = user.getUserID();
        String actualUserName =  user.getUserName();
        String actualPassword = user.getPassword();

        Assert.assertEquals(expectedUserID, actualUserID);
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void constructorTest3(){
        Integer expectedUserID = 3;
        String expectedUserName = "Roland";
        String expectedPassword = "password123";
        User user = new User(3, "Roland", "password123");
        Integer actualUserID = user.getUserID();
        String actualUserName =  user.getUserName();
        String actualPassword = user.getPassword();

        Assert.assertEquals(expectedUserID, actualUserID);
        Assert.assertEquals(expectedUserName, actualUserName);
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void getUserIDTest1(){
        User user = new User(5, null, null);
        Integer expected = 5;
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserIDTest2(){
        User user = new User(8, null, null);
        Integer expected = 8;
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserIDTest3(){
        User user = new User(7, null, null);
        Integer expected = 7;
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserNameTest1(){
        User user = new User(3, "Hannah1", null);
        String expected = "Hannah1";
        String actual = user.getUserName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserNameTest2(){
        User user = new User(3, "Bobby6", null);
        user.setUserName("Bobby");
        String expected = "Bobby";
        String actual = user.getUserName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getUserNameTest3(){
        User user = new User(3, "Kai4", null);
        String expected = "Kai4";
        String actual = user.getUserName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPasswordTest1(){
        User user = new User(null, null, "oranges");
        String expected = "oranges";
        String actual = user.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPasswordTest2(){
        User user = new User(null, null, "Bl00p!");
        String expected = "Bl00p!";
        String actual = user.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPasswordTest3(){
        User user = new User(null, null, "GreenBois");
        String expected = "GreenBois";
        String actual = user.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addingAccountTest1(){
        User user = new User(null, null, null);
        ArrayList<Integer> accountsIds = new ArrayList<Integer>();
        Boolean actual = user.addingAccount(1);
        Assert.assertTrue("Checking", actual);
    }
    @Test
    public void addingAccountTest2(){
        User user = new User(null, null, null);
        ArrayList<Integer> accountsIds = new ArrayList<Integer>();
        Boolean actual = user.addingAccount(2);
        Assert.assertTrue("Savings", actual);
    }
    @Test
    public void addingAccountTest3(){
        User user = new User(null, null, null);
        ArrayList<Integer> accountsIds = new ArrayList<Integer>();
        Boolean actual = user.addingAccount(3);
        Assert.assertTrue("Investment", actual);
    }
    @Test
    public void setUserName1(){
        User user = new User(null, null, null);
        user.setUserName("po");
        String actual = user.getUserName();
        Assert.assertEquals("po", actual);
    }
    @Test
    public void setUserName2(){
        User user = new User(null, null, null);
        user.setUserName("po");
        String actual = user.getUserName();
        Assert.assertNotEquals("poe", actual);
    }
    @Test
    public void setUserName3(){
        User user = new User(null, null, null);
        user.setUserName("Bobert4");
        String actual = user.getUserName();
        Assert.assertEquals("Bobert4", actual);
    }
    @Test
    public void setUserID1(){
        User user = new User(null, null, null);
        user.setUserID(12);
        Integer expected = 12;//if this line is not added, it will throw an ambiguous method call
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setUserID2(){
        User user = new User(null, null, null);
        user.setUserID(15);
        Integer expected = 15;
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setUserID3(){
        User user = new User(null, null, null);
        user.setUserID(2);
        Integer expected = 2;
        Integer actual = user.getUserID();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setPassword1(){
        User user = new User(null, null, null);
        user.setPassword("pw3");
        String actual = user.getPassword();
        Assert.assertEquals("pw3", actual);
    }
    @Test
    public void setPassword2(){
        User user = new User(null, null, null);
        user.setPassword("pw123");
        String actual = user.getPassword();
        Assert.assertEquals("pw123", actual);
    }
    @Test
    public void setPassword3(){
        User user = new User(null, null, null);
        user.setPassword("pa$$w0rd");
        String actual = user.getPassword();
        Assert.assertEquals("pa$$w0rd", actual);
    }
}
