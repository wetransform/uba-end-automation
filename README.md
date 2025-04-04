# Datenberichterstattung nach der EU-Umgebungslärmrichtlinie

## Voraussetzungen

Um die Transformationen ausführen zu können, muss zunächst die Datei `gradle.properties` der mindestens die
Einstellungen `configBasePath` und `haleCliExecutable` definiert (s. Abschnitt "Konfiguration").

Es muss eine Runtime-Umgebung von Java 17 zur Verfügung stehen. Ist Java 17 nicht die Standard-Java-Version, muss
vor dem Ausführen der Transformationsaufgaben die Umgebungvariable `JAVA_HOME` auf den Pfad zur Java-17-Installation
gesetzt werden:

Windows:

    set JAVA_HOME=C:/Pfad/zu/Java17

Linux/Mac:

    export JAVA_HOME=/path/to/Java17

Damit Umlaute und andere Sonderzeichen unter Windows korrekt angezeigt werden, muss zusätzlich folgender Befehl
ausgeführt werden, um die Codepage der Eingabeaufforderung auf UTF-8 umzustellen:

Windows:

    chcp 65001

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

## Datenfluss 4_8

### Konfiguration der Transformationsprojekte

In der Datei `config.json` können Details zu den Transformationen konfiguriert werden:

- `targetEPSG`: EPSG-Code des CRS, in das Geometrien standardmäßig beim Export der transformierten Daten reprojiziert werden sollen
- `additionalEPSG`: weitere EPSG-Codes von CRS, für die Transformations-Tasks angeboten werden sollen
- `transformations`: Schlüssel, unter dem die verfügbaren Transformationen definiert werden
- `project`: Pfad zum Transformationsprojekt (relativ zum Pfad `configBasePath` aus `gradle.properties`)
- `sourceFolders`: Pfade zu Ordnern mit Quelldaten (relativ zu `configBasePath`)
- `targetFolder`: Pfad, in den das Transformationsergebnis geschrieben wird (relativ zu `configBasePath`)
- `targetFileName`: Dateiname für das Transformationsergebnis

### Ordnerstruktur

Für den Datenfluss 4_8 wird in der Standardkonfiguration folgende Ordnerstruktur unterhalb von `configBasePath` erwartet:

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

### Transformation

Mit dem Befehl `gradlew transform-all` können alle in `config.json` konfigurierten Transformationen ausgeführt werden.

Die Transformationen können über `gradlew transform-<name>-<EPSG>` auch einzeln ausgeführt (z.B. `gradlew transform-agg-3035`).
Eine Liste aller verfügbaren Transformationen kann mit `gradlew tasks` abgerufen werden.

## Datenfluss 7_10

### Ordnerstruktur

Für den Datenfluss 7_10 wird in der Standardkonfiguration folgende Ordnerstruktur unterhalb von `configBasePath` erwartet:

    <configBasePath>/
    ├─ agg/
    │  ├─ UBA-DE_AGG_to_END_DF7_10_Agglomerations.halez
    │  ├─ DF7_10_Agglomerations_Aggregations.halez
    │  ├─ input/
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ output/
    │  ├─ validation/
    ├─ majorair/
    │  ├─ UBA-DE_GFH_to_END_DF7_10_Airports.halez
    │  ├─ DF7_10_Airports_Aggregations.halez
    │  ├─ input/
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ output/
    │  ├─ validation/
    ├─ majorrail/
    │  ├─ UBA-DE_HES_to_END_DF7_10_Railway.halez
    │  ├─ DF7_10_Railway_Aggregations.halez
    │  ├─ input/
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ output/
    │  ├─ validation/
    ├─ majorroad/
    │  ├─ UBA-DE_HVS_to_END_DF7_10_Roads.halez
    │  ├─ DF7_10_Roads_Aggregations.halez
    │  ├─ input/
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  |  |  ├─ LAP_Gebiet.shp (+ zugehörige Dateien, optional)
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ output/
    │  ├─ validation/
    ├─ quiet_areas/
    │  ├─ UBA-DE_RuhigeGebieteLage_to_DF7_10_QuietAreas.halez
    │  ├─ DF7_10_QuietAreas_Aggregations.halez
    │  ├─ input/
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  |  |  ├─ LAP_Ruhige_Gebiete_Lage.shp (+ zugehörige Dateien)
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ input_agglomerations/   <== für die Ableitung ruhiger Gebiete bei Ballungsräumen
    |  │  ├─ <Plan_1>/
    |  |  |  ├─ <Plandatei_UBA>.xlsx
    |  |  |  ├─ LAP_Ruhige_Gebiete_Lage.shp (+ zugehörige Dateien)
    |  │  ├─ <Plan_2>/
    |  │  ├─ ...
    |  │  ├─ <Plan_n>/
    │  ├─ output/
    │  ├─ validation/
    ├─ coverage_areas/
    │  ├─ UBA-DE_Gebiet_to_DF7_10_CoverageArea.halez
    │  ├─ DF7_10_CoverageArea_Aggregations.halez
    │  ├─ VG250/
    |  │  ├─ VG250_GEM.shp (+ zugehörige Dateien)
    |  │  ├─ VG250_RBZ.shp (+ zugehörige Dateien)
    |  │  ├─ VG250_VWG.shp (+ zugehörige Dateien)

### Validierung

In einem ersten Schritt müssen die Excel-Vorlagen validiert und in das von der EEA vorgegebene Format überführt werden.
Mit dem Befehl `gradlew validate-all` können alle in der Datei `config.json` konfigurierten Validierungen ausgeführt werden.

Die Validierungen für die Pläne und Gültigkeitsbereiche können mit `gradlew validate-nap-<lärmquelle>-<planname>-plan` bzw.
`gradlew validate-nap-<lärmquelle>-<planname>-coveragearea` auch einzeln ausgeführt werden. Eine Liste aller verfügbaren
Validierungen kann mit `gradlew tasks` abgerufen werden.

Bei jedem Validierungslauf wird eine Liste der durchgeführten Validierungen in der Datei `Zusammenfassung.log`
angehängt, die das Ergebnis für jede validierte Eingabedatei zeigt. Die Datei `Zusammenfassung.log` wird in dem Ordner
angelegt, der in der Konfigurationseinstellung `configBaseBath` angegeben ist.

Die detaillierten Log-Ausgaben und Berichte werden im jeweiligen Ausgabeverzeichnis des validierten Plans
(z. B. `<configBasePath>/majorroad/validation/Plan_1`) abgelegt. Folgende Dateien werden erzeugt:

- `DF7_10_NAP_<Lärmquelle>_<Planname>.xlsx` - Ins EEA-Format überführter Plan
- `LAP_Gebiet_<Planname>.gpkg` - Abgeleiteter Gültigkeitsbereich
- `out.log` - Standardausgabe (stdout)
- `err.log` - Standardfehlerausgabe (stderr)
- `reports.out` - hale-Berichtsdatei
- `statistics.json` - Statistikdatei im JSON-Format

Im Unterverzeichnis `logs_coverage_area` werden außerden die Log-Ausgaben und Berichte für die Ableitung der
Gültigkeitsbereiche abgelegt:

- `out.log` - Standardausgabe (stdout)
- `err.log` - Standardfehlerausgabe (stderr)
- `reports_coveragearea.out` - hale-Berichtsdatei zur Ableitung des Gültigkeitsbereichs
- `statistics_coveragearea.json` - Statistikdatei im JSON-Format zur Ableitung des Gültigkeitsbereichs

#### Ruhige Gebiete

Bei der Validierung ruhiger Gebiete muss ein Sonderfall beachtet werden. Im Fall von Lärmaktionsplänen für Ballungsräume
müssen die Eingabedateien abweichend in Verzeichnissen unterhalb von `quiet_areas/input_agglomerations` abgelegt werden.
Für alle anderen Planarten müssen die Dateien in Verzeichnissen unterhalb von `quiet_areas/input` abgelegt werden.

Die zugehörigen Validierungstasks heißen:

- `validate-nap-quietareas-agglomerations-all` bzw. `validate-nap-quietareas-agglomerations-<planname>` für Ballungsräume
- `validate-nap-quietareas-all` bzw. `validate-nap-quietareas-<planname>` für alle anderen Plantypen

### Aggregation

Alle ins EEA-Format überführten Excel-Vorlagen können dann in einem zweiten Schritt aggregiert werden. Mit dem Befehl
`gradlew aggregate-all` können alle in der Datei `config.json` konfigurierten Aggregationen ausgeführt werden.

Die Aggregation umfasst auch solche Pläne, bei denen Validierungsfehler aufgetreten sind, d. h. die Ausgabedatei der
Aggregation wird ebenfalls Validierungsfehler aufweisen. Um Pläne mit Validierungsfehlern von der Aggregation auszunehmen,
muss das entsprechende Planverzeichnis aus dem Validierungsordner (z. B. `<configBasePath>/majorroad/validation`) entfernt
oder von dort verschoben werden.

Die Aggregationen für die Pläne und Gültigkeitsbereiche können mit `gradlew aggregate-nap-<lärmquelle>-plan` bzw.
`gradlew aggregate-nap-<lärmquelle>-coveragearea` auch einzeln ausgeführt werden. Eine Liste aller verfügbaren
Aggregationen kann mit `gradlew tasks` abgerufen werden.

Bei jedem Aggregationslauf wird eine Liste der durchgeführten Aggregationen in der Datei `Zusammenfassung.log`
angehängt, die das Ergebnis für jede aggregierte Ausgabedatei zeigt. Die Datei `Zusammenfassung.log` wird in dem Ordner
angelegt, der in der Konfigurationseinstellung `configBaseBath` angegeben ist.

Die detaillierten Log-Ausgaben und Berichte werden im Ausgabeverzeichnis der Quelle
(z. B. `<configBasePath>/majorroad/output`) abgelegt. Folgende Dateien werden erzeugt:

- `<Vorlagenname>_aggregated.xlsx` - Aggregierte Daten
- `LAP_Gebiet_nap-<Lärmquelle>_aggregated.gpkg` - Aggregierte Gültigkeitsbereiche
- `out.log` - Standardausgabe (stdout)
- `err.log` - Standardfehlerausgabe (stderr)
- `reports.out` - hale-Berichtsdatei
- `statistics.json` - Statistikdatei im JSON-Format

Im Unterverzeichnis `logs_coverage_area` werden außerden die Log-Ausgaben und Berichte für die Ableitung der
Gültigkeitsbereiche abgelegt:

- `out.log` - Standardausgabe (stdout)
- `err.log` - Standardfehlerausgabe (stderr)
- `reports_coveragearea.out` - hale-Berichtsdatei zur Ableitung des Gültigkeitsbereichs
- `statistics_coveragearea.json` - Statistikdatei im JSON-Format zur Ableitung des Gültigkeitsbereichs

## Bekannte Probleme

Bei der Ausführung der Gradle-Aufgaben kann es vermehrt zu den u. a. oder ähnlichen Konsolenausgaben kommen. Die Meldungen
haben  keinen Einfluss auf die Ergebnisse der Transformation, Validierung oder Aggregation und können ignoriert werden.

```
INFO e.e.h.c.h.i.ProjectTransformationEnvironment(124) - No advisor for action eu.esdihumboldt.hale.lookup.import given, using advisor registered through extension point.
```

```
ERROR c.o.o.c.s.f.OMMapBufferEntry(47) - Error on calling Sun's MMap buffer clean
java.lang.IllegalAccessException: class com.orientechnologies.orient.core.storage.fs.OMMapBufferEntry cannot access interface sun.nio.ch.DirectBuffer (in module java.base) because module java.base does not export sun.nio.ch to unnamed module @3f191845
        at java.base/jdk.internal.reflect.Reflection.newIllegalAccessException(Reflection.java:392)
        at java.base/java.lang.reflect.AccessibleObject.checkAccess(AccessibleObject.java:674)
        at java.base/java.lang.reflect.Method.invoke(Method.java:560)
        at com.orientechnologies.orient.core.storage.fs.OMMapBufferEntry.close(OMMapBufferEntry.java:128)
        at com.orientechnologies.orient.core.storage.fs.OMMapManagerNew.closeEntry(OMMapManagerNew.java:451)
        at com.orientechnologies.orient.core.storage.fs.OMMapManagerNew.removeEntry(OMMapManagerNew.java:482)
        at com.orientechnologies.orient.core.storage.fs.OMMapManagerNew.flush(OMMapManagerNew.java:190)
        at com.orientechnologies.orient.core.storage.impl.local.OStorageLocal.close(OStorageLocal.java:360)
        at com.orientechnologies.orient.core.storage.impl.local.OStorageLocal.delete(OStorageLocal.java:392)
        at com.orientechnologies.orient.core.db.raw.ODatabaseRaw.drop(ODatabaseRaw.java:166)
```
