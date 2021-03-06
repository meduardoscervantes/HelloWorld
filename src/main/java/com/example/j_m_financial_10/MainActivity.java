package com.example.j_m_financial_10;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private NavController navController;
    private NavDirections action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo find a way to make the app start up with a splash screen then onto
        // then can go into seperate fragments. Database with room is all set, just have to do
        // the front end stuff. how exciting!!
        navController = Navigation.findNavController(this, R.id.navHostFragment);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if(users == null){
                    action = SplashScreenFragmentDirections.actionSplashScreenFragmentToFirstTimeInfoFragment();
                }else{
                    action = SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeScreenFragment();
                }
                navController.navigate(action);
            }
        });
    }
}

/*
    public void firstClickButton(View view){

        EditText FirstNameBox = (EditText) findViewById(R.id.first_time_first_name);
        EditText LastNameBox = (EditText) findViewById(R.id.first_time_last_name);
        EditText FlatOrPercentageBox = (EditText) findViewById(R.id.flatRate_percentage_editText);
        RadioButton FlatRate = (RadioButton) findViewById(R.id.radio_flat_rate_first_time);
        RadioButton PercentageRate = (RadioButton) findViewById(R.id.radio_percentage_rate_first_time);
        RadioButton NothingRadio = (RadioButton) findViewById(R.id.radio_nothing);
        TextView error_message = (TextView) findViewById(R.id.error_message);
        TextView error_message2 = (TextView) findViewById(R.id.error_message2);

        Intent intent = new Intent(this, ActivityHomeScreen.class);
        System.out.println("Before going into the if statements");

        //Check and make sure the text boxes containing information have information
        if(!FirstNameBox.getText().toString().isEmpty() && !LastNameBox.getText().toString().isEmpty()
                && ( FlatRate.isChecked() || PercentageRate.isChecked() ) && !FlatOrPercentageBox.getText().toString().isEmpty()){
            Users user = new Users(FirstNameBox.getText().toString(), LastNameBox.getText().toString());
            //Check that the radio buttons are selected and what that selection is
            if(FlatRate.isChecked()){
                user.setFlat_saving_amount(Double.valueOf(FlatOrPercentageBox.getText().toString()));
            }else if(PercentageRate.isChecked()){
                user.setPercentage_saving_amount(Double.valueOf(FlatOrPercentageBox.getText().toString()));
                System.out.println("flat saving amount = "+ user.getFlat_saving_amount());
                System.out.println("percentage savings amount = " + user.getPercentage_saving_amount());
            }
            user.newAccount("Cash", 0.0);
            intent.putExtra("user", user);

            startActivity(intent);
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
        if (FlatOrPercentageBox.getText().toString().isEmpty()){
            error_message2.setVisibility(View.VISIBLE);
            error_message2.setText("How much would you like to save?");
        }
        if(!FlatRate.isChecked() && !PercentageRate.isChecked()){//Radio buttons have not been selected
            error_message2.setVisibility(View.VISIBLE);
            error_message2.setText("Would you like to have a monthly savings goal?");
        }
        if (NothingRadio.isChecked()){
            FlatOrPercentageBox.setVisibility(View.INVISIBLE);
        }
    }

    public void radioSelectionFirstTime(View view){
        ((TextView)findViewById(R.id.error_message2)).setVisibility(View.INVISIBLE);
        if (!((RadioButton)findViewById(R.id.radio_nothing)).isChecked()){
            ((EditText)findViewById(R.id.flatRate_percentage_editText)).setVisibility(View.VISIBLE);
        }else
            ((EditText)findViewById(R.id.flatRate_percentage_editText)).setVisibility(View.INVISIBLE);
    }
*/
