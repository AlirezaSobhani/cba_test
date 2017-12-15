
package alirezasobhani.example.com.cba.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionData {

    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("transactions")
    @Expose
    private List<Transaction> transactions = null;
    @SerializedName("pending")
    @Expose
    private List<PendingTransaction> pending = null;
    @SerializedName("atms")
    @Expose
    private List<Atm> atms = null;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<PendingTransaction> getPending() {
        return pending;
    }

    public void setPending(List<PendingTransaction> pendingTransaction) {
        this.pending = pendingTransaction;
    }

    public List<Atm> getAtms() {
        return atms;
    }

    public void setAtms(List<Atm> atms) {
        this.atms = atms;
    }

}
