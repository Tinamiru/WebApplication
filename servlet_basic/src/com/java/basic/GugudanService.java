package com.java.basic;

import java.util.Map;

public class GugudanService implements Service {
	private Input input;
	private Output output;
	
	public void setInput(Input input) {
		this.input = input;
	}
	
	public void setOutput(Output output) {
		this.output = output;
	}

	@Override
	public void process() {
		Map<String, Integer> data = input.excute();

		int dan = data.get("dan");
		int gop = data.get("gop");

		for (int i = 2; i < dan + 1; i++) {
			output.view(i);
			for (int j = 1; j < gop + 1; j++) {
				output.view(i, j);
			}
			output.view();
		}
	}
}