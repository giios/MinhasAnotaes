package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.minhasanotaes.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //validar se não esta vazio o campo
                String textoRecuperado = editAnotacao.getText().toString();
                if( textoRecuperado.equals("")){
                    Snackbar.make(view, "Favor preencher a anotação!", Snackbar.LENGTH_LONG).show();

                }else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva!", Snackbar.LENGTH_LONG).show();
                    }
                }
            });
        //recuperar a anotação
        String anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }


        }
    }
