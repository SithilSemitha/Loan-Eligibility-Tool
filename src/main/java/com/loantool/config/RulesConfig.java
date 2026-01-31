package com.loantool.config;

public class RulesConfig {

    private static RulesConfig instance;

    private final double minIncomeThreshold = 50000;
    private final double maxDebtToIncomeRatio = 0.4;
    private final int minCreditScore = 600;
    private final int minEmploymentMonths = 6;
    private final double maxLoanToIncomeRatio = 10.0;

    private RulesConfig() {}

    public static RulesConfig getInstance() {
        if (instance == null) {
            instance = new RulesConfig();
        }
        return instance;
    }

    public double getMinIncomeThreshold() {
        return minIncomeThreshold;
    }

    public double getMaxDebtToIncomeRatio() {
        return maxDebtToIncomeRatio;
    }

    public int getMinCreditScore() {
        return minCreditScore;
    }

    public int getMinEmploymentMonths() {
        return minEmploymentMonths;
    }

    public double getMaxLoanToIncomeRatio() {
        return maxLoanToIncomeRatio;
    }
}
