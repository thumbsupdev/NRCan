package com.nrcan.main;

import java.io.File;

public class Option {
	private File file;
	private boolean bFlag;
	private boolean sFlag;
	private boolean bChecked;
	private boolean sChecked;
    
    public Option(File f, boolean b, boolean s)
    {
    	this.file = f;
		this.bFlag = b;
		this.sFlag = s;
		this.bChecked = b;
		this.sChecked = s;
    }
    
    public String getName()
    {
        return file.getName();
    }
    
    public String getPath()
    {
        return file.getAbsolutePath();
    }
    
    public boolean isBedrock() {
    	return bFlag;
    }
    
    public boolean isSurficial() {
    	return sFlag;
    }
    
    public boolean isBChecked() {
    	return bChecked;
    }
    
    public void setBChecked(boolean x) {
    	bChecked = x;
    }
    
    public boolean isSChecked() {
    	return sChecked;
    }
    
    public void setSChecked(boolean x) {
    	sChecked = x;
    }
}

