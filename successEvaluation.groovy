def summaryFile = new File('Zusammenfassung.log')

def sourceFileUrl = new URL(aggregated['eu.esdihumboldt.hale.io.instance.read.source'].report.location)
def sourceFile = new File(sourceFileUrl.toURI())

if (aggregated['eu.esdihumboldt.hale.transform'].report.errors > 0) {
    summaryFile << "\u274c ${sourceFile.getAbsolutePath()} - Validierungsfehler\n"
    println ""
    println "${(char)27}[31;49m!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    println '!!! Validierung war nicht erfolgreich, bitte Fehlermeldungen im Log beachten !!!'
    println '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    System.exit(-1)
}
else {
    summaryFile << "\u2705 ${sourceFile.getAbsolutePath()} - OK\n"
}

// the transformation must have been completed
assert aggregated['eu.esdihumboldt.hale.transform'].report.completed == true
// without errors
assert aggregated['eu.esdihumboldt.hale.transform'].report.errors == 0 : "Anzahl der Validierungsfehler > 0"

