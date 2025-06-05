# 📦 Easy Codegen Lib - QRCode Generator

Uma biblioteca Java simples e extensível para geração de **QR Codes**, com suporte a formatações úteis como Wi-Fi, localização geográfica, links, textos personalizados, e muito mais.

---

## 🚀 Instalação

Adicione a dependência no seu `pom.xml`:

```xml
<dependency>
    <groupId>io.github.yancarlos99</groupId>
    <artifactId>easy-codegen-lib</artifactId>
    <version>1.0</version>
</dependency>
```

---

## ✨ Funcionalidades

- ✅ Geração de QR Code com configuração de tamanho, formato e correção de erro
- ✅ Geração de QR Code para conexão **Wi-Fi**
- ✅ Geração de QR Code com **geolocalização (Google Maps)**
- ✅ Uso da poderosa biblioteca [ZXing](https://github.com/zxing/zxing)

---

## 🧪 Exemplo de Uso

### 📸 1. Gerar um QR Code simples

```java
QRCode config = new QRCode(300, 300, "PNG", "output/qrcode.png", ErrorCorrectionLevel.L);
QRCodeGenerator.generateQRCode("https://meusite.com", config);
```

---

### 📶 2. QR Code de Wi-Fi

```java
QRCode config = new QRCode(300, 300, "PNG", "output/qrcode.png", ErrorCorrectionLevel.L);
String wifiData = QRCodeGenerator.forWifi("MinhaRede", "minhaSenha", "WPA");

QRCodeGenerator.generateQRCode(wifiData, config);
```

> 🔒 Tipos de criptografia suportados: `WEP`, `WPA`, `nopass`

---

### 📍 3. QR Code de localização geográfica

```java
QRCode config = new QRCode(300, 300, "PNG", "output/qrcode.png", ErrorCorrectionLevel.L);
String geoData = QRCodeGenerator.forGeoLocation(-23.55052, -46.633308);

QRCodeGenerator.generateQRCode(geoData, config);
```

---

## 🛠️ Estrutura do Projeto

```
easy-codegen-lib/
├── src/
│   ├── main/java/br/com/easy/codegen/qrcode/
│   │   ├── QRCodeGenerator.java
│   │   ├── QRCode.java
│   │   └── WifiEncryptionEnum.java
│   └── test/java/br/com/easy/codegen/qrcode/
│       └── QRCodeGeneratorTest.java
├── pom.xml
└── README.md
```

---

## ✅ Requisitos

- Java 17 ou superior (Java 21 recomendado)
- Maven 3.6+

---

## 📦 Build e Testes

Para compilar e rodar os testes automatizados:

```bash
mvn clean install
```

---

## 📥 Como contribuir

Sinta-se à vontade para:

- Criar issues com ideias ou bugs
- Abrir pull requests com novas funcionalidades (ex: suporte a PIX, vCard, etc)
- Compartilhar feedbacks e melhorias

---

## 🙌 Autor

Desenvolvido por Yan Carlos da Silva

---
