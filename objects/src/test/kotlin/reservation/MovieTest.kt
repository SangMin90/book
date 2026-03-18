package reservation

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import reservation.discount.policy.DiscountPolicy
import java.time.Duration

class MovieTest : BehaviorSpec({

    given("할인이 적용될 때") {
        val stubScreening = mockk<Screening>()
        val stubDiscountPolicy = mockk<DiscountPolicy>()
        every {
            stubDiscountPolicy.calculateDiscountAmount(stubScreening)
        } returns Money.wons(900L)

        val sut = Movie(
            title = "Avatar",
            runningTime = Duration.ofMinutes(120),
            fee = Money.wons(10_000L),
            stubDiscountPolicy
        )

        `when`("영화 관림비를 계산하면") {
            val movieFee = sut.calculateMovieFee(stubScreening)

            then("할인 금액이 적용된다.") {
                movieFee shouldBe Money.wons(9_100L)
            }
        }
    }

    given("할인이 적용되지 때") {
        val stubScreening = mockk<Screening>()
        val stubDiscountPolicy = mockk<DiscountPolicy>()
        every {
            stubDiscountPolicy.calculateDiscountAmount(stubScreening)
        } returns Money.ZERO

        val sut = Movie(
            title = "Avatar",
            runningTime = Duration.ofMinutes(120),
            fee = Money.wons(10_000L),
            stubDiscountPolicy
        )

        `when`("영화 관림비를 계산하면") {
            val movieFee = sut.calculateMovieFee(stubScreening)

            then("할인 금액이 적용되지 않는다.") {
                movieFee shouldBe Money.wons(10_000L)
            }
        }
    }
})