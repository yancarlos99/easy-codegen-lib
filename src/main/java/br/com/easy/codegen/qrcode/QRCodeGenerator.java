package br.com.easy.codegen.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class QRCodeGenerator {
    /**
     * Gera um QR Code com o conteúdo especificado e configurações fornecidas.
     *
     * @param data   O conteúdo a ser codificado no QR Code
     * @param config Configurações do QR Code, incluindo tamanho, formato e nível de correção de erros
     * @throws WriterException Se ocorrer um erro ao gerar o QR Code
     * @throws IOException     Se ocorrer um erro ao escrever o QR Code no arquivo
     */
    public static void generateQRCode(String data, QRCode config) throws WriterException, IOException {
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, config.getErrorCorrectionLevel());

        BitMatrix matrix = new MultiFormatWriter().encode(
                data,
                BarcodeFormat.QR_CODE,
                config.getWidth(),
                config.getHeight(),
                hints
        );
        MatrixToImageWriter.writeToPath(matrix, config.getFormat(), Path.of(config.getOutputPath()));
    }

    /**
     * Gera o conteúdo formatado para um QR Code de conexão Wi-Fi.
     *
     * @param ssid       Nome da rede (SSID)
     * @param password   Senha da rede (ou "" para redes abertas)
     * @param encryption Tipo de criptografia: "WEP", "WPA", "nopass"
     * @return String formatada no padrão reconhecido por leitores de QR Code
     */
    public static String forWifi(String ssid, String password, String encryption) {
        if (Objects.isNull(ssid) || ssid.isEmpty()) {
            throw new IllegalArgumentException("O SSID (nome da rede) é obrigatório.");
        }

        if (!WifiEncryptionEnum.isValid(encryption)) {
            throw new IllegalArgumentException("Tipo de criptografia inválido. Use: WEP, WPA ou nopass.");
        }

        WifiEncryptionEnum encryptionEnum = WifiEncryptionEnum.from(encryption);

        StringBuilder sb = new StringBuilder();
        sb.append("WIFI:");
        sb.append("T:").append(encryptionEnum.name()).append(";");
        sb.append("S:").append(escape(ssid)).append(";");

        if (!encryptionEnum.equals(WifiEncryptionEnum.NOPASS)) {
            sb.append("P:").append(escape(password)).append(";");
        }

        sb.append(";");
        return sb.toString();
    }

    /**
     * Gera o conteúdo formatado para um QR Code de localização geográfica.
     *
     * @param latitude  Latitude da localização
     * @param longitude Longitude da localização
     * @return String formatada para abrir no Google Maps
     */
    public static String forGeoLocation(double latitude, double longitude) {
        return String.format(Locale.US, "https://maps.google.com/?q=%.8f,%.8f", latitude, longitude);
    }

    /**
     * Escapa caracteres especiais como ponto e vírgula e barra invertida.
     */
    private static String escape(String input) {
        return input.replace("\\", "\\\\")
                .replace(";", "\\;")
                .replace(",", "\\,");
    }
}
