package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 오름차순 테스트")
    @Test
    void 로또_번호_오름차순_테스트(){
        List<Integer> numbers = List.of(6, 5, 3, 4, 2, 1);
        Lotto lotto = new Lotto(numbers);

        // when
        List<Integer> result = lotto.getNumbers();

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
    @Test
    void 로또_번호중_범위_다른_숫자_테스트(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}