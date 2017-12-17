package alirezasobhani.example.com.cba.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import alirezasobhani.example.com.cba.R;
import alirezasobhani.example.com.cba.model.Atm;
import alirezasobhani.example.com.cba.model.Transaction;
import alirezasobhani.example.com.cba.model.TransactionData;
import alirezasobhani.example.com.cba.service.ApiService;
import alirezasobhani.example.com.cba.service.TransactionsService;
import alirezasobhani.example.com.cba.service.TransactionsService.GetTransactionsResponseCallback;
import alirezasobhani.example.com.cba.service.exception.NoConnectivityException;
import alirezasobhani.example.com.cba.service.exception.UnknownException;
import alirezasobhani.example.com.cba.utils.ConnectivityUtils;
import alirezasobhani.example.com.cba.utils.ListItemGenerator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TransactionsActivity extends AppCompatActivity implements GetTransactionsResponseCallback<TransactionData>, ItemClickListener<Transaction, View> {

    @BindView(R.id.activity_transactions_toolbar)
    Toolbar toolbar;

    @BindView(R.id.activity_transactions_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.activity_transactions_try_again_button)
    View tryAgainButton;

    @BindView(R.id.activity_transactions_progress_bar)
    View progressBar;

    private ApiService<TransactionData> transactionsService;
    private List<Atm> atmList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        transactionsService = new TransactionsService(new ConnectivityUtils(this), this);
        retrieveTransactions();
    }

    @OnClick(R.id.activity_transactions_try_again_button)
    void retrieveTransactions() {
        transactionsService.cancel();
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        tryAgainButton.setVisibility(View.GONE);
        transactionsService.runService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResponse(TransactionData transactionsData) {
        List<Object> listItems = ListItemGenerator.getListItems(transactionsData);
        if(listItems.size() == 0) {
            onFailed(new UnknownException());
        } else {
            atmList = transactionsData.getAtms();
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            tryAgainButton.setVisibility(View.GONE);
            TransactionsListAdapter adapter = new TransactionsListAdapter(listItems, this);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onFailed(Throwable t) {
        if(t instanceof NoConnectivityException) {
            showNoConnectionDialog();
        } else {
            //TODO
        }
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.VISIBLE);
    }

    private void showNoConnectionDialog() {
        new AlertDialog.Builder(this)
                .setTitle("No internet connection")
                .setMessage("There doesn\'t seem to be an\nactive internet connection.\nPlease make sure you are connected\nto the internet to continue.")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setOnDismissListener(dialog -> dialog.dismiss())
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void onItemClicked(Transaction transaction, View view) {
        if (atmList == null) return;
        for (Atm atm : atmList) {
            if(transaction.getAtmId().equals(atm.getId())) {
                Intent intent = new Intent(this, AtmMapActivity.class);
                intent.putExtra(AtmMapActivity.ATM_KEY, atm);
                startActivity(intent);
            }
        }
    }
}
