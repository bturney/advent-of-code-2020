package com.turney.advent

import java.io.File
import java.lang.IllegalArgumentException

internal object Files {

    fun readFileAsList(fileName: String) = File(fileName.toURI()).readLines()

    fun readFileAsListOfInt(fileName: String) = readFileAsList(fileName).map { it.toInt() }

    fun readFileAsText(fileName: String) = File(fileName.toURI()).readText()

    private fun String.toURI() =
        Files.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find file: $this")
}
