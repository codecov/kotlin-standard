import codecov.uncovered_if
import codecov.fully_covered

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals


object TestIndex : Spek({
	describe("Test index.kt") {
		it("Test uncovered if") {
			assertEquals(expected = uncovered_if(), actual = false)
		}
		it("Test fully covered") {
			assertEquals(expected = fully_covered(), actual = true)
		}
	}
})
