package lotto.domain.dto;

import lotto.domain.entity.Prize;
import lotto.domain.entity.PrizeEntry;
import lotto.domain.entity.YieldRate;

import java.util.Map;

import static java.util.stream.Collectors.joining;

public class LottoResult {

  private static final String WINNING_STATS_MESSAGE = "당첨 통계";
  private static final String UNDER_BAR = "-----------";
  private static final String RESULT_MATCHED_MESSAGE = "%d개 일치";
  private static final String RESULT_BONUS_STATS_MESSAGE = ", 보너스 볼 일치";
  private static final String RESULT_STATS_MESSAGE = " (%d원) - %d개";
  private static final String RESULT_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
  private static final String RESULT_YIELD_LESS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private static final String RESULT_YIELD_MORE_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득라는 의미임)";
  private static final int ZERO = 0;

  private final PrizeEntry prizeEntry;
  private final YieldRate yieldRate;
  private final StringBuilder stringBuilder;

  public LottoResult(PrizeEntry prizeEntry, YieldRate yieldRate) {
    this.prizeEntry = prizeEntry;
    this.yieldRate = yieldRate;
    stringBuilder = new StringBuilder();
  }

  @Override
  public String toString() {
    stringBuilder.setLength(ZERO);

    stringBuilder.append(WINNING_STATS_MESSAGE).append(System.lineSeparator())
                 .append(UNDER_BAR).append(System.lineSeparator());

    stringBuilder.append(prizeToString()).append(System.lineSeparator());
    stringBuilder.append(String.format(RESULT_YIELD_MESSAGE, yieldRate.getRate()));
    stringBuilder.append(getYieldResultMessage());


    return stringBuilder.toString();
  }

  private String prizeToString() {
   return prizeEntry.stream()
                    .filter(entry -> entry.getKey() != Prize.MISS)
                    .map(entry -> String.format(setResultMessage(entry),
                                           entry.getKey().getMatchedCount(),
                                           entry.getKey().getReward(),
                                           entry.getValue()))
                    .collect(joining(System.lineSeparator()));
  }

  private String setResultMessage(Map.Entry<Prize, Integer> entry) {
    String result = RESULT_MATCHED_MESSAGE;
    if (entry.getKey() == Prize.SECOND){
      result = RESULT_MATCHED_MESSAGE.concat(RESULT_BONUS_STATS_MESSAGE);
    }
    return result.concat(RESULT_STATS_MESSAGE);
  }

  private String getYieldResultMessage() {
    if (yieldRate.isYieldRateLessThanOne()) {
      return RESULT_YIELD_LESS_MESSAGE;
    }
    return RESULT_YIELD_MORE_MESSAGE;
  }

}