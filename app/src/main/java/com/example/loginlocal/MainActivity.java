package com.example.loginlocal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edittxt_login;
    private EditText edittxt_senha;
    private Button btn_login;
    private CheckBox lembrarCheckBox;
    private TextView novoUsuarioTextView;
    private String usuario;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittxt_login = findViewById(R.id.editText_usuario);
        edittxt_senha = findViewById(R.id.editText_senha);
        lembrarCheckBox = findViewById(R.id.checkbox_lembrar);
        novoUsuarioTextView = findViewById(R.id.textView_novo);
        btn_login = findViewById(R.id.button_logar);
        btn_login.setOnClickListener(this);
    }

    public void onClick(View view) {
       if(view == btn_login){
           usuario = edittxt_login.getText().toString();
           senha = edittxt_senha.getText().toString();

           if(usuario.isEmpty()||senha.isEmpty());{
               Toast.makeText(this,R.string.erro_entrada_msg,Toast.LENGTH_LONG).show();
           }
           abrirLoginActivity();
           return;
       }

    }
    private void abrirLoginActivity(){
        Intent intent = new Intent(this,LoginActivity.class);

        Bundle  bundle = new Bundle();
        bundle.putString(getString(R.string.key_usuario),usuario);
        bundle.putString(getString(R.string.key_senha),senha);

        intent.putExtras(bundle);
        startActivity(intent);
    }

}