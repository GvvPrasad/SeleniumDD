package com.autoprac.testscripts;

import org.testng.annotations.Test;

import com.autoprac.base.Base;
import com.autoprac.config.ObjectRespo;

public class Partice extends Base{
	
	@Test
	public static void tab() throws Exception {
		
	System.out.println(ObjectRespo.timeStamp);
	}
}
