package com.example.loginlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public TextView res_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        res_log = findViewById(R.id.textView_resultadoLogin);
        Bundle bundle = getIntent().getExtras();
        String LOGIN = bundle.getString("LOGIN_CORRETO");
        String SENHA = bundle.getString("SENHA_CORRETA");
        String login_usuario = bundle.getString("KEY_LOGIN");
        String senha_usuario = bundle.getString("KEY_SENHA");

        if((login_usuario.equals(LOGIN))&&(senha_usuario.equals(SENHA))){
            res_log.setText(R.string.login_sucesso);
        }
        else{
            res_log.setText(R.string.login_erro);
        }

        ValidaLogin(LOGIN,SENHA,login_usuario,senha_usuario);

    }
private void ValidaLogin(String LOGIN,String SENHA,String login_usuario,String senha_usuario){
    if((login_usuario.equals(LOGIN))&&(senha_usuario.equals(SENHA))){
        res_log.setText(R.string.login_sucesso);
    }
    else{
        res_log.setText(R.string.login_erro);
    }
    
}
}