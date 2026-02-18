package com.puribot.ai_core.domain.exceptions;

public class InvalidSystemDNAException extends PuribotException {
  public InvalidSystemDNAException(String s) {
    super("🚨 CRITICAL: System DNA Mismatch. Unauthorized source code modification detected.");
  }
}
