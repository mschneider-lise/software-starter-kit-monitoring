# Aufgaben

## Setup
1. Infrastruktur mit `docker-compose up -d` starten.
2. Die Spring Boot App starten.
3. Verifizieren, ob alles korrekt läuft: Die einzelnen Endpunkte aufrufen (siehe README)
4. In der Prometheus UI oder Grafana überprüfen, ob Metriken vorhanden sind (als Label-Filter kann z.B. "job" verwendet werden). Überprüft vor allem, ob Metriken der Spring Boot App verfügbar sind.
5. In Grafana überprüfen, ob Logs vorhanden sind (als Label-Filter kann z.B. "container" oder "app" verwendet werden). Überprüft vor allem, ob Logs der Spring Boot App verfügbar sind.

## API
Stellt in der Spring Boot App folgende Endpunkte bereit:

1. `/info` -> Erzeugt einen Log-Eintrag mit Level "Info".
2. `/error` -> Wirft eine Exception, die über ein ControllerAdvice gefangen und geloggt wird. Reichert den Log-Eintrag um einen festen "Error Code" und eine dynamische "Trace Id" (UUID) an.
3. `/custom-counter` -> Lässt einen Counter hochzählen, den ihr vorher selber registrieren müsst.

## Grafana
Erstellt ein neues Grafana Dashboard und folgende Visualisierungen:
1. CPU und RAM Verbrauch (entweder von der Node oder der Spring Boot App).
2. "Up"-Status der Spring Boot App.
3. Informationen über die Endpunkte der Spring Boot App (z.B. Response Time, Requests per Second oder Gesamtanzahl Aufrufe im Intervall).
4. Verlauf eures Custom Counters.
5. Log-Einträge der Spring Boot App. Passt die Visualisierung so an (oder erstellt eine Kopie), dass nur Log-Einträge angezeigt werden, die vom Log-Level "Error" sind.
6. (Bonus) Filtert die Logs über die Eingabe der Trace Id

## Alerts
1. Erstellt einen Alert für den Custom Counter, der ab einem bestimmten Grenzwert feuert
2. (Bonus) Richtet einen Teams Webhook für den Alert ein
3. Überprüft, ob der Alert feuert, wenn der Custom Counter den festgelegten Grenzwert übersteigt
