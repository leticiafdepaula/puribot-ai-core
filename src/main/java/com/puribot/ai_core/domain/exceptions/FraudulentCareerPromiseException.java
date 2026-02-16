package com.puribot.ai_core.domain.exceptions;

public class FraudulentCareerPromiseException extends PuribotException {
  public FraudulentCareerPromiseException(String details) {
    super("⚖️ LEGAL ALERT: Fraudulent career promise detected. Details: " + details);
  }
}
