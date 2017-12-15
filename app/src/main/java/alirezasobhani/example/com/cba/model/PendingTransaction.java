
package alirezasobhani.example.com.cba.model;

public class PendingTransaction extends Transaction {

    @Override
    public boolean isPending() {
        return true;
    }
}
