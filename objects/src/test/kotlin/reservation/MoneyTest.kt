package reservation

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MoneyTest : BehaviorSpec({

    given("한 Money가 있을 때") {
        val sut = Money.wons(10_000L)

        `when`("10을 곱하면") {
            val result = sut * 10L

            then("100_000이 된다.") {
                result shouldBe Money.wons(100_000L)
            }
        }

        `when`("10%를 곱하면") {
            val result = sut * 0.1

            then("1_000이 된다.") {
                result shouldBe Money.wons(1_000L)
            }
        }
    }

    given("두 Money가 있을 때") {
        val money1 = Money.wons(900L)
        val money2 = Money.wons(100L)

        `when`("더하면") {
            val result = money1 + money2

            then("금액이 합쳐진다.") {
                result shouldBe Money.wons(1_000L)
            }
        }

        `when`("빼면") {
            val result = money1 - money2

            then("차액이 반환된다.") {
                result shouldBe Money.wons(800L)
            }
        }
    }
})