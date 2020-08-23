package com.example.loginlocal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView res_log;
    private String usuario;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        res_log = findViewById(R.id.textView_resultadoLogin);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        usuario = intent.getStringExtra(getString(R.string.key_usuario));
        senha = intent.getStringExtra(getString(R.string.key_senha));


        ValidaLogin();

    }
    private void ValidaLogin() {
        if ((usuario.equals(getString(R.string.user_default))) && (senha.equals(getString(R.string.password_defaul)))) {
            res_log.setText(R.string.bem_vindo_msg);
        } else {
            res_log.setText(R.string.erro_login_msg);
        }
    }
        //@Override
        public boolean onOptionItemSelected(@NonNull MenuItem item){
            if(item.getItemId() == android.R.id.home){
            finish();
            }
            return super.onOptionsItemSelected(item);
        }
}