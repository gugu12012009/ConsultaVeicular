package com.example.consultaveicular;

/**
 * UtilsRodizio: Classe auxiliar com métodos para validação e cálculo de rodízio
 * Contém as regras de rodízio e licenciamento conforme especificado
 * 
 * REGRAS DO RODÍZIO:
 * - Finais 1 e 2 → Segunda-feira (7h às 10h e 17h às 20h)
 * - Finais 3 e 4 → Terça-feira (7h às 10h e 17h às 20h)
 * - Finais 5 e 6 → Quarta-feira (7h às 10h e 17h às 20h)
 * - Finais 7 e 8 → Quinta-feira (7h às 10h e 17h às 20h)
 * - Finais 9 e 0 → Sexta-feira (7h às 10h e 17h às 20h)
 * 
 * REGRAS DO LICENCIAMENTO:
 * - Final 1 e 2 → até julho
 * - Final 3 e 4 → até agosto
 * - Final 5 e 6 → até setembro
 * - Final 7 e 8 → até outubro
 * - Final 9 → até novembro
 * - Final 0 → até dezembro
 */
public class UtilsRodizio {

    /**
     * Extrai o último número da placa
     * Percorre a string de trás para frente e retorna o primeiro dígito encontrado
     * 
     * @param placa String com a placa do veículo
     * @return Último dígito da placa como inteiro, ou -1 se nenhum dígito for encontrado
     */
    public static int extrairUltimoNumero(String placa) {
        // Converte para maiúsculas e remove espaços
        placa = placa.trim().toUpperCase();
        
        // Percorre a string de trás para frente
        for (int i = placa.length() - 1; i >= 0; i--) {
            // Verifica se o caractere é um dígito
            if (Character.isDigit(placa.charAt(i))) {
                return Character.getNumericValue(placa.charAt(i));
            }
        }
        
        // Retorna -1 se nenhum dígito for encontrado
        return -1;
    }

    /**
     * Obtém o dia do rodízio baseado no final da placa
     * 
     * @param finalPlaca Último dígito da placa
     * @return String com o dia do rodízio
     */
    public static String obterDiaRodizio(int finalPlaca) {
        switch (finalPlaca) {
            case 1:
            case 2:
                return "Segunda-feira";
            case 3:
            case 4:
                return "Terça-feira";
            case 5:
            case 6:
                return "Quarta-feira";
            case 7:
            case 8:
                return "Quinta-feira";
            case 9:
            case 0:
                return "Sexta-feira";
            default:
                return "Desconhecido";
        }
    }

    /**
     * Obtém o mês de licenciamento baseado no final da placa
     * 
     * @param finalPlaca Último dígito da placa
     * @return String com o mês de licenciamento
     */
    public static String obterMesLicenciamento(int finalPlaca) {
        switch (finalPlaca) {
            case 1:
            case 2:
                return "Julho";
            case 3:
            case 4:
                return "Agosto";
            case 5:
            case 6:
                return "Setembro";
            case 7:
            case 8:
                return "Outubro";
            case 9:
                return "Novembro";
            case 0:
                return "Dezembro";
            default:
                return "Desconhecido";
        }
    }
}
