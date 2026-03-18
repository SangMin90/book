package sale.ver2

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class AudienceTest : BehaviorSpec({

    given("초대장이 있는 관람객이 있을 때") {
        val bag = Bag(
            amount = 100_000L,
            invitation = Invitation(LocalDateTime.now())
        )
        val ticket = Ticket(10_000L)

        val sut = Audience(bag)

        `when`("티켓을 사면") {
            val price = sut.buy(ticket)

            then("돈을 내지 않는다.") {
                price shouldBe 0L
            }
        }
    }

    given("초대장이 없는 관람객이 있을 때") {
        val bag = Bag(amount = 100_000L)
        val ticket = Ticket(10_000L)

        val sut = Audience(bag)

        `when`("티켓을 사면") {
            val price = sut.buy(ticket)

            then("구매 금액으로 10_000원을 낸다.") {
                price shouldBe 10_000L
            }
        }
    }
})