package br.com.easy.codegen.qrcode;

public enum WifiEncryptionEnum {
    WEP,
    WPA,
    NOPASS;

    /**
     * Verifica se o valor fornecido é um tipo de criptografia Wi-Fi válido.
     *
     * @param value O valor a ser verificado.
     * @return true se o valor for válido, false caso contrário.
     */
    public static boolean isValid(String value) {
        try {
            WifiEncryptionEnum.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * Converte uma string para o enum correspondente.
     *
     * @param value A string a ser convertida.
     * @return O enum correspondente ao valor fornecido.
     * @throws IllegalArgumentException Se o valor não corresponder a nenhum enum.
     */
    public static WifiEncryptionEnum from(String value) {
        return WifiEncryptionEnum.valueOf(value.toUpperCase());
    }
}
