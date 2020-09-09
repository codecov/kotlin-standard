// Import to make requests
package codecov

import kotlin.system.exitProcess

object Request {

    @JvmStatic
    fun main(args: Array<String>) {
        val url = "https://codecov.io/api/gh/codecov/Kotlin-Standard"
        // Sleep 1 minute
        Thread.sleep(60_000)
        // Make request
        val response = khttp.get(url = url)
        // Get total code coverage from API response
        val commits = response.jsonObject.getJSONArray("commits")
        val commit = commits.getJSONObject(0)
        val totals = commit.getJSONObject("totals")
        val coverage = totals.getString("c")

        val expectedCoverage = System.getenv("EXPECTED_COVERAGE")
        // Compare obtained code coverage with stored code coverage
        if (coverage == expectedCoverage) {
            println("Success! Codecov's API returned the correct coverage percentage $expectedCoverage")
            exitProcess(0)
        } else {
            println("Whoops, something is wrong D: Codecov did not return the correct coverage percentage. Coverage percentage should be $expectedCoverage but Codecov returned $coverage")
            exitProcess(1)
        }
    }
}
