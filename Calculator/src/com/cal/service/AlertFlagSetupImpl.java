package com.cal.service;

public class AlertFlagSetupImpl implements AlertFlagSetup {
	static AlertFlagSetup alertFlagSetupImpl = new AlertFlagSetupImpl();
	boolean alertFlag;

	private AlertFlagSetupImpl() {
	}

	public static AlertFlagSetup getInstance() {
		return alertFlagSetupImpl;
	}

	@Override
	public void isCutOffDecimal(boolean alertFlag) {
		this.alertFlag = alertFlag;
	}

	@Override
	public boolean alertFlagResult() {
		return alertFlag;
	}

}
