package sale.ver1

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class TheaterTest : BehaviorSpec({

    given("초대권이 있는 관람객이 있을 때") {

        val ticket = Ticket(10_000L)
        val office = TicketOffice(
            amount = 90_000L,
            ticket
        )
        val seller = TicketSeller(office)
        val audience = Audience(
            Bag(
                amount = 100_000L,
                invitation = Invitation(LocalDateTime.now())
            )
        )

        val sut = Theater(seller)

        `when`("입장하면") {
            sut.enter(audience)

            then("티켓만 받고 돈은 받지 않는다.") {
                audience.bag.ticket shouldBe ticket
                audience.bag.amount shouldBe 100_000L
            }
        }
    }

    given("초대권이 없는 관람객이 있을 때") {

        val ticket = Ticket(10_000L)
        val office = TicketOffice(
            amount = 90_000L,
            ticket
        )
        val seller = TicketSeller(office)
        val audience = Audience(Bag(amount = 100_000L))

        val sut = Theater(seller)

        `when`("입장하면") {
            sut.enter(audience)

            then("돈을 지불하고 티켓을 받는다.") {
                audience.bag.ticket shouldBe ticket
                audience.bag.amount shouldBe 90_000L
            }
        }
    }
})