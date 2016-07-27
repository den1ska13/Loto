package impl.lottery;

import api.lottery.*;
import api.lottery.Lottery;
import api.lottery.Ticket;


import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Denis on 27.07.2016.
 */
public class Service implements api.lottery.Service {

    private Long numoflot;
    private Long numoftick;

    Map<Long,Lottery> listlot = new HashMap<Long,Lottery>();

    @Override
    public Double takeMoney(Long lotteryNumber, Ticket ticket) {

        return listlot.get(lotteryNumber).takeMoney(ticket);
    }

    @Override
    public List<Ticket> getLotteryTickets(Long lotteryNumber) {

        return listlot.get(lotteryNumber).getLotteryTickets();
    }

    @Override
    public Long performNewLottery(Lottery.Type type) {
        ++numoflot;
        Set<Integer> generated = new HashSet<Integer>();
        Random r = new Random();
        while (generated.size() < 100) {
            generated.add(r.nextInt(10000) + 1);
        }
        ArrayList a = new ArrayList();
        a.addAll(generated);

        List<Ticket> l = new ArrayList<Ticket>();

        numoftick = 0L;
        for (int i=0 ; i<100;i++){
            int[][] ra = new int[1][2];
            ra[0][0] = i;
            ra[0][1] = 100-i;
            l.add(new impl.lottery.Ticket(numoftick, ra, a.get(i).hashCode()));
            ++numoftick;
        }

        listlot.put(numoflot,new impl.lottery.Lottery(l, numoflot, type));

        return numoflot;

    }

    @Override
    public void endLottery(Long lotteryNumber) {
        listlot.remove(lotteryNumber);
    }

    public Service(){

        numoflot = (long) (0);
    }
}
