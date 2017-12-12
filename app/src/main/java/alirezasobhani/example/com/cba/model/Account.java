
package alirezasobhani.example.com.cba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("accountName")
    @Expose
    private String accountName;
    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("available")
    @Expose
    private float available;
    @SerializedName("balance")
    @Expose
    private float balance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getAvailable() {
        return available;
    }

    public void setAvailable(float available) {
        this.available = available;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
