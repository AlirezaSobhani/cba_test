package alirezasobhani.example.com.cba.ui;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static alirezasobhani.example.com.cba.ui.TransactionListItem.ListItemType.TYPE_ACCOUNT_DETAILS;
import static alirezasobhani.example.com.cba.ui.TransactionListItem.ListItemType.TYPE_TRANSACTION_GROUP;
import static alirezasobhani.example.com.cba.ui.TransactionListItem.ListItemType.TYPE_TRANSACTION;
import static java.lang.annotation.RetentionPolicy.SOURCE;

interface TransactionListItem {

    @Retention(SOURCE)
    @IntDef({
            TYPE_ACCOUNT_DETAILS,
            TYPE_TRANSACTION_GROUP,
            TYPE_TRANSACTION
    })
    public @interface ListItemType {
        int TYPE_ACCOUNT_DETAILS = 0;
        int TYPE_TRANSACTION_GROUP = 1;
        int TYPE_TRANSACTION = 2;
    }

    @ListItemType int getItemType();
}
