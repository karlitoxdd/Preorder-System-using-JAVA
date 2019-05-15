import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sales {
public Sales(String game,int num,int price) {
	File salescode=new File("sales/sales.txt");
	File salesdetails=new File("sales/sales_details.txt");
	FileReader salesdetailsReader;
	FileReader salescodeReader;
	try {
		salescodeReader = new FileReader(salescode);
		salesdetailsReader=new FileReader(salesdetails);
		int pay=num*price;
		String currDate=new SimpleDateFormat ("MM/dd/yy").format(new Date());
		Scanner salescodeScan=new Scanner(salescodeReader);
		Scanner salesdetailsScan=new Scanner(salesdetailsReader);
		String allsales="",code="110",date,total;
		int allpay=0;
		int details=0;
		boolean exist=false;
		while(salescodeScan.hasNext()) {
			code=salescodeScan.next();
			date=salescodeScan.next();
			total=salescodeScan.next();
			allpay=Integer.parseInt(total)+pay;
			if(date.equals(currDate)) {
				allsales=allsales+code+" "+date+" "+allpay+"\n";
				exist=true;
				details=1;
				
			}else {
				allsales=allsales+code+" "+date+" "+total+"\n";
			}
		}
		int newcode=Integer.parseInt(code)+1;
		if(exist==false) {
			allsales=allsales+newcode+" "+(new SimpleDateFormat ("MM/dd/yy").format(new Date()))+" "+pay+"\n";
			details=2;
		}
		String alldetails="",salecode="111",ordercode="0",totaldetail="0",us,ga,nu,pr;
		switch(details) {
		case 1:		while(salesdetailsScan.hasNext()) {
						salecode=salesdetailsScan.next();
						ordercode=salesdetailsScan.next();
						us=salesdetailsScan.next();
						ga=salesdetailsScan.next();
						nu=salesdetailsScan.next();
						pr=salesdetailsScan.next();
						totaldetail=salesdetailsScan.next();
						alldetails=alldetails+salecode+" "+ordercode+" "+us+" "+ga+" "+nu+" "+pr+" "+totaldetail+"\n";
					}
					alldetails=alldetails+code+" "+(String.format("%03d", (Integer.parseInt(ordercode)+1)))+" "+MainMenu.user+" "+game+" "+num+" "+price+" "+pay+"\n";
					break;
		case 2:		while(salesdetailsScan.hasNext()) {
			salecode=salesdetailsScan.next();
			ordercode=salesdetailsScan.next();
			us=salesdetailsScan.next();
			ga=salesdetailsScan.next();
			nu=salesdetailsScan.next();
			pr=salesdetailsScan.next();
			totaldetail=salesdetailsScan.next();
			alldetails=alldetails+salecode+" "+ordercode+" "+us+" "+ga+" "+nu+" "+pr+" "+totaldetail+"\n";
		}
		alldetails=alldetails+newcode+" "+(String.format("%03d", (Integer.parseInt(ordercode)+1)))+" "+MainMenu.user+" "+game+" "+num+" "+price+" "+pay+"\n";
		break;
		}
		FileWriter salesdetailsWrite=new FileWriter(salesdetails);
		salesdetailsWrite.write(alldetails);
		
		salesdetailsWrite.flush();
		salesdetailsWrite.close();
		
		FileWriter salescodeWrite=new FileWriter(salescode);
		salescodeWrite.write(allsales);
		
		salescodeWrite.flush();
		salescodeWrite.close();
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}
	
	
}
}
