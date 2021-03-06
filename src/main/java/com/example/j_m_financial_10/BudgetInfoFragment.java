package com.example.j_m_financial_10;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BudgetInfoFragment extends Fragment {

    private TextView addMonthlyExpenseTV;
    private NavController navController;
    private NavDirections action;

    public BudgetInfoFragment() {
        // Required empty public constructor
    }

    public static BudgetInfoFragment newInstance() {
        BudgetInfoFragment fragment = new BudgetInfoFragment();
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
        return inflater.inflate(R.layout.fragment_budget_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        addMonthlyExpenseTV = view.findViewById(R.id.BIF_add_monthly_expense_TV);
        addMonthlyExpenseTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = BudgetInfoFragmentDirections.actionBudgetInfoFragmentToMonthlyExpensesFragment();
                navController.navigate(action);
            }
        });
    }
}