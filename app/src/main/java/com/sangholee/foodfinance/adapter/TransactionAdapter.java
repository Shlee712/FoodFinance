package com.sangholee.foodfinance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sangholee.foodfinance.R;
import com.sangholee.foodfinance.model.Transaction;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class TransactionAdapter extends
        RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<Transaction> trans_list;

    public TransactionAdapter(List<Transaction> contacts) {
        trans_list = contacts;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView titleTextView;
        public TextView amountTextView;
        public TextView categoryTextView;
        //public TextView dateTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.transaction_title);
            amountTextView = (TextView) itemView.findViewById(R.id.transaction_amount);
            categoryTextView = (TextView) itemView.findViewById(R.id.transaction_category);
            //dateTextView = (TextView) itemView.findViewById(R.id.transaction_date);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.transcation_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TransactionAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Transaction trans = trans_list.get(position);

        // Set item views based on your views and data model
        TextView titleTextView = holder.titleTextView;
        TextView amountTextView = holder.amountTextView;
        TextView categoryTextView = holder.categoryTextView;
        //TextView dateTextView = holder.dateTextView;
        titleTextView.setText(trans.getTitle());
        amountTextView.setText(trans.getAmount());
        categoryTextView.setText(trans.getCategory());
        //dateTextView.setText(trans.getDate());
    }

    @Override
    public int getItemCount() {
        return trans_list.size();
    }
}
