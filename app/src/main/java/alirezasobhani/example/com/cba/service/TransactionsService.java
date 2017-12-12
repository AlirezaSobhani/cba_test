package alirezasobhani.example.com.cba.service;

import alirezasobhani.example.com.cba.model.TransactionData;
import alirezasobhani.example.com.cba.utils.ConnectivityUtils;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;

public class TransactionsService extends ApiService<TransactionData> {

    private final GetTransactionsResponseCallback callback;

    public TransactionsService(ConnectivityUtils connectivityUtils, GetTransactionsResponseCallback callback) {
        super(connectivityUtils);
        this.callback = callback;
    }

    @Override
    protected Call<TransactionData> getCall() {
        return new ApiClientGenerator().createService(new OkHttpClient(), GsonFactory.getGsonInstance(), ApiClient.class).getTransactions();
    }

    @Override
    protected void handleSuccess(TransactionData transactionData) {
        callback.onResponse(transactionData);
    }

    @Override
    protected void handleFailure(Throwable t) {
        callback.onFailed(t);
    }

    public interface GetTransactionsResponseCallback<T> {
        void onResponse(T transactionsData);

        void onFailed(Throwable t);
    }
}
