package com.example.j_m_financial_10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpensesAdapter extends RecyclerView.Adapter <ExpensesAdapter.ExpensesHolder> {
    private List<Expenses> expenses = new ArrayList<>();

    @NonNull
    @Override
    public ExpensesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item, parent, false);
        return new ExpensesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesHolder holder, int position) {
        Expenses currentExpense = expenses.get(position);
        holder.expenseNameTV.setText(currentExpense.getName());
        holder.expenseAmountTV.setText(String.valueOf(currentExpense.getAmount()));
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }

    public void setExpenses(List<Expenses> expenses){
        this.expenses = expenses;
        notifyDataSetChanged();
    }

    static class ExpensesHolder extends RecyclerView.ViewHolder{
        private TextView expenseNameTV;
        private TextView expenseAmountTV;

        public ExpensesHolder(@NonNull View itemView) {
            super(itemView);
                expenseAmountTV = itemView.findViewById(R.id.monthly_expense_amount);
            expenseNameTV = itemView.findViewById(R.id.monthly_expense_name);
        }
    }
}
