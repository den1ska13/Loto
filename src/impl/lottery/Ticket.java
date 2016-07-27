package impl.lottery;

/**
 * Created by Denis on 27.07.2016.
 */
public class Ticket implements api.lottery.Ticket {

    private int[][] combination;
    private Integer ticketValue;
    private Long number;

    @Override
    public int[][] getCombination() {
        return combination;
    }

    @Override
    public Integer getTicketValue() {
        return ticketValue;
    }

    @Override
    public Long getNumber() {
        return number;
    }
    public Ticket(Long n, int[] [] c, Integer tv){
        combination = c;
        ticketValue = tv;
        number = n;

    }
}
