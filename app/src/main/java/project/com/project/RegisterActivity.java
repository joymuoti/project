package project.com.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button  btnSubmit;
    EditText email;
    EditText password;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);


        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        btnSubmit.setOnClickListener(this);
    }
    private void registerUser(){
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if(TextUtils.isEmpty(Email)){
            //email is empty

            //stoping the execution from going further
            Toast.makeText(this,"Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Password)){
            //pass is empty
            //stoping the execution from going further
            Toast.makeText(this,"Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        //if validations are ok
        //first show a progress dialog

        progressDialog.setMessage("Registering...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            finish();
                            //the user is successfully registered and logged in.
                            Toast.makeText(RegisterActivity.this,  "Registered Successfully...", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RegisterActivity.this,  "failed...", Toast.LENGTH_SHORT).show();


                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        if(view == btnSubmit){
            registerUser();

        }
    }
}



