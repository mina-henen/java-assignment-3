package iceHockey;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class IPlayersFinderTest {

	@Test
	public void test1() {
		icehockey test= new icehockey();
		Point[] test1 = test.findPlayers(new String[]{
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"
        }, 3, 16);

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < test1.length; i++) {
            string.append(test1[i]+"\n");
        }

        Assert.assertTrue("wrong answer",
                ("java.awt.Point[x=4,y=5]\n" +
                        "java.awt.Point[x=13,y=9]\n" +
                        "java.awt.Point[x=14,y=2]\n").equalsIgnoreCase(string.toString()));
		
	}
	
	@Test
	public void test2() {
		icehockey test= new icehockey();
		Point[] test2 = test.findPlayers(new String[]{"44444H44S4",
                "K444K4L444",
                "4LJ44T44XH",
                "444O4VIF44",
                "44C4D4U444",
                "4V4Y4KB4M4",
                "G4W4HP4O4W",
                "4444ZDQ4S4",
                "4BR4Y4A444",
                "4G4V4T4444"
        }, 4, 16);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < test2.length; i++) {
            string.append(test2[i]+"\n");
        }

        Assert.assertTrue("Wrong",
                ("java.awt.Point[x=3,y=8]\n" +
                        "java.awt.Point[x=4,y=16]\n" +
                        "java.awt.Point[x=5,y=4]\n" +
                        "java.awt.Point[x=16,y=3]\n" +
                        "java.awt.Point[x=16,y=17]\n" +
                        "java.awt.Point[x=17,y=9]\n").equalsIgnoreCase(string.toString()));
	}
	@Test
	public void test3() {
		icehockey test= new icehockey();
		Point[] test3 = test.findPlayers(
                new String[]{
                        "11111",
                        "1AAA1",
                        "1A1A1",
                        "1AAA1",
                        "11111"
                }, 1, 3);
    StringBuilder string = new StringBuilder();
    for (int i = 0; i < test3.length; i++) {
        string.append(test3[i]+"\n");
    }

    Assert.assertTrue("wrong answer", 
    		("java.awt.Point[x=5,y=5]\n" +
            "java.awt.Point[x=5,y=5]\n"
           ).equalsIgnoreCase(string.toString()));
	}
	@Test
	public void test4() {
		icehockey test= new icehockey();
		Point[] test4 = test.findPlayers(new String[]{
                "8D88888J8L8E888",
                "88NKMG8N8E8JI88",
                "888NS8EU88HN8EO",
                "LUQ888A8TH8OIH8",
                "888QJ88R8SG88TY",
                "88ZQV88B88OUZ8O",
                "FQ88WF8Q8GG88B8",
                "8S888HGSB8FT8S8",
                "8MX88D88888T8K8",
                "8S8A88MGVDG8XK8",
                "M88S8B8I8M88J8N",
                "8W88X88ZT8KA8I8",
                "88SQGB8I8J88W88",
                "U88H8NI8CZB88B8",
                "8PK8H8T8888TQR8"
        }, 8, 9);
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < test4.length; i++) {
            string.append(test4[i]+"\n");
        }

        Assert.assertTrue("wrong answer", ("java.awt.Point[x=1,y=17]\n" +
                "java.awt.Point[x=3,y=3]\n" +
                "java.awt.Point[x=3,y=10]\n" +
                "java.awt.Point[x=3,y=25]\n" +
                "java.awt.Point[x=5,y=21]\n" +
                "java.awt.Point[x=8,y=17]\n" +
                "java.awt.Point[x=9,y=2]\n" +
                "java.awt.Point[x=10,y=9]\n" +
                "java.awt.Point[x=12,y=23]\n" +
                "java.awt.Point[x=17,y=16]\n" +
                "java.awt.Point[x=18,y=3]\n" +
                "java.awt.Point[x=18,y=11]\n" +
                "java.awt.Point[x=18,y=28]\n" +
                "java.awt.Point[x=22,y=20]\n" +
                "java.awt.Point[x=23,y=26]\n" +
                "java.awt.Point[x=24,y=15]\n" +
                "java.awt.Point[x=27,y=2]\n" +
                "java.awt.Point[x=28,y=26]\n" +
                "java.awt.Point[x=29,y=16]\n").equalsIgnoreCase(string.toString()));
	}

}
