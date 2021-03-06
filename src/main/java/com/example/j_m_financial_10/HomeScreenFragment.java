package com.example.j_m_financial_10;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;
import java.util.List;

public class HomeScreenFragment extends Fragment {

    private BottomNavigationView botNav;
    private UserViewModel userViewModel;
    private TextView userName;
    private TextView toAccountsTV;
    private TextView toExpensesTV;
    private NavController navController;
    private NavDirections action;
    private final DecimalFormat df = new DecimalFormat("#0.00");

    public HomeScreenFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    public static HomeScreenFragment newInstance() {
        HomeScreenFragment fragment = new HomeScreenFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        userName = view.findViewById(R.id.FHS_username_TV);

        toAccountsTV = view.findViewById(R.id.FHS_accounts);
        toAccountsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = HomeScreenFragmentDirections.actionHomeScreenFragmentToAccountFragment();
                navController.navigate(action);
            }
        });

        toExpensesTV = view.findViewById(R.id.FHS_expenses);
        toExpensesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = HomeScreenFragmentDirections.actionHomeScreenFragmentToBudgetInfoFragment();
                navController.navigate(action);
            }
        });

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userName.setText(users.get(0).getName());
            }
        });

    }
}