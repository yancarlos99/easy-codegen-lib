package br.com.easy.codegen.qrcode;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class QRCodeGeneratorTest {
    @Test
    void testForWifiWPA() {
        String result = QRCodeGenerator.forWifi("MinhaRede", "minhaSenha123", "WPA");

        assertEquals("WIFI:T:WPA;S:MinhaRede;P:minhaSenha123;;", result);
    }

    @Test
    void testForWifiNoPassword() {
        String result = QRCodeGenerator.forWifi("Livre", "", "nopass");

        assertEquals("WIFI:T:NOPASS;S:Livre;;", result);
    }

    @Test
    void testForWifiInvalidEncryption() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->
                QRCodeGenerator.forWifi("SSID", "senha", "xyz")
        );

        assertTrue(ex.getMessage().contains("Tipo de criptografia inválido"));
    }

    @Test
    void testForGeoLocationFormatting() {
        double lat = -23.550520;
        double lng = -46.633308;

        String result = QRCodeGenerator.forGeoLocation(lat, lng);

        assertEquals("https://maps.google.com/?q=-23.55052000,-46.63330800", result);
    }

    @Test
    void testEscapeCharacters() {
        String result = QRCodeGenerator.forWifi("rede;com,virgula", "senha\\segura", "WEP");

        assertEquals("WIFI:T:WEP;S:rede\\;com\\,virgula;P:senha\\\\segura;;", result);
    }

    @Test
    void testSSIDRequired() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                QRCodeGenerator.forWifi("", "senha", "WEP")
        );

        assertTrue(ex.getMessage().contains("SSID"));
    }
}
