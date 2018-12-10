package com.example.user.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void selecionarPedra(View view)   //paramentro da interface
    {
        this.opcaoSelecionada("Pedra");
    }

    public  void selecionarPapel(View view)   //paramentro da interface
    {
        this.opcaoSelecionada("Papel");
    }

    public  void selecionarTesoura(View view)   //paramentro da interface
    {
        this.opcaoSelecionada("Tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){

        TextView textoResultado =(TextView) findViewById(R.id.textoResultado);
        ImageView imagemResultado = (ImageView) findViewById(R.id.imagemResultado); //imagem do app
        String[] opcoes={"Pedra","Papel","Tesoura"};
        int numero = new Random().nextInt(3);  //gera um numero aleatorio de 0 - 3(sem o ultimo)
        String escolhaApp = opcoes[numero];

        System.out.println(escolhaApp);               //verifca se está tudo certo

        switch (escolhaApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                        (escolhaApp=="Pedra" && escolhaUsuario=="Tesoura") ||
                        (escolhaApp=="Papel" && escolhaUsuario=="Pedra")||
                        (escolhaApp=="Tesoura"&& escolhaUsuario=="Papel")
                ) //APP ganhador
        {
            textoResultado.setText("Você perdeu !!!");
        }else if(
                        (escolhaUsuario=="Pedra" && escolhaApp=="Tesoura") ||
                        (escolhaUsuario=="Papel" && escolhaApp=="Pedra")||
                        (escolhaUsuario=="Tesoura"&& escolhaApp=="Papel")
                )  //USUARIO ganhador
        {
            textoResultado.setText("Você ganhou !!!");
        }else  //EMPATE
        {
            textoResultado.setText("Empatamos !!!");
        }
    }
}
