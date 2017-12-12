package alirezasobhani.example.com.cba.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import alirezasobhani.example.com.cba.R;
import butterknife.BindView;
import butterknife.ButterKnife;

class TransactionDateViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.date_text_view)
    TextView dateTextView;

    @BindView(R.id.days_ago_text_view)
    TextView daysAgoTextView;

    public TransactionDateViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
