def summaryFile = new File('Zusammenfassung.log')

def sourceFileUrl = aggregated['eu.esdihumboldt.hale.io.instance.read.source'].report.location
if ([Collection, Object[]].any { it.isAssignableFrom(sourceFileUrl.getClass()) }) {
    sourceFileUrl = new URL(sourceFileUrl[0])
}
else {
    sourceFileUrl = new URL(sourceFileUrl)
}
def sourceFile = new File(sourceFileUrl.toURI())

def outputFileUrl = aggregated['eu.esdihumboldt.hale.io.instance.write.transformed'].report.location
if ([Collection, Object[]].any { it.isAssignableFrom(outputFileUrl.getClass()) }) {
    outputFileUrl = new URL(outputFileUrl[0])
}
else {
    outputFileUrl = new URL(outputFileUrl)
}
def outputFile = new File(outputFileUrl.toURI())

def reportedFile
if (outputFileUrl.toString().contains('validation')) {
    reportedFile = sourceFile
}
else {
    reportedFile = outputFile
}

def validationType
def targetSchema = aggregated['eu.esdihumboldt.hale.io.schema.read.target'].report.location
if (targetSchema.toString().contains('CoverageArea')) {
    validationType = 'Gültigkeitsbereich'
}
else {
    validationType = 'Lärmaktionsplan'
}

if (aggregated['eu.esdihumboldt.hale.transform'].report.errors > 0) {
    summaryFile << "\u274c ${reportedFile.getAbsolutePath()} (${validationType}) - Validierungsfehler\n"
    println ""
    println "${(char)27}[31;49m!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
    println '!!! Validierung war nicht erfolgreich, bitte Fehlermeldungen im Log beachten !!!'
    println '!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'
    System.exit(-1)
}
else {
    summaryFile << "\u2705 ${reportedFile.getAbsolutePath()} (${validationType}) - OK\n"
}

// the transformation must have been completed
assert aggregated['eu.esdihumboldt.hale.transform'].report.completed == true
// without errors
assert aggregated['eu.esdihumboldt.hale.transform'].report.errors == 0 : "Anzahl der Validierungsfehler > 0"

