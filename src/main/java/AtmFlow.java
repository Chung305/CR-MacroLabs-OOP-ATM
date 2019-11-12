import java.util.Collection;

public class AtmFlow {
    UserVillage userVillage = new UserVillage();
    AccountVillage accountVillage = new AccountVillage();

    public  void start(){
        mainMenu(Console.getIntegerInput("Welcome to ATM FLOWTISTIC!\n" +
                "1 - Log In\n" +
                "2 - Create Account\n" +
                "3 - Quit"));
    }

    public void mainMenu(Integer choice){
        switch(choice){
            case 1 :
                logIn();
                break;
            case 2 :
                createAccount();
                break;
            case 3 :
                System.exit(0);
                break;
            default :
                Console.println("Not an Option, choose again");
                start();
                break;
        }
    }
    //////LOGIN METHODS/////
    public void logIn(){

        String userName = Console.getStringInput("Enter a Username?");
        String password = Console.getStringInput("Enter a password?");

        if(userVillage.checkLogIn(userName, password)){
            accountStart(userName);
        }
        else
            Console.println("No account found for " + userName +"\n Please create account : ");
            start();
    }

    public void accountStart(String userName){
        accountMenu(Console.getIntegerInput("What would you like to do:\n" +
                "1 - create account\n" +
                "2 - Withdraw\n" +
                "3 - Deposit\n" +
                "4 - Transfer\n" +
                "5 - Close Account\n" +
                "6 - Log Out\n" +
                "7 - Exit\n" +
                "8 - See transaction history\n"), userName);
    }

    public void accountMenu(Integer choice, String userName){
        switch(choice){
            case 1 :
                createBankAccount(userName);
                break;
            case 2 :
                withdraw(userName);
                break;
            case 3 :
                //deposit
                deposit(userName);
                break;
            case 4 :
                //transfer
                transfer(userName);
                break;
            case 5 :
                //close account
                closeAccount(userName);
                break;
            case 6 :
                start();
                break;
            case 7 :
                System.exit(0);
                break;
            case 8:
                showTransactions(userName);
                break;
            default :
                Console.println("not an Option");
                break;
        }
        accountStart(userName);
    }

    public String showTransactions(String userName) {
        Integer accountId = accountPrompt(userName);
        String history = accountVillage.getAccountById(accountId).getPrintableHistory();
        Console.println(history);
        return history;
    }

    public void createAccount(){
        String userName = Console.getStringInput("Enter a Username?");
        String password = Console.getStringInput("Enter a password?");
        if(!userVillage.checkUser(userName)) {
            userVillage.createUser(userName, password);
            start();
        }
        else{
            createAccount();
        }
    }

    public String createBankAccount(String userName){
        Double amount = Console.getDoubleInput("How much would you like to deposit");
        Integer accountType = Console.getIntegerInput("Which type of Account\n" +
                "1 - Checking\n" +
                "2 - Savings \n" +
                "3 - Investment\n");
        Account account = accountVillage.createAccount(amount, accountType, userName);
        Integer id = account.getAccountID();
        userVillage.getUserByUsername(userName).addingAccount(id);
        Console.println("%s Account was created for %s", account.getName(), userName);
        return account.getAccountString();
    }


    public void withdraw(String userName){
        Double withdrawAmount = Console.getDoubleInput("How much would you like to withdraw?");
        Integer account = accountPrompt(userName);
        accountVillage.getAccountById(account).withdraw(withdrawAmount);
        Console.println("Withdrawing : " + withdrawAmount );
        promptNewBalance(account);
//        accountStart(userName);
    }
    public void deposit(String userName){
        Double depositAmount = Console.getDoubleInput("How much would you like to deposit?");
        Integer account = accountPrompt(userName);
        accountVillage.getAccountById(account).deposit(depositAmount);
        Console.println("Depositing : " + depositAmount);
        promptNewBalance(account);
//        accountStart(userName);

    }
    public void transfer(String userName){
        Double transferAmount;
        Integer sourceAccountId;
        Integer targetAccountId;
        do {
            sourceAccountId = accountPrompt(userName);
            transferAmount = Console.getDoubleInput("How much would you like to transfer? ");
            targetAccountId = targetAccount(sourceAccountId);
        } while(!accountVillage.getAccounts().keySet().contains(targetAccountId)
                || !(accountVillage.getAccountById(sourceAccountId).getBalance() >= transferAmount));
        accountVillage.getAccountById(sourceAccountId).transfer(accountVillage.getAccountById(targetAccountId),transferAmount);
//        accountStart(userName);
    }

    /////////PROMPT//////

    public void promptNewBalance(Integer account){
        Console.println( "New Balance : " + accountVillage.getAccountById(account).getBalance() + "\n\n");
    }

    public Integer accountPrompt(String userName) {
        Integer accountId;
        User user = userVillage.getUserByUsername(userName);
        String message = buildAccountSelectionList("access", user.getAccountsIds());
        do {
            accountId = Console.getIntegerInput(message);
        } while (!user.getAccountsIds().contains(accountId));
        return accountId;
    }

    public Integer targetAccount(Integer currentId) {
        Integer accountId;
        String message = buildAccountSelectionList("transfer to", accountVillage.getAccounts().keySet());
        do {
            accountId = Console.getIntegerInput(message);
        } while (!accountVillage.getAccounts().keySet().contains(accountId)
            || accountId == currentId);
        return accountId;
    }

    public String buildAccountSelectionList(String prompt, Collection<Integer> idList) {
        StringBuilder message = new StringBuilder();
        for (Integer id : idList) {
            Account account = accountVillage.getAccountById(id);
            message.append(String.format("%s : %s %s\n", id, account.getUserName(), account.getName()));
        }
        message.append("Choose an account to " + prompt + ": ");
        return message.toString();
    }

    public void closeAccount(String userName) {
        Integer accountId = accountPrompt(userName);
        if (accountVillage.getAccountById(accountId).closeAccount()) {
            accountVillage.closeAccountById(accountId);
            userVillage.getUserByUsername(userName).removeAccount(accountId);
        }
    }
}
