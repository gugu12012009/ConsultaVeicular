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
import java.text.DecimalFormat;

/**
 * CombustivelActivity: Tela de Calculadora de Combustível
 * Permite que o usuário compare preços de Gasolina e Etanol
 * Recomenda qual combustível é mais vantajoso
 * 
 * FÓRMULA:
 * Proporção = Preço do Etanol ÷ Preço da Gasolina
 * 
 * REGRA:
 * - Se proporção < 0,70 → Etanol é mais vantajoso
 * - Se proporção >= 0,70 → Gasolina é mais vantajosa
 */
public class CombustivelActivity extends AppCompatActivity {

    // Referências aos elementos da interface
    private TextInputEditText inputGasolina;
    private TextInputEditText inputEtanol;
    private MaterialButton btnCalcular;
    private MaterialButton btnVoltarCombustivel;
    private LinearLayout resultadoContainerCombustivel;
    private TextView resultadoProporcao;
    private TextView resultadoRecomendacao;
    private TextView erroMessageCombustivel;

    // Constante para a proporção limite (0,70 = 70%)
    private static final double LIMITE_PROPORCAO = 0.70;

    // Formatador de números decimais
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        // Inicializa o formatador de decimais (2 casas decimais)
        decimalFormat = new DecimalFormat("0.00");

        // Inicializa os componentes da UI
        inicializarComponentes();

        // Configura o listener do botão Calcular
        btnCalcular.setOnClickListener(v -> calcularCombustivel());

        // Configura o listener do botão Voltar
        btnVoltarCombustivel.setOnClickListener(v -> {
            Intent intent = new Intent(CombustivelActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Inicializa as referências aos componentes da interface
     */
    private void inicializarComponentes() {
        inputGasolina = findViewById(R.id.input_gasolina);
        inputEtanol = findViewById(R.id.input_etanol);
        btnCalcular = findViewById(R.id.btn_calcular);
        btnVoltarCombustivel = findViewById(R.id.btn_voltar_combustivel);
        resultadoContainerCombustivel = findViewById(R.id.resultado_container_combustivel);
        resultadoProporcao = findViewById(R.id.resultado_proporcao);
        resultadoRecomendacao = findViewById(R.id.resultado_recomendacao);
        erroMessageCombustivel = findViewById(R.id.erro_message_combustivel);
    }

    /**
     * Realiza o cálculo de combustível
     * Valida as entradas e exibe a recomendação
     * 
     * Fórmula: Etanol ÷ Gasolina
     * Se resultado < 0,70 → Etanol é melhor
     * Se resultado >= 0,70 → Gasolina é melhor
     */
    private void calcularCombustivel() {
        // Obtém os valores inseridos
        String precoGasolinaStr = inputGasolina.getText().toString().trim();
        String precoEtanolStr = inputEtanol.getText().toString().trim();

        // Limpa as mensagens anteriores
        erroMessageCombustivel.setVisibility(View.GONE);
        resultadoContainerCombustivel.setVisibility(View.GONE);

        // Valida se os campos estão vazios
        if (TextUtils.isEmpty(precoGasolinaStr) || TextUtils.isEmpty(precoEtanolStr)) {
            exibirErroCombustivel(getString(R.string.error_campos_vazios));
            return;
        }

        try {
            // Converte os valores para double
            double precoGasolina = Double.parseDouble(precoGasolinaStr);
            double precoEtanol = Double.parseDouble(precoEtanolStr);

            // Valida se os valores são válidos (maiores que 0)
            if (precoGasolina <= 0 || precoEtanol <= 0) {
                exibirErroCombustivel(getString(R.string.error_valores_invalidos));
                return;
            }

            // Calcula a proporção: Etanol ÷ Gasolina
            double proporcao = precoEtanol / precoGasolina;

            // Exibe os resultados
            exibirResultadosCombustivel(proporcao);

        } catch (NumberFormatException e) {
            // Captura erro ao fazer parsing dos valores
            exibirErroCombustivel(getString(R.string.error_valores_invalidos));
        }
    }

    /**
     * Exibe os resultados do cálculo
     *
     * @param proporcao Valor da proporção (Etanol ÷ Gasolina)
     */
    private void exibirResultadosCombustivel(double proporcao) {
        // Formata a proporção para 2 casas decimais
        String proporcaoFormatada = decimalFormat.format(proporcao);
        resultadoProporcao.setText(proporcaoFormatada);

        // Determina a recomendação
        String recomendacao;
        if (proporcao < LIMITE_PROPORCAO) {
            // Se proporção < 0,70 → Etanol é melhor
            recomendacao = getString(R.string.recomendacao_etanol);
        } else {
            // Se proporção >= 0,70 → Gasolina é melhor
            recomendacao = getString(R.string.recomendacao_gasolina);
        }

        resultadoRecomendacao.setText(recomendacao);

        // Mostra o container de resultados
        resultadoContainerCombustivel.setVisibility(View.VISIBLE);
    }

    /**
     * Exibe uma mensagem de erro
     *
     * @param mensagem Mensagem de erro a exibir
     */
    private void exibirErroCombustivel(String mensagem) {
        erroMessageCombustivel.setText(mensagem);
        erroMessageCombustivel.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        // Ao pressionar voltar, retorna para MainActivity
        Intent intent = new Intent(CombustivelActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
