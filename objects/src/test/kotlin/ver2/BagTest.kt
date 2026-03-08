package ver2

import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class BagTest {
    
    private lateinit var sut: Bag

    @Test
    fun `초대장이 없으면 false를 반환한다_hasInvitation`() {
        sut = Bag(
            amount = 10L,
        )

        kotlin.test.assertFalse(sut.hasInvitation, "초대장이 없어야 합니다.")
    }

    @Test
    fun `초대장이 있으면 true를 반환한다_hasInvitation`() {
        sut = Bag(
            amount = 10L,
            invitation = Invitation(LocalDateTime.now()),
        )

        kotlin.test.assertTrue(sut.hasInvitation, "초대장이 있어야 합니다.")
    }

    @Test
    fun `초기에는 티켓이 없다_hasTicket`() {
        sut = Bag(
            amount = 10L,
        )

        kotlin.test.assertFalse(sut.hasTicket, "초기에는 티켓이 없어야 합니다.")
    }

    @Test
    fun `돈을 차감하면 amount가 감소한다_minusAmount`() {
        sut = Bag(
            amount = 10L,
        )

        val amount = sut.minusAmount(5L)

        kotlin.test.assertEquals(5L, amount)
    }

    @Test
    fun `돈을 추가하면 amount가 증가한다_plusAmount`() {
        sut = Bag(
            amount = 10L,
        )

        val amount = sut.plusAmount(5L)

        kotlin.test.assertEquals(15L, amount)
    }

    @Test
    fun `티켓을 넣으면 true를 반환한다_hasTicket`() {
        val ticket = Ticket(5L)
        sut = Bag(
            amount = 10L,
            invitation = Invitation(LocalDateTime.now()),
            null
        )

        sut.minusAmount(ticket.fee)
        sut.ticket = ticket

        kotlin.test.assertTrue(sut.hasTicket, "넣은 티켓이 있어야 합니다.")
    }
}