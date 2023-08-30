package com.imbang.beta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class g_login extends AppCompatActivity {

    private SignInButton login;
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g_login);
        login = findViewById(R.id.sign_in_button);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginGoogle();
            }
        });
    }

    private void LoginGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            final GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (!account.getId().equals("")&&!account.getId().equals(null)){
                Intent i = new Intent(g_login.this, loading1.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(g_login.this, loading1.class);
                startActivity(i);
                finish();
                Toast.makeText(this, "Berhasil Login",
                        Toast.LENGTH_SHORT).show();            }
        } catch (ApiException e) {
            Intent i = new Intent(g_login.this, loading1.class);
            startActivity(i);
            finish();
            Log.d("error", ""+e);
            Toast.makeText(this, "Berhasil!",
                    Toast.LENGTH_SHORT).show();        }
    }
}