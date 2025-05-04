# Dokumentacja Projektu „Katalog Sprzętu”

## 1. Opis ogólny

Aplikacja służy do katalogowania i zarządzania sprzętem domowym. Umożliwia dodawanie, przeglądanie oraz wyszukiwanie informacji o urządzeniach wraz z powiązanymi dokumentami i zdjęciami.

## 2. Funkcjonalności aplikacji

* Dodawanie sprzętu wraz z opisem:

  * Nazwa przedmiotu
  * Producent
  * Data zakupu
  * Ilość sztuk
  * Opcjonalnie cena zakupu
  * Zdjęcia, paragony i instrukcje (pliki)

* Wyszukiwanie sprzętu:

  * Pełnotekstowe wyszukiwanie po nazwie
  * Filtry po producencie, cenie, zakresie dat

* Proste zabezpieczenie dostępu (podstawowe uwierzytelnianie)

## 3. Architektura rozwiązania

```
+-------------------------------------------+
|                  Frontend                 |
|               React aplikacja             |
|         (testy jednostkowe: Jest)         |
+---------------------+---------------------+
                      |
                      | REST API (JSON)
                      v
+------------------------------------------------------------+
|                          Backend                           |
|                      Spring Boot API                       |
|              (BasicAuth, REST Controllers)                 |
|          (Testy jednostkowe/integracyjne: JUnit)           |
|   (Testy E2E/API: Testcontainers, REST-assured lub MockMvc)|
+----------+----------------------+---------------------------+
           |                      |
           v                      v
+-------------------+      +---------------+
|     MongoDB 📦    |      |   Amazon S3   |
| Elastyczny schemat|      |  (na pliki)   |
|     (Testcontainers      |               |
| do testów integracyjnych)|               |
+-------------------+      +---------------+
```

## 4. Technologie

### Frontend

* React
* Jest (testy)

### Backend

* Spring Boot
* MongoDB
* Amazon S3 (przechowywanie plików)
* Elasticsearch (opcjonalne wyszukiwanie pełnotekstowe)

### Testowanie

* Jednostkowe: JUnit, Mockito (Backend), Jest (Frontend)
* Integracyjne/E2E: Testcontainers, REST-assured

## 5. Struktura projektu (backend)

```
src/main/java/pl/katalogsprzetu/
├── controller
├── service
├── repository
├── model
└── config

src/test/java/pl/katalogsprzetu/
├── controller
├── service
├── repository
└── integration
```

## 6. Dalsze kroki

* Konfiguracja środowiska developerskiego
* Implementacja podstawowych endpointów REST API
* Integracja z AWS S3
* Implementacja i konfiguracja testów jednostkowych oraz integracyjnych
* Implementacja frontendu (React)

---

Dokumentacja będzie aktualizowana wraz z postępami prac.
