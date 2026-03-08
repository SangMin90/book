package ver2

import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

class TicketOfficeTest {
    
    private lateinit var sut: TicketOffice
    private val FEE = 5000L
    
    @Test
    fun `관람객에게 티켓을 판매하면 티켓수가 감소한다_sellTicketTo`() {
        sut = TicketOffice(
            amount = 20000L,
            tickets = arrayOf(Ticket(FEE), Ticket(FEE))
        )

        sut.sellTicketTo(
            Audience(
                Bag(
                    amount = 10000L,
                    invitation = Invitation(LocalDateTime.now())
                )
            )
        )

        assertEquals(1, sut.ticketCount)
    }

    @Test
    fun `여러 관람객에게 티켓을 판매하면 티켓 수가 계속 감소한다_sellTicketTo`() {
        sut = TicketOffice(
            amount = 20000L,
            tickets = arrayOf(Ticket(FEE), Ticket(FEE))
        )
        val audience1 = Audience(
            Bag(
                amount = 10000L,
                invitation = Invitation(LocalDateTime.now())
            )
        )

        val audience2 = Audience(
            Bag(
                amount = 15000L,
            )
        )

        sut.sellTicketTo(audience1)
        sut.sellTicketTo(audience2)

        assertEquals(0, sut.ticketCount)
    }
}