package com.ItunessearchAPI;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class JunitTestcase {

	@Test
	public void testPrintHelloWorld() throws ClientProtocolException, IOException {

		Assert.assertEquals(ItuneSearchApi.helloWorld().toString(),"879273552");
		

	}

}
