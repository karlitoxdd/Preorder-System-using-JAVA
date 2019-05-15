import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Purchase{

	File acc=new File(MainMenu.user+".txt");
	FileWriter fWrite;

	
	public Purchase(String name,int num) {
		
		try {
			File price=new File("price.txt");
			FileReader priceRead=new FileReader(price);
			Scanner priceScan=new Scanner(priceRead);
			String currPrice="";
			
			while(priceScan.hasNext()) {
				currPrice=priceScan.next();
			}
			 if (JOptionPane.showConfirmDialog(new JFrame(),
				        "Are you sure you want to purchase "+num+" piece(s) of "+name+" for "+(num*Integer.parseInt(currPrice))+" pesos?", "Purchase",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				 	acc=new File(MainMenu.user+".txt");
					fWrite=new FileWriter(acc,true);
					
					
					File verify=new File("wallet.txt");
					FileReader verifyRead=new FileReader(verify);
					Scanner verifyScan=new Scanner(verifyRead);
					String user="",remaining="";
					while(verifyScan.hasNext()) {
						user=verifyScan.next();
						remaining=verifyScan.next();
						if(user.equals(MainMenu.user)) {
							if((num*Integer.parseInt(currPrice))<Integer.parseInt(remaining)){
								name=name.replaceAll("\\s", "");
								fWrite.write(name+" "+num+" "+currPrice+"\n");
								MainMenu.bal=MainMenu.bal-(num*Integer.parseInt(currPrice));
								MainMenu.lblBalance.setText("Balance: "+MainMenu.bal);
								JOptionPane.showMessageDialog(null, "Purchase Successful");
								
								
								File change=new File("wallet.txt");
								FileReader balRead=new FileReader(change);
								Scanner balScan=new Scanner(balRead);
								String all="",un="",mon="";
								while(balScan.hasNext()) {
									un=balScan.next();
									mon=balScan.next();
									if(un.equals(MainMenu.user)) {
										all=all+un+" "+(Integer.parseInt(mon)-(num*Integer.parseInt(currPrice)))+"\n";
									}else {
										all=all+un+" "+mon+"\n";
									}
								}
								FileWriter balWrite=new FileWriter(change);
								balWrite.write(all);
								
								
								balScan.close();
								balRead.close();
								balWrite.flush();
								balWrite.close();
								fWrite.flush();
								fWrite.close();
								
								
								File best=new File("bestseller.txt");
								FileReader bestRead=new FileReader(best);
								Scanner bestScan=new Scanner(bestRead);
								String gamename="",allbest="";
								int copies;
								boolean found=false;
								while(bestScan.hasNext()) {
									gamename=bestScan.next();
									copies=bestScan.nextInt();
									if(gamename.equals(name)) {
										allbest=allbest+gamename+" "+(copies+num)+"\n";
										found=true;
									}else {
											allbest=allbest+gamename+" "+copies+"\n";
										}
									if(bestScan.hasNext()==false&&found==false) {
										allbest=allbest+name+" "+num+"\n";
									
									}
								}
								FileWriter bestWrite=new FileWriter(best);
								bestWrite.write(allbest);
								
								bestScan.close();
								bestRead.close();
								bestWrite.flush();
								bestWrite.close();
								
								new Sales(name,num, Integer.parseInt(currPrice));
								
								
									}else {
								JOptionPane.showMessageDialog(null, "Purchase Failed!\nNot enough balance in wallet");
							}
						}
					}
				
			 }else {
				 JOptionPane.showMessageDialog(null, "Purchase Cancelled");
			 }
			 
		} catch (Exception e) {
			System.out.print(e.getCause());
		}
	}
}
