package junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo {

	public static void main(String[] args) throws ParseException {
		
		String birthday = "1980-12-31";
		//用这个类转有毛病，1980-12-32 会转成 1981-1-1
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(birthday);
		System.out.println(d.toLocaleString());
		
		//beanUtil
		DateLocaleConverter conver = new DateLocaleConverter();
		Date d2 = (Date) conver.convert(birthday);
		System.out.println(d2.toLocaleString());
	}

}
