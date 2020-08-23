package com.example.loginlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String LOGIN = "3001288";
    public final String SENHA = "8821003";
    public String login_usuario;
    public String senha_usuario;
    public EditText edittxt_login;
    public EditText edittxt_senha;
    public Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittxt_login = findViewById(R.id.editText_login);
        edittxt_senha = findViewById(R.id.editText_senha);
        btn_login = findViewById(R.id.button_logar);
        btn_login.setOnClickListener(onClickLogin());

    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_usuario = edittxt_login.getText().toString();
                senha_usuario = edittxt_senha.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("LOGIN_CORRETO", LOGIN);
                bundle.putString("SENHA_CORRETA", SENHA);
                bundle.putString("KEY_LOGIN", login_usuario);
                bundle.putString("KEY_SENHA", senha_usuario);

                if ((login_usuario.length() == 0) || (senha_usuario.length() == 0)) {
                    alert(R.string.campo_vazio);
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        };
    }
    public void alert(int texto){
        Toast.makeText(this,texto,Toast.LENGTH_LONG);
    }

}