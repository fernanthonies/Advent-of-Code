package common

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun GetData(day: Int, year: Int): List<String> {
    val cacheDirectory = createTempCacheDirectory()
    val client = HttpClient(CIO) {
        install(HttpCache) {
            val cacheFile = Files.createDirectories(Paths.get("build/cache")).toFile()
            publicStorage(FileStorage(cacheFile))
        }
    }
    val session = System.getenv("AOC_SESSION")

    return try {
        // Run the coroutine in a blocking way
        val responseBody: String = runBlocking {
            client.get("https://adventofcode.com/${year}/day/${day}/input") {
                cookie(name = "session", value = session)
            }.body()
        }

        responseBody.split("\n").dropLast(1)
    } finally {
        // Close the client
        client.close()
    }
}

fun createTempCacheDirectory(): File {
    val tempDir = System.getProperty("java.io.tmpdir")
    val cacheDir = File(tempDir, "ktor_cache_${System.nanoTime()}")
    if (cacheDir.mkdirs()) {
        println("Cache directory created at: ${cacheDir.absolutePath}")
    } else {
        println("Failed to create cache directory.")
    }

    return cacheDir
}