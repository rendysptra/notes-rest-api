# Notes API

REST API sederhana untuk membuat dan membaca catatan. Project ini dibangun
dengan Spring Boot dan menggunakan Spring Data JPA untuk menyimpan data `Note`.

## Status Fitur

- `POST /v1/notes` untuk membuat catatan
- `GET /v1/notes` untuk mengambil semua catatan
- Validasi judul wajib diisi dan maksimal 255 karakter
- ID catatan dibuat sebagai UUID
- Catatan diurutkan berdasarkan waktu dibuat secara ascending

Operasi update, delete, pencarian, dan bookmark belum tersedia.

## Teknologi

- Java 26
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- H2 Database dan H2 Console
- Spring Validation
- Maven Wrapper

## Prasyarat

- Java Development Kit (JDK) 26
- Tidak perlu memasang Maven secara global karena project menyediakan Maven Wrapper

Periksa versi Java yang digunakan:

```bash
java --version
```

## Menjalankan Aplikasi

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
./mvnw.cmd spring-boot:run
```

Aplikasi akan berjalan pada `http://localhost:8080`.

## API

### Membuat Catatan

`POST /v1/notes`

Request body:

```json
{
	"title": "Belajar Spring Boot",
	"content": "Mempelajari REST API dan JPA",
	"url": "https://spring.io"
}
```

Contoh dengan `curl`:

```bash
curl -X POST http://localhost:8080/v1/notes \
	-H "Content-Type: application/json" \
	-d '{"title":"Belajar Spring Boot","content":"Mempelajari REST API dan JPA","url":"https://spring.io"}'
```

Respons berhasil menggunakan status `201 Created` dan berisi `id`, `title`,
`content`, `url`, `created`, serta `updated`.

`title` wajib berupa string yang tidak kosong dengan panjang 1 sampai 255
karakter. `content` dan `url` boleh dikosongkan.

### Mengambil Semua Catatan

`GET /v1/notes`

```bash
curl http://localhost:8080/v1/notes
```

Respons berhasil menggunakan status `200 OK` dan berupa array catatan yang
diurutkan berdasarkan waktu dibuat secara ascending.

## Menjalankan Test

Linux/macOS:

```bash
./mvnw test
```

Windows:

```powershell
./mvnw.cmd test
```

Saat ini tersedia smoke test untuk memastikan application context dapat dimuat.

## Membuat File JAR

```bash
./mvnw clean package
java -jar target/notes-0.0.1-SNAPSHOT.jar
```

## Struktur Project

```text
src/
├── main/
│   ├── java/com/rendysaptra/notes/
│   │   ├── controller/       # Endpoint REST
│   │   ├── domain/           # Request, DTO, dan entity Note
│   │   ├── mapper/           # Konversi domain object dan DTO
│   │   ├── repository/       # Akses data melalui Spring Data JPA
│   │   ├── service/          # Logika aplikasi
│   │   └── NotesApplication.java
│   └── resources/
│       ├── application.properties
│       ├── static/
│       └── templates/
└── test/
    └── java/com/rendysaptra/notes/
        └── NotesApplicationTests.java
```

## Pengembangan Berikutnya

- Menambahkan operasi update dan delete.
- Menambahkan filter atau pencarian catatan.
- Menambahkan test controller, service, dan validasi request.
- Menambahkan konfigurasi database yang eksplisit untuk lingkungan produksi.