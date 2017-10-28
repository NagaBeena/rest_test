package rest.restapi.util;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class RestUtil {
	
	public static String getContentTypeValue(HttpResponse response)
	{
		String contentTypeValue = null;
		
		if(response != null)
		{
			Header[] allHeaders = response.getAllHeaders();
			if(allHeaders != null)
			{
				for(Header header:allHeaders)
				{
					if(header.getName().equalsIgnoreCase("Content-Type"))
					{
						contentTypeValue = header.getValue();
						break;
					}
				}
			}
		}
		
		
		return contentTypeValue;
	}

}
