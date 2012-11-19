package com.nrcan.main;

import java.io.File;

public class Option {
	private File file;
	private boolean bFlag;
	private boolean sFlag;
    
    public Option(File f, boolean b, boolean s)
    {
    	this.file = f;
		this.bFlag = b;
		this.sFlag = s;
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
}

