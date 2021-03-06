package com.example.j_m_financial_10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonthlyExpensesFragment extends Fragment {
    private EditText expenseName;
    private EditText expenseAmount;
    private ExpensesViewModel expensesViewModel;
    private Button addExpense;
    private ExpensesAdapter adapter;
    private RecyclerView recyclerView;

    public MonthlyExpensesFragment() {
        // Required empty public constructor
    }

    public static MonthlyExpensesFragment newInstance() {
        MonthlyExpensesFragment fragment = new MonthlyExpensesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monthly_expenses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expensesViewModel = new ViewModelProvider(this).get(ExpensesViewModel.class);

        expenseName = view.findViewById(R.id.MEF_expense_name);
        expenseAmount = view.findViewById(R.id.MEF_expense_amount);

        recyclerView = view.findViewById(R.id.MEF_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new ExpensesAdapter();
        recyclerView.setAdapter(adapter);

        expensesViewModel.getAllExpenses().observe(getViewLifecycleOwner(), new Observer<List<Expenses>>() {
            @Override
            public void onChanged(List<Expenses> expenses) {
                if (!(expenses == null)){
                    adapter.setExpenses(expenses);
                }
            }
        });

        addExpense = view.findViewById(R.id.MEF_add_expense_butt);
        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!expenseName.getText().toString().isEmpty()
                        && !expenseAmount.getText().toString().isEmpty()){
                    String name = expenseName.getText().toString();
                    Double amount = Double.valueOf(expenseAmount.getText().toString());
                    expensesViewModel.insert(new Expenses(name,amount));
                    expenseAmount.setText("");
                    expenseName.setText("");
                }else{
                    Toast.makeText(getContext(),"Enter information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}