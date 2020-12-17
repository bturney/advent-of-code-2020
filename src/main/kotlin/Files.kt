import java.io.File

internal object Files {
    fun readFileAsList(fileName: String) = File(fileName).readLines()
    fun readFileAsListOfInt(fileName: String) = readFileAsList(fileName).map { it.toInt() }
}
