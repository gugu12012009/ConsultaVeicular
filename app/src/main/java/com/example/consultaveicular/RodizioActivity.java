package com.example.consultaveicular;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/**
 * RodizioActivity: Tela de Consulta de Rodízio e Licenciamento
 * Permite que o usuário digite a placa do veículo e obtenha informações sobre:
 * - Dia do rodízio
 * - Horários de restrição (7h às 10h e 17h às 20h)
 * - Mês de licenciamento
 */
public class RodizioActivity extends AppCompatActivity {

    // Referências aos elementos da interface
    private TextInputEditText inputPlaca;
    private MaterialButton btnConsultarRodizio;
    private MaterialButton btnVoltarRodizio;
    private LinearLayout resultadoContainer;
    private TextView resultadoFinal;
    private TextView resultadoDia;
    private TextView resultadoHorario;
    private TextView resultadoLicenciamento;
    private TextView erroMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodizio);

        // Inicializa os componentes da UI
        inicializarComponentes();

        // Configura o listener do botão Consultar
        btnConsultarRodizio.setOnClickListener(v -> consultarRodizio());

        // Configura o listener do botão Voltar
        btnVoltarRodizio.setOnClickListener(v -> {
            Intent intent = new Intent(RodizioActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Inicializa as referências aos componentes da interface
     */
    private void inicializarComponentes() {
        inputPlaca = findViewById(R.id.input_placa);
        btnConsultarRodizio = findViewById(R.id.btn_consultar_rodizio);
        btnVoltarRodizio = findViewById(R.id.btn_voltar_rodizio);
        resultadoContainer = findViewById(R.id.resultado_container);
        resultadoFinal = findViewById(R.id.resultado_final);
        resultadoDia = findViewById(R.id.resultado_dia);
        resultadoHorario = findViewById(R.id.resultado_horario);
        resultadoLicenciamento = findViewById(R.id.resultado_licenciamento);
        erroMessage = findViewById(R.id.erro_message_rodizio);
    }

    /**
     * Realiza a consulta de rodízio
     * Valida a entrada e exibe o resultado ou mensagem de erro
     */
    private void consultarRodizio() {
        // Obtém o texto inserido
        String placa = inputPlaca.getText().toString().trim();

        // Limpa as mensagens anteriores
        erroMessage.setVisibility(View.GONE);
        resultadoContainer.setVisibility(View.GONE);

        // Valida se o campo está vazio
        if (TextUtils.isEmpty(placa)) {
            exibirErro(getString(R.string.error_campo_vazio));
            return;
        }

        // Extrai o último número da placa
        int finalPlaca = UtilsRodizio.extrairUltimoNumero(placa);

        // Valida se o último número foi encontrado
        if (finalPlaca == -1) {
            exibirErro(getString(R.string.error_placa_invalida));
            return;
        }

        // Obtém as informações de rodízio
        String dia = UtilsRodizio.obterDiaRodizio(finalPlaca);
        String mes = UtilsRodizio.obterMesLicenciamento(finalPlaca);

        // Exibe os resultados
        exibirResultados(finalPlaca, dia, mes);
    }

    /**
     * Exibe os resultados da consulta
     *
     * @param finalPlaca Último dígito da placa
     * @param dia Dia do rodízio
     * @param mes Mês de licenciamento
     */
    private void exibirResultados(int finalPlaca, String dia, String mes) {
        // Define os valores dos TextViews
        resultadoFinal.setText(String.valueOf(finalPlaca));
        resultadoDia.setText(dia);
        resultadoHorario.setText("7h às 10h e 17h às 20h");
        resultadoLicenciamento.setText(mes);

        // Mostra o container de resultados
        resultadoContainer.setVisibility(View.VISIBLE);
    }

    /**
     * Exibe uma mensagem de erro
     *
     * @param mensagem Mensagem de erro a exibir
     */
    private void exibirErro(String mensagem) {
        erroMessage.setText(mensagem);
        erroMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        // Ao pressionar voltar, retorna para MainActivity
        Intent intent = new Intent(RodizioActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
