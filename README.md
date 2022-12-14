# Datenberichterstattung nach der EU-Umgebungslärmrichtlinie – Lärmkartierung

## Voraussetzungen

Um die Transformationen ausführen zu können, muss zunächst die Datei `gradle.properties` der mindestens die
Einstellungen `configBasePath` und `haleCliExecutable` definiert (s. Abschnitt "Konfiguration").

Es muss eine Runtime-Umgebung von Java 8 zur Verfügung stehen. Ist Java 8 nicht die Standard-Java-Version, muss
vor dem Ausführen der Transformationsaufgaben die Umgebungvariable `JAVA_HOME` auf den Pfad zur Java-8-Installation
gesetzt werden:

Windows:

    set JAVA_HOME=C:/Pfad/zu/Java8

Linux/Mac:

    export JAVA_HOME=/path/to/Java8

## Konfiguration von hale

In der Datei `gradle.properties` können folgende Einstellungen vorgenommen werden:

- `configBasePath`: Pfad zum Ordner, der die Quelldaten und Transformationsprojekte enthält
- `haleCliExecutable`: Pfad zu `hale.bat` (Windows) bzw. `hale` (Linux/Mac) von [hale-cli](https://github.com/halestudio/hale-cli)
- `haleMaxHeapSize`: Maximale Speichermenge in MiB, die der hale CLI zugeteilt wird
- `systemProp.http.proxyHost`/`systemProp.https.proxyHost`: Hostname oder IP-Adresse des Proxy-Servers
- `systemProp.http.proxyPort`/`systemProp.https.proxyPort`: Port des Proxy-Servers
- `systemProp.http.proxyUser`/`systemProp.https.proxyUser`: Benutzername für den Proxy-Zugriff
- `systemProp.http.proxyPassword`/`systemProp.https.proxyPassword`: Passwort für Proxy-Zugriff
- `systemProp.http.nonProxyHosts`/`systemProp.https.nonProxyHosts`: Hosts, die direkt und nicht über den Proxy angesprochen werden sollen

Beispiele für alle Einstellungen befinden sich in der Datei `gradle.properties.sample`.

## Konfiguration der Transformationsprojekte

In der Datei `config.json` können Details zu den Transformationen konfiguriert werden:

- `targetEPSG`: EPSG-Code des CRS, in das Geometrien standardmäßig beim Export der transformierten Daten reprojiziert werden sollen
- `additionalEPSG`: weitere EPSG-Codes von CRS, für die Transformations-Tasks angeboten werden sollen
- `transformations`: Schlüssel, unter dem die verfügbaren Transformationen definiert werden
- `project`: Pfad zum Transformationsprojekt (relativ zum Pfad `configBasePath` aus `gradle.properties`)
- `sourceFolders`: Pfade zu Ordnern mit Quelldaten (relativ zu `configBasePath`)
- `targetFolder`: Pfad, in den das Transformationsergebnis geschrieben wird (relativ zu `configBasePath`)
- `targetFileName`: Dateiname für das Transformationsergebnis

## Ordnerstruktur

In der Standardkonfiguration wird folgende Ordnerstruktur unterhalb von `configBasePath` erwartet:

    <configBasePath>/
    ├─ agg/
    │  ├─ DF4_8_agglomerations_xls+shp-to-geopackage.halez
    │  ├─ input/
    │  │  ├─ aggair/
    │  │  ├─ aggrail/
    │  │  ├─ aggroad/
    │  │  ├─ aggind/
    │  ├─ output/
    ├─ majorair/
    │  ├─ DF4_8_majorairports_xls-to-geopackage-template.halez
    │  ├─ input/
    │  ├─ output/
    ├─ majorrail/
    │  ├─ DF4_8_majorrailways_xls+shp-to-geopackage.halez
    │  ├─ input/
    │  ├─ output/
    ├─ majorroad/
    │  ├─ DF4_8_majorroads_xls+shp-to-geopackage.halez
    │  ├─ input/
    │  ├─ output/

## Transformation

Mit dem Befehl `gradlew transform-all` können alle in `config.json` konfigurierten Transformationen ausgeführt werden.

Die Transformationen können über `gradlew transform-<name>-<EPSG>` auch einzeln ausgeführt (z.B. `gradlew transform-agg-3035`).
Eine Liste aller verfügbaren Transformationen kann mit `gradlew tasks` abgerufen werden.
