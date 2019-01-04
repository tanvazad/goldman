package Q30_ApacheLogs1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress ip1 = InetAddress.getByName("123.4.245.23");
		InetAddress ip2 = InetAddress.getByName("104.244.253.29");
		InetAddress ip3 = InetAddress.getByName("1.198.3.93");
		InetAddress ip4 = InetAddress.getByName("32.183.93.40");

		List<InetAddress> lst = new LinkedList<InetAddress>();

		lst.add(ip1);
		lst.add(ip2);
		lst.add(ip3);

		lst.add(ip4);
		Collections.sort(lst, new Comparator<InetAddress>() {
			@Override
			public int compare(InetAddress adr1, InetAddress adr2) {
				byte[] ba1 = adr1.getAddress();
				byte[] ba2 = adr2.getAddress();


				/*
				 * // general ordering: ipv4 before ipv6 if (ba1.length <
				 * ba2.length) return -1; if (ba1.length > ba2.length) return 1;
				 */

				// we have 2 ips of the same type, so we have to compare each
				// byte

				for (int i = 0; i < ba1.length; i++) {
					int b1 = (ba1[i]);
					int b2 = (ba2[i]);

					return b2-b1;
					
//					if (b1 == b2)
//						continue;
//					if (b1 < b2)
//						return 1;
//					else
//						return -1;
				}

				return 0;
			}
		});

		System.out.println(lst);
	}

}
