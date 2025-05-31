package br.com.easy.codegen.qrcode;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
    private final int width;
    private final int height;
    private final String format;
    private final String outputPath;
    private final ErrorCorrectionLevel errorCorrectionLevel;

    public QRCode(int width, int height, String format, String outputPath, ErrorCorrectionLevel errorCorrectionLevel) {
        this.width = width;
        this.height = height;
        this.format = format;
        this.outputPath = outputPath;
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public String getFormat() { return format; }
    public String getOutputPath() { return outputPath; }
    public ErrorCorrectionLevel getErrorCorrectionLevel() { return errorCorrectionLevel; }
}
