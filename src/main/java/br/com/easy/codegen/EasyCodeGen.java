package br.com.easy.codegen;

import br.com.easy.codegen.qrcode.QRCode;
import br.com.easy.codegen.qrcode.QRCodeGenerator;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class EasyCodeGen {
    public static void main(String[] args) {
        try {
            QRCode qrConfig = new QRCode(300, 300, "PNG", "output/qr_code.png", ErrorCorrectionLevel.L);
            //QRCodeGenerator.generateQRCode("Hello World", qrConfig);

            String conteudo = QRCodeGenerator.forWifi("Silva-5G", "", "NOPASS");
            QRCodeGenerator.generateQRCode(conteudo, qrConfig);

            //String geoLocation = QRCodeGenerator.forGeoLocation(-23.5455177,-46.6383872);
            //QRCodeGenerator.generateQRCode(geoLocation, qrConfig);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}