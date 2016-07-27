package impl.lottery;

import api.lottery.Ticket;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;


/**
 * Created by Denis on 27.07.2016.
 */
public class Lottery implements api.lottery.Lottery {
    private List<Ticket> list;
    private Long lotteryNumber;
    private Type type;
    private Double money;
    private int [] [] winCombinations = new int[5][2];
    private int [] winT = new int[5];

    public Lottery (List<Ticket> tic, Long l, Type t){
        list = tic;
        lotteryNumber = l;
        type = t;
        performLottery();
    }

    @Override
    public Double takeMoney(Ticket ticket) {
        for (int i=0;i<5;i++) {
            if (ticket.getNumber() == winT[i]) return 10d;
        }
        return null;
    }

    @Override
    public int[][] getWinCombinations() {
        return winCombinations;
    }

    @Override
    public List<Ticket> getLotteryTickets() {
        return list;
    }

    @Override
    public Long getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void performLottery() {
        int v = 0;

        Random r = new Random();
        for (int i=0;i<5;i++) {
            winT[i] = r.nextInt(100);
        }
        for (int i=0;i<100;i++) {
            for (int j=0;j<winT.length;j++) {
                if (winT[j]==i) {
                    winCombinations[v][0] = list.get(i).getCombination()[0][0];
                    winCombinations[v][1] = list.get(i).getCombination()[0][1];
                    v++;
                    break;
                }
            }
        }


    }


}
