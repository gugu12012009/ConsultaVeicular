package com.example.consultaveicular;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

/**
 * MainActivity: Tela inicial (Menu) do aplicativo
 * Apresenta dois botões para acessar as funcionalidades principais:
 * - Consulta de Rodízio e Licenciamento
 * - Calculadora de Combustível
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referência aos botões
        MaterialButton btnRodizio = findViewById(R.id.btn_rodizio);
        MaterialButton btnCombustivel = findViewById(R.id.btn_combustivel);

        // Listener para o botão de Rodízio
        btnRodizio.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RodizioActivity.class);
            startActivity(intent);
        });

        // Listener para o botão de Combustível
        btnCombustivel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CombustivelActivity.class);
            startActivity(intent);
        });
    }
}
