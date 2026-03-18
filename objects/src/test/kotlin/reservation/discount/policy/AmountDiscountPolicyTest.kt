package reservation.discount.policy

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import reservation.Money
import reservation.Screening
import reservation.discount.condition.DiscountCondition


class AmountDiscountPolicyTest : BehaviorSpec({

    given("할인 조건이 만족될 때") {
        val stubScreening = mockk<Screening>()

        val stubDiscountCondition = mockk<DiscountCondition>()
        every { stubDiscountCondition.isSatisfied(any()) } returns true

        val sut = AmountDiscountPolicy(
            discountAmount = Money.wons(800L),
            stubDiscountCondition,
        )

        `when`("할인 금액을 계산하면") {
            val discountAmount = sut.calculateDiscountAmount(stubScreening)

            then("할인 금액이 적용된다.") {
                discountAmount shouldBe Money.wons(800L)
            }
        }
    }

    given("할인 조건이 만족되지 않을 때") {
        val stubScreening = mockk<Screening>()

        val stubDiscountCondition = mockk<DiscountCondition>()
        every { stubDiscountCondition.isSatisfied(any()) } returns false

        val sut = AmountDiscountPolicy(
            discountAmount = Money.wons(800L),
            stubDiscountCondition,
        )

        `when`("할인 금액을 계산하면") {
            val discountAmount = sut.calculateDiscountAmount(stubScreening)

            then("할인 금액이 적용되지 않는다.") {
                discountAmount shouldBe Money.ZERO
            }
        }
    }
})