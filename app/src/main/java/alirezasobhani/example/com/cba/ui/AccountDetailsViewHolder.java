package alirezasobhani.example.com.cba.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import alirezasobhani.example.com.cba.R;
import butterknife.BindView;
import butterknife.ButterKnife;

class AccountDetailsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.account_name_text_view)
    TextView accountNameTextView;

    @BindView(R.id.account_number_text_view)
    TextView accountNumberTextView;

    @BindView(R.id.available_funds_text_view)
    TextView availableFundTextView;

    @BindView(R.id.account_balance_text_view)
    TextView accountBalanceTextView;

    public AccountDetailsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
