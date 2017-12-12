package alirezasobhani.example.com.cba.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import alirezasobhani.example.com.cba.model.Account;
import alirezasobhani.example.com.cba.model.TransactionData;

import static org.hamcrest.core.Is.is;

public class ListItemGeneratorTest {

    @Test
    public void testNullList() throws Exception {
        Assert.assertThat(ListItemGenerator.getListItems(null), is(Collections.emptyList()));
    }

    @Test
    public void testNullAccount() throws Exception {
        TransactionData transactionData = new TransactionData();
        transactionData.setAccount(null);
        Assert.assertThat(ListItemGenerator.getListItems(transactionData), is(Collections.emptyList()));
    }

    @Test
    public void testAccount() throws Exception {
        TransactionData transactionData = new TransactionData();
        Account account = new Account();
        transactionData.setAccount(account);
        Assert.assertThat(ListItemGenerator.getListItems(transactionData).size(), is(1));
        Assert.assertThat(ListItemGenerator.getListItems(transactionData).get(0), is(account));
    }

    @Test
    public void testNullTransactions() throws Exception {
        TransactionData transactionData = new TransactionData();
        transactionData.setTransactions(null);
        Assert.assertThat(ListItemGenerator.getListItems(transactionData), is(Collections.emptyList()));
    }

    @Test
    public void testEmptyTransactions() throws Exception {
        TransactionData transactionData = new TransactionData();
        transactionData.setTransactions(Collections.emptyList());
        Assert.assertThat(ListItemGenerator.getListItems(transactionData), is(Collections.emptyList()));
    }

    @Test
    public void testNullPending() throws Exception {
        TransactionData transactionData = new TransactionData();
        transactionData.setTransactions(Collections.emptyList());
        transactionData.setPending(null);
        Assert.assertThat(ListItemGenerator.getListItems(transactionData), is(Collections.emptyList()));
    }

    @Test
    public void testEmptyPending() throws Exception {
        TransactionData transactionData = new TransactionData();
        transactionData.setTransactions(Collections.emptyList());
        transactionData.setPending(Collections.emptyList());
        Assert.assertThat(ListItemGenerator.getListItems(transactionData), is(Collections.emptyList()));
    }

}