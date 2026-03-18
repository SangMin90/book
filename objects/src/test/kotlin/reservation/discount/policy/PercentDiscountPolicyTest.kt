package reservation.discount.policy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import reservation.Money
import reservation.Screening
import reservation.discount.condition.DiscountCondition

class PercentDiscountPolicyTest : BehaviorSpec({

    given("할인 조건이 만족될 때") {
        val stubScreening = mockk<Screening>()
        every { stubScreening.movieFee } returns Money.wons(10_000L)

        val stubDiscountCondition = mockk<DiscountCondition>()
        every { stubDiscountCondition.isSatisfied(any()) } returns true

        val sut = PercentDiscountPolicy(
            percent = 0.1,
            stubDiscountCondition,
        )

        `when`("할인 금액을 계산하면") {
            val discountAmount = sut.calculateDiscountAmount(stubScreening)

            then("할인율이 적용된다.") {

                discountAmount shouldBe 100L
            }
        }
    }
})