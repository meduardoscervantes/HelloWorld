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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FirstTimeInfoFragment extends Fragment {

    private NavController navController;
    private UserViewModel userViewModel;
    private Button butt;
    private TextView tv;
    public FirstTimeInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        final NavDirections action = FirstTimeInfoFragmentDirections.actionFirstTimeInfoFragmentToHomeScreenFragment();
        tv = view.findViewById(R.id.test_FTIF);
        butt = view.findViewById(R.id.FFT_test_butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(action);
            }
        });
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(getViewLifecycleOwner(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                System.out.println(users.get(0).getName());
                tv.setText(users.get(0).getName());
            }
        });


    }


    public static FirstTimeInfoFragment newInstance() {
        FirstTimeInfoFragment fragment = new FirstTimeInfoFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_time_info, container, false);
    }

}
/*
public void radioSelectionFirstTime(View view){
        ((TextView)findViewById(R.id.error_message2)).setVisibility(View.INVISIBLE);
        if (!((RadioButton)findViewById(R.id.radio_nothing)).isChecked()){
            ((EditText)findViewById(R.id.flatRate_percentage_editText)).setVisibility(View.VISIBLE);
        }else
            ((EditText)findViewById(R.id.flatRate_percentage_editText)).setVisibility(View.INVISIBLE);
    }
 */
/*

        userRepository = new UserRepository(getActivity().getApplication());
        navController = Navigation.findNavController(view);


        final EditText FirstNameBox = view.findViewById(R.id.FFT_firstname_ET);
        final EditText LastNameBox = view.findViewById(R.id.FFT_lastname_ET);
        final EditText SaveAmount = view.findViewById(R.id.FFT_save_amount_ET);

        final RadioGroup radioGroup = view.findViewById(R.id.FFT_radiogroup);
        final RadioButton FlatRate = view.findViewById(R.id.FFT_flat_rate_RB);
        final RadioButton PercentageRate = view.findViewById(R.id.FFT_percentage_rate_RB);
        final RadioButton NothingRadio = view.findViewById(R.id.FFT_nothing_RB);

        final TextView error_message = view.findViewById(R.id.error_message);
        final TextView error_message2 = view.findViewById(R.id.error_message2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == view.findViewById(R.id.FFT_flat_rate_RB).getId()){
                    System.out.println("Flat is selected");
                    SaveAmount.setVisibility(View.VISIBLE);
                }
                if (checkedId == view.findViewById(R.id.FFT_percentage_rate_RB).getId()){
                    System.out.println("Percentage is selected");
                    SaveAmount.setVisibility(View.VISIBLE);
                }
                if (checkedId == view.findViewById(R.id.FFT_nothing_RB).getId()){
                    System.out.println("Nothing is selected");
                    SaveAmount.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Setup the button OnClickListener
        view.findViewById(R.id.FFT_begin_BUTT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Check and make sure the text boxes containing information have information
                if(!FirstNameBox.getText().toString().isEmpty() && !LastNameBox.getText().toString().isEmpty()
                        && ( FlatRate.isChecked() || PercentageRate.isChecked() ) && !SaveAmount.getText().toString().isEmpty()){
                    Users user = new Users(FirstNameBox.getText().toString(), LastNameBox.getText().toString());
                    //Check that the radio buttons are selected and what that selection is
                    if(FlatRate.isChecked()){
                        user.setFlat_saving_amount(Double.valueOf(SaveAmount.getText().toString()));
                    }else if(PercentageRate.isChecked()){
                        user.setPercentage_saving_amount(Double.valueOf(SaveAmount.getText().toString()));
                        System.out.println("flat saving amount = "+ user.getFlat_saving_amount());
                        System.out.println("percentage savings amount = " + user.getPercentage_saving_amount());
                    }
                    user.newAccount("Cash", 0.0);

                }
                if(FirstNameBox.getText().toString().isEmpty()){ //First name box does not contain information
                    error_message.setVisibility(View.VISIBLE);
                    error_message.setText("Hey, what is your first name?");
                }
                if(LastNameBox.getText().toString().isEmpty()){ //Last name box does not contain information
                    error_message.setVisibility(View.VISIBLE);
                    error_message.setText("Hey, what is your last name?");
                }
                if(FirstNameBox.getText().toString().isEmpty() && LastNameBox.getText().toString().isEmpty()){ //Neither name box contains information
                    error_message.setVisibility(View.VISIBLE);
                    error_message.setText("You have not entered any information");
                }
                if(!FirstNameBox.getText().toString().isEmpty() && !LastNameBox.getText().toString().isEmpty()){ //Both boxes have information
                    error_message.setVisibility(View.INVISIBLE);
                }
                if (SaveAmount.getText().toString().isEmpty()){
                    error_message2.setVisibility(View.VISIBLE);
                    error_message2.setText("How much would you like to save?");
                }
                if(!FlatRate.isChecked() && !PercentageRate.isChecked()){//Radio buttons have not been selected
                    error_message2.setVisibility(View.VISIBLE);
                    error_message2.setText("Would you like to have a monthly savings goal?");
                }
                if (NothingRadio.isChecked()){
                    SaveAmount.setVisibility(View.INVISIBLE);
                }
            }
        });
        view.findViewById(R.id.FFT_test_butt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User foo = new User("Test");
                userRepository.insert(foo);
                User bobby = userRepository.getFirstUser();
                System.out.println(bobby);
                System.out.println("Inside of the FirstTime info fragm,ent and we are populating the database?\n the users name is" + bobby.getName());
                navController.navigate(FirstTimeInfoFragmentDirections.actionFirstTimeInfoFragmentToHomeScreenFragment());
            }
        });

        //TODO impllimnet a LiveData observer some how... view model class, UI cannot directly use the data it must e observed.
        // best practice is not directly!
 */