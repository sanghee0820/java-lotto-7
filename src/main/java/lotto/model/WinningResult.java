package lotto.model;

public enum WinningResult {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int normalCount;
    private final boolean bonusMatch;
    private final int reward;

    WinningResult(int normalCount, boolean bonusCount, int reward) {
        this.normalCount = normalCount;
        this.bonusMatch = bonusCount;
        this.reward = reward;
    }

    public static WinningResult of(int matchCount, boolean isBonusMatch) {
        for (WinningResult winningResult : values()) {
            if (winningResult.normalCount == matchCount && winningResult.bonusMatch == isBonusMatch) {
                return winningResult;
            }
        }
        return NONE;
    }

    public int getReward() {
        return reward;
    }
}
