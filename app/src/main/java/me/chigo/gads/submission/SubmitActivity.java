package me.chigo.gads.submission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import me.chigo.gads.R;
import me.chigo.gads.utils.Utility;

public class SubmitActivity extends AppCompatActivity implements SubmitContract.SubmitView {
    SubmitPresenter submitPresenter;
    EditText first_name_et,last_name_et, email_et, github_et;
    String firstName, lastName, emailAdd, githubLink;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        initContols();
    }

    private void initContols() {
        submitPresenter = new SubmitPresenter(this);



        first_name_et = findViewById(R.id.first_name_et);


        last_name_et = findViewById(R.id.last_name_et);


        email_et = findViewById(R.id.email_et);

        github_et = findViewById(R.id.github_et);


        submit_btn =findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = first_name_et.getText().toString();
                lastName = last_name_et.getText().toString();
                emailAdd = email_et.getText().toString();
                githubLink = github_et.getText().toString();

                Log.d("DETAILS", firstName+ lastName + emailAdd + githubLink);
                submitPresenter.submitReq(SubmitActivity.this, firstName, lastName, emailAdd, githubLink);
            }
        });


    }


    @Override
    public void showToast(String message) {
        Utility.shortToast(SubmitActivity.this, message);
    }

    @Override
    public void showProgress() {
        Utility.showProgressDialog(SubmitActivity.this, false);
    }

    @Override
    public void hideProgress() {
        Utility.hideProgressDialog(SubmitActivity.this);
    }



    @Override
    public void submit() {

    }

}