import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException


object InputReceiver {
    private const val year = "2022"
    const val defaultPath = "https://adventofcode.com/$year/day"
    val client = HttpClient(CIO)

    suspend fun get(forDay: Int): List<String> {
        val realPath = "$defaultPath/$forDay/input"
        val response = client.get(realPath) {
            cookie(
                "session",
                "53616c7465645f5fba948bb4f6ec7414ae506777a7964c0882ac55b52a6be3bce11919ee5a303efbc0b4ec114acb6ecfa4fb8c2e6ddf36c330994a7643ce9f04"
            )
        }
        val string: String = response.body()
        return string.split("\n")
    }

    suspend fun demo(demo: String): List<String> {
        return demo.split("\n")
    }
}

class FuckException : RuntimeException("Fuck")

fun main() = runBlocking {
    println(InputReceiver.get(1))
}