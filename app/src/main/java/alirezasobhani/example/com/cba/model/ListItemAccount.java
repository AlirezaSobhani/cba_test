package alirezasobhani.example.com.cba.model;

public class ListItemAccount extends Account {

    private float projectedSpend = 0;

    public float getProjectedSpend() {
        return projectedSpend;
    }

    public void setProjectedSpend(float projectedSpend) {
        this.projectedSpend = projectedSpend;
    }

    public static ListItemAccount build(Account acc) {
        ListItemAccount listItemAccount = new ListItemAccount();
        listItemAccount.setAccountName(acc.getAccountName());
        listItemAccount.setAccountNumber(acc.getAccountNumber());
        listItemAccount.setAvailable(acc.getAvailable());
        listItemAccount.setBalance(acc.getBalance());
        return listItemAccount;
    }

    public ListItemAccount projectedSpend(float projectedSpend) {
        this.setProjectedSpend(projectedSpend);
        return this;
    }
}
