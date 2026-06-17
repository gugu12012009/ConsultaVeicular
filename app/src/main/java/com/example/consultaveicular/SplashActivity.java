package com.example.consultaveicular;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

/**
 * SplashActivity: Exibe a tela de abertura do aplicativo
 * Permanece visível por 2 segundos antes de navegar para MainActivity
 */
public class SplashActivity extends AppCompatActivity {

    // Duração da Splash Screen em milissegundos
    private static final long SPLASH_DURATION = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Agenda a navegação para MainActivity após SPLASH_DURATION
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cria Intent para iniciar MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // Finaliza SplashActivity para que o usuário não possa voltar
                finish();
            }
        }, SPLASH_DURATION);
    }
}
