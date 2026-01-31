package com.loantool.algorithms;

import com.loantool.models.Applicant;
import com.loantool.config.RulesConfig;

import java.util.ArrayList;
import java.util.List;

public class EligibilityEngine {

    private final RulesConfig config;
    private String rejectionReason;

    public EligibilityEngine() {
        this.config = RulesConfig.getInstance();
    }

    public boolean isEligible(Applicant applicant) {

        // 1️⃣ Income check (salary)
        if (applicant.getSalary() < config.getMinIncomeThreshold()) {
            rejectionReason = "Income below minimum threshold";
            return false;
        }

        // 2️⃣ Debt-to-income ratio
        double debtRatio = applicant.getLoanAmount() / applicant.getSalary();
        if (debtRatio > config.getMaxDebtToIncomeRatio()) {
            rejectionReason = "Debt-to-income ratio too high";
            return false;
        }

        // 3️⃣ Credit score check
        if (applicant.getCreditScore() < config.getMinCreditScore()) {
            rejectionReason = "Credit score too low";
            return false;
        }

        return true;
    }

    public List<Applicant> evaluateEligibility(List<Applicant> applicants) {
        List<Applicant> eligibleApplicants = new ArrayList<>();

        for (Applicant applicant : applicants) {
            if (isEligible(applicant)) {
                applicant.setEligible(true);
                eligibleApplicants.add(applicant);
            }
        }

        return eligibleApplicants;
    }

    public String getRejectionReason(Applicant applicant) {
        isEligible(applicant);
        return rejectionReason;
    }
}
