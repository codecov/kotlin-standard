// Import to make requests
package codecov

import java.util.*
import kotlin.system.exitProcess
import com.beust.klaxon.Parser
import com.beust.klaxon.JsonObject


object Request {
    @JvmStatic
    fun main(args: Array<String>) {
        val url = "https://codecov.io/api/gh/codecov/Kotlin-Standard"
        val token = System.getenv("API_KEY")
        // Sleep 1 minute    
        Thread.sleep(60_000)
        // Make request
        val response = khttp.get(
            url = url,
            params = mapOf("token" to token)
        )
        // Get total code coverage from API response
        val commits = response.jsonObject.getJSONArray("commits")
        val commit = commits.getJSONObject(0)
        val totals = commit.getJSONObject("totals")
        val coverage = totals.getString("c")

        val expected_coverage = System.getenv("EXPECTED_COVERAGE")
        // Compare obtained code coverage with stored code coverage
        if (coverage == expected_coverage) {
            println("Success! Codecov's API returned the correct coverage percentage " + expected_coverage)
            exitProcess(0)
        }
        else {
            println("Whoops, something is wrong D: Codecov did not return the correct coverage percentage. Coverage percentage should be "+expected_coverage+" but Codecov returned "+coverage)
            exitProcess(1)
        }
    }

}
