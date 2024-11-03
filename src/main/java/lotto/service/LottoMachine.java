package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoTicket ticket;
    private final List<Lotto> lottos;
    LottoMachine(LottoTicket ticket){
        this.ticket = ticket;
        lottos = issueLottoTickets();
    }
    public List<Lotto> getLottos(){
        return lottos;
    }

    private List<Lotto> issueLottoTickets(){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i<ticket.getCount();i++){
            lottos.add(randomLotto());
        }
        return lottos;
    }
    private Lotto randomLotto(){
        List<Integer> numbers = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return new Lotto(numbers);
    }

}