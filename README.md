# JavaFX Blockchain Smart Contract Simulator

## 🧩 Proje Özeti
Bu uygulama, JavaFX ile geliştirilmiş basit bir blockchain simülatörüdür. Tüm işlemler hem gönderen hem de alıcı tarafından onaylanmadan blockchain'e yazılmaz. Zaman aşımına uğrayan işlemler iptal edilir.

## ✨ Özellikler
- Çift taraflı işlem onayı
- Zaman aşımı ile işlem iptali
- Basit GUI arayüzü (JavaFX)
- İşlem listesi ve onay ekranı

## 🚀 Çalıştırmak için
1. Java 17+ kurulu olmalı.
2. JavaFX SDK indirilmiş ve `--module-path` ile ayarlanmış olmalı.
3. IntelliJ IDEA veya VSCode ile `MainApp` sınıfını çalıştırabilirsiniz.

## 🗂️ Proje Yapısı
- `Transaction.java`: İşlem modeli
- `SmartContract.java`: Onay ve kontrol mekanizması
- `MainController.java`: GUI denetleyicisi
- `main.fxml`: Arayüz
- `MainApp.java`: Giriş noktası

## 👨‍💻 Hazırlayan
- **Onur Atilla** (JavaFX - 2025 Bitirme Projesi)