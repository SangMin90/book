package reservation.discount.condition

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import reservation.Screening

class SequenceConditionTest : BehaviorSpec({

    given("첫번째 상영일 때") {
        val stubScreening = mockk<Screening>()
        every { stubScreening.isSequence(1) } returns true

        val sut = SequenceCondition(1)

        `when`("할인 조건을 검사하면") {
            val result = sut.isSatisfied(stubScreening)

            then("할인 조건을 만족한다.") {
                result shouldBe true
            }
        }
    }

    given("첫번째 상영이 아닐 때") {
        val stubScreening = mockk<Screening>()
        every { stubScreening.isSequence(1) } returns false

        val sut = SequenceCondition(1)

        `when`("할인 조건을 검사하면") {
            val result = sut.isSatisfied(stubScreening)

            then("할인 조건을 만족한다.") {
                result shouldBe false
            }
        }
    }
})