package sale.ver1

import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TheaterTest {

    private lateinit var sut: Theater
    private val FEE = 5000L

    @Test
    fun `초대장이 없으면 티켓값을 지불하고 입장한다_enter`() {
        sut = Theater(
            TicketSeller(
                TicketOffice(
                    amount = 10000L,
                    tickets = arrayOf(Ticket(FEE), Ticket(FEE))
                )
            )
        )
        val audience = Audience(Bag(20000L))

        sut.enter(audience)

        assertTrue(audience.bag.hasTicket)
        assertEquals(1,
            sut.ticketSeller.ticketOffice.ticketCount
        )
        assertEquals(15000L, audience.bag.amount)
    }

    @Test
    fun `초대장이 있으면 돈을 내지 않고 티켓을 받고 입장한다_enter`() {
        sut = Theater(
            TicketSeller(
                TicketOffice(
                    amount = 10000L,
                    tickets = arrayOf(Ticket(FEE), Ticket(FEE))
                )
            )
        )
        val audience = Audience(
            Bag(20000L,
                Invitation(LocalDateTime.now())
            )
        )

        sut.enter(audience)

        assertTrue(audience.bag.hasTicket)
        assertEquals(1,
            sut.ticketSeller.ticketOffice.ticketCount
        )
        assertEquals(20000L, audience.bag.amount)
    }
}