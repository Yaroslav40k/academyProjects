package com.andersen.borisovExample;

public class ProfilingController implements ProfilingControllerMBean  {
	private boolean isEnabled;

	public boolean isEnabled() {
		return isEnabled = true;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	

}
