@Grab('com.xlson.groovycsv:groovycsv:1.3')
import static com.xlson.groovycsv.CsvParser.parseCsv
import groovy.json.JsonBuilder
import java.nio.file.Paths

def fileName = args[0]
def locales = args.length > 1?args[1].split(","):[]
def targetPath = args.length > 2?args[2]:"."

println "File " + fileName
println "Locale " + locales
println "targetPath " + targetPath

fh = new File(fileName)
def csvContent = fh.getText('utf-8')

locales.each { locale ->
    def data = parseCsv(csvContent, separator: ',')
    def result = [:]
    data.eachWithIndex { item,index ->
        result[item[0]] = item[locale]
    }


    def json = new JsonBuilder()
    json result

    def outFileName = "locale-" + locale + ".json"
    def fullOutFileName = Paths.get(targetPath,outFileName).toString()
    println "Write to $outFileName"
    def outFile = new File(fullOutFileName)
    outFile.write(json.toPrettyString())
}

