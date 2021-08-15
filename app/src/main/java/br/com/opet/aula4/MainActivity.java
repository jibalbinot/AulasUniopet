package br.com.opet.aula4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MAINACTIVITY","criou a aplicação");
    }

    public void chamarIntent(View v){
        Intent it = new Intent(Intent.ACTION_SEND);
        it.setType("text/plain");
        it.putExtra(Intent.EXTRA_EMAIL, new String[] {"coordenadoraTDS@uniopet.edu.br","k@gmail.com"});
        it.putExtra(Intent.EXTRA_SUBJECT,"Aula sobre intents explícitas");
        it.putExtra(Intent.EXTRA_TEXT,"Olá coordenadora, estou escrevendo esse email para teste");

        try {
            startActivity(it.createChooser(it,"Enviar e-mail por: "));
        }catch (ActivityNotFoundException e){
            e.printStackTrace();
        }
    }
}