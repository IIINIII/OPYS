import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public abstract class SharedFunctions {
	
	public static JTableHeader comp;
	public static JTable table;
	public static int xasd = 48;
	
	public static String convertToDB(String s) {
		if(s.equals("Başlamadı"))
			return "baslamadi";
		if(s.equals("Devam Ediyor"))
			return "devam_ediyor";
		if(s.equals("Pilotta"))
			return "pilotta";
		if(s.equals("Beklemede"))
			return "beklemede";
		if(s.equals("Testte"))
			return "testte";
		if(s.equals("Devrede"))
			return "devrede";
		if(s.equals("Tamamlandı"))
			return "tamamlandi";
		if(s.equals("İptal Edildi"))
			return "iptal_edildi";
		return "";
	}
	public static String convertToCombo(String s) {
		if(s.equals("baslamadi"))
			return "Başlamadı";
		if(s.equals("devam_ediyor"))
			return "Devam Ediyor";
		if(s.equals("pilotta"))
			return "Pilotta";
		if(s.equals("beklemede"))
			return "Beklemede";
		if(s.equals("testte"))
			return "Testte";
		if(s.equals("devrede"))
			return "Devrede";
		if(s.equals("tamamlandi"))
			return "Tamamlandı";
		if(s.equals("iptal_edildi"))
			return "İptal Edildi";
		return "";
	}
	public static JPanel prepareTable2(String query, String[] header, Boolean rightSum, Boolean bottomSum) {
		ResultSet rs = VT.veriAl(query);
		ArrayList<Object[]> tmpData = new ArrayList<Object[]>();
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> headersTmp = new ArrayList<String>();
		for(int i=0;i<header.length;i++) {
			headers.add("<html><b><div style=\"height:"+xasd+"px;padding:auto;\">"+header[i]+"</div></b></html>");
			headersTmp.add(header[i]);
		}
		if(rightSum) {
			headers.add("<html><b>Toplam</b></html>");
			headersTmp.add("Toplam");
		}
		try {
			while(rs.next()) {
				ArrayList<Object> tmpObjs = new ArrayList<Object>();
				for(int i=1;i<=header.length;i++) {
					tmpObjs.add(rs.getObject(i));
				}
				tmpData.add(tmpObjs.toArray());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int h=tmpData.size(),w=header.length;
		if(rightSum)w++;
		if(bottomSum)h++;
		Object[][] data = new Object[h][w], dataTmp = new Object[h][w];
		int i=0,j;
		ArrayList<BigDecimal> tmp = new ArrayList<BigDecimal>();
		for(Object o : tmpData.toArray()) {
			Object[] ob = (Object[])o;
			if(i==0) {
				for (j=0;j<w;j++) {
					tmp.add(new BigDecimal(0));
				}
			}
			j=0;
			BigDecimal tmp1 = new BigDecimal(0);
			for(Object o1 : ob) {
				try {
					tmp1 = tmp1.add((BigDecimal)o1);
					tmp.set(j, tmp.get(j).add((BigDecimal)o1));
					data[i][j]=o1;
					dataTmp[i][j]=o1;
				} catch(Exception e) {
					//asdf;
					try {
						tmp1 = tmp1.add(new BigDecimal((Double)o1, MathContext.DECIMAL64));
						tmp.set(j, tmp.get(j).add(new BigDecimal((Double)o1, MathContext.DECIMAL64)));
						data[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
						dataTmp[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
					} catch(Exception e1) {
						data[i][j]=o1;
						dataTmp[i][j]=o1;
					}
				}
				j++;
			}
			if(rightSum) {
				data[i][j]=new String("<html><b>"+tmp1+"</b></html>");
				dataTmp[i][j]=tmp1;
				tmp.set(j, tmp.get(j).add((BigDecimal)tmp1));
			}
			i++;
		}
		if(bottomSum) {
			for (j=0;j<w;j++) {
				data[i][j]="<html><b>"+tmp.get(j)+"</b></html>";
				dataTmp[i][j]=tmp.get(j);
			}
			data[i][0]="<html><b>Toplam</b></html>";
			dataTmp[i][0]="Toplam";
		}
		JTable table = new JTable(data, headers.toArray());
		table.setRowHeight(32);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRowCount()==1&&Manager.btnShow!=null)
					Manager.btnShow.setEnabled(true);
				else if(Manager.btnShow!=null)
					Manager.btnShow.setEnabled(false);
			}
		});
		SharedFunctions.table.setRowHeight(32);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table.getTableHeader();
		tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		tablePanel.add(table,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createTable2(JComponent b,int x,int y,int w,String query,String[] headers,boolean rightSum,boolean bottomSum) {
		JPanel pane = prepareTable2(query,headers, rightSum, bottomSum);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y+32, w, 568);
		panel.setPreferredSize(pane.getPreferredSize());
		b.add(panel);
	}
	public static JPanel prepareTable1(String query, String[] header, Boolean rightSum, Boolean bottomSum) {
		ResultSet rs = VT.veriAl(query);
		ArrayList<Object[]> tmpData = new ArrayList<Object[]>();
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> headersTmp = new ArrayList<String>();
		for(int i=0;i<header.length;i++) {
			headers.add("<html><b><div style=\"height:48px;padding:auto;\">"+header[i]+"</div></b></html>");
			headersTmp.add(header[i]);
		}
		if(rightSum) {
			headers.add("<html><b>Toplam</b></html>");
			headersTmp.add("Toplam");
		}
		try {
			while(rs.next()) {
				ArrayList<Object> tmpObjs = new ArrayList<Object>();
				for(int i=1;i<=header.length;i++) {
					tmpObjs.add(rs.getObject(i));
				}
				tmpData.add(tmpObjs.toArray());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int h=tmpData.size(),w=header.length;
		if(rightSum)w++;
		if(bottomSum)h++;
		Object[][] data = new Object[h][w], dataTmp = new Object[h][w];
		int i=0,j;
		ArrayList<BigDecimal> tmp = new ArrayList<BigDecimal>();
		for(Object o : tmpData.toArray()) {
			Object[] ob = (Object[])o;
			if(i==0) {
				for (j=0;j<w;j++) {
					tmp.add(new BigDecimal(0));
				}
			}
			j=0;
			BigDecimal tmp1 = new BigDecimal(0);
			for(Object o1 : ob) {
				try {
					tmp1 = tmp1.add((BigDecimal)o1);
					tmp.set(j, tmp.get(j).add((BigDecimal)o1));
					data[i][j]=o1;
					dataTmp[i][j]=o1;
				} catch(Exception e) {
					//asdf;
					try {
						tmp1 = tmp1.add(new BigDecimal((Double)o1, MathContext.DECIMAL64));
						tmp.set(j, tmp.get(j).add(new BigDecimal((Double)o1, MathContext.DECIMAL64)));
						data[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
						dataTmp[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
					} catch(Exception e1) {
						data[i][j]=o1;
						dataTmp[i][j]=o1;
					}
				}
				j++;
			}
			if(rightSum) {
				data[i][j]=new String("<html><b>"+tmp1+"</b></html>");
				dataTmp[i][j]=tmp1;
				tmp.set(j, tmp.get(j).add((BigDecimal)tmp1));
			}
			i++;
		}
		if(bottomSum) {
			for (j=0;j<w;j++) {
				data[i][j]="<html><b>"+tmp.get(j)+"</b></html>";
				dataTmp[i][j]=tmp.get(j);
			}
			data[i][0]="<html><b>Toplam</b></html>";
			dataTmp[i][0]="Toplam";
		}
		JTable table = new JTable(data, headers.toArray());
		SharedFunctions.table = new JTable(dataTmp, headersTmp.toArray());
		table.setRowHeight(32);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRowCount()==1&&Manager.btnShow!=null)
					Manager.btnShow.setEnabled(true);
				else if(Manager.btnShow!=null)
					Manager.btnShow.setEnabled(false);
			}
		});
		SharedFunctions.table.setRowHeight(32);
		//SharedFunctions.table.getcolum
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table.getTableHeader();
		tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		if(comp!=null)
			comp.setVisible(false);
		comp=hdr;
		tablePanel.add(table,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createTable1(JComponent b,int x,int y,int w,String query,String[] headers,boolean rightSum,boolean bottomSum) {
		JPanel pane = prepareTable1(query,headers, rightSum, bottomSum);
		//comp.setBounds(x+2, y+3, w-4, 32);
		//comp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//b.add(comp);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y+32, w, 568);
		panel.setPreferredSize(pane.getPreferredSize());
		if(Manager.tablePanel != null)
			Manager.tablePanel.setVisible(false);
		Manager.tablePanel = panel;
		b.add(panel);
	}
	public static JPanel prepareTable(String query, String[] header, Boolean rightSum, Boolean bottomSum) {
		ResultSet rs = VT.veriAl(query);
		ArrayList<Object[]> tmpData = new ArrayList<Object[]>();
		ArrayList<String> headers = new ArrayList<String>();
		ArrayList<String> headersTmp = new ArrayList<String>();
		for(int i=0;i<header.length;i++) {
			headers.add("<html><h4><b>"+header[i]+"</b></h4></html>");
			headersTmp.add(header[i]);
		}
		if(rightSum) {
			headers.add("<html><h4><b>Toplam</b></h4></html>");
			headersTmp.add("Toplam");
		}
		try {
			while(rs.next()) {
				ArrayList<Object> tmpObjs = new ArrayList<Object>();
				for(int i=1;i<=header.length;i++) {
					tmpObjs.add(rs.getObject(i));
				}
				tmpData.add(tmpObjs.toArray());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int h=tmpData.size(),w=header.length;
		if(rightSum)w++;
		if(bottomSum)h++;
		Object[][] data = new Object[h][w], dataTmp = new Object[h][w];
		int i=0,j;
		ArrayList<BigDecimal> tmp = new ArrayList<BigDecimal>();
		for(Object o : tmpData.toArray()) {
			Object[] ob = (Object[])o;
			if(i==0) {
				for (j=0;j<w;j++) {
					tmp.add(new BigDecimal(0));
				}
			}
			j=0;
			BigDecimal tmp1 = new BigDecimal(0);
			for(Object o1 : ob) {
				try {
					tmp1 = tmp1.add((BigDecimal)o1);
					tmp.set(j, tmp.get(j).add((BigDecimal)o1));
					data[i][j]=o1;
					dataTmp[i][j]=o1;
				} catch(Exception e) {
					//asdf;
					try {
						tmp1 = tmp1.add(new BigDecimal((Double)o1, MathContext.DECIMAL64));
						tmp.set(j, tmp.get(j).add(new BigDecimal((Double)o1, MathContext.DECIMAL64)));
						data[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
						dataTmp[i][j]=new BigDecimal((Double)o1, MathContext.DECIMAL64);
					} catch(Exception e1) {
						data[i][j]=o1;
						dataTmp[i][j]=o1;
					}
				}
				j++;
			}
			if(rightSum) {
				data[i][j]=new String("<html><b>"+tmp1+"</b></html>");
				dataTmp[i][j]=tmp1;
				tmp.set(j, tmp.get(j).add((BigDecimal)tmp1));
			}
			i++;
		}
		if(bottomSum) {
			for (j=0;j<w;j++) {
				data[i][j]="<html><b>"+tmp.get(j)+"</b></html>";
				dataTmp[i][j]=tmp.get(j);
			}
			data[i][0]="<html><b>Toplam</b></html>";
			dataTmp[i][0]="Toplam";
		}
		JTable table = new JTable(data, headers.toArray());
		SharedFunctions.table = new JTable(dataTmp, headersTmp.toArray());
		table.setRowHeight(32);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRowCount()==1&&Manager.btnShow!=null)
					Manager.btnShow.setEnabled(true);
				else if(Manager.btnShow!=null)
					Manager.btnShow.setEnabled(false);
			}
		});
		SharedFunctions.table.setRowHeight(32);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table.getTableHeader();
		//tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		if(comp!=null)
			comp.setVisible(false);
		comp=hdr;
		tablePanel.add(table,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createTable(JComponent b,int x,int y,int w,String query,String[] headers,boolean rightSum,boolean bottomSum) {
		JPanel pane = prepareTable(query,headers, rightSum, bottomSum);
		comp.setBounds(x+2, y+3, w-4, 32);
		comp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		b.add(comp);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y+32, w, 568);
		panel.setPreferredSize(pane.getPreferredSize());
		if(Manager.tablePanel!=null)Manager.tablePanel.setVisible(false);
		Manager.tablePanel = panel;
		b.add(panel);
	}
	
	public static void toExcel(File file){
		
	    try{
	        
	    	TableModel model = table.getModel();
	        WritableWorkbook wworkbook;
	        wworkbook = Workbook.createWorkbook(file);
	        WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
	        for(int i = 0; i < model.getColumnCount(); i++){
	        	String s=model.getColumnName(i).toString();
	        	Label cell = new Label(i, 0, model.getColumnName(i));
            	wsheet.addCell(cell);
	        }
	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	            	try {
	            		Number cell = new Number(j, i+1, ((BigDecimal)model.getValueAt(i,j)).doubleValue());
	            		wsheet.addCell(cell);
	            	} catch(Exception e) {
	            		try {
	            			Label cell = new Label(j, i+1, model.getValueAt(i,j).toString());
		            		wsheet.addCell(cell);
	            		} catch(Exception e1) {
	            			Label cell = new Label(j, i+1, "");
		            		wsheet.addCell(cell);
	            		}
	            	}
	            }
	        }
	        wworkbook.write();
	        wworkbook.close();
	        JOptionPane.showMessageDialog(Manager.ekran, "Tablo başarıyla Excel'e aktarılmıştır!", "Excel", JOptionPane.INFORMATION_MESSAGE);

	    }catch(IOException | WriteException e){ e.printStackTrace(); }
	}
	
	public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
	public static void DBtoCombo(JComboBox<String> comboBox, String[] dizi) {
		for(String s : dizi) {
			comboBox.addItem(s);
		}
	}
	public static void esneklikHazirla() {
		String query = null;
		ArrayList<String> tmpStr=new ArrayList<String>();
		query = "SELECT value FROM `esneklik_tablosu` WHERE isActive = 1 AND set_name = 'daire' ORDER BY value";
		ResultSet rs = VT.veriAl(query);
		try {
			while (rs.next()) {
				tmpStr.add(rs.getString(1));
			}
		} catch(Exception e) {
			// bi bok yapma
		}
		Manager.daireler = new String[tmpStr.size()];
		int i;
		i=0;
		for(String s : tmpStr) {
			Manager.daireler[i++] = s;
		}
		tmpStr.clear();
		query = "SELECT value FROM `esneklik_tablosu` WHERE isActive = 1 AND set_name = 'takim' ORDER BY value";
		rs = VT.veriAl(query);
		try {
			while (rs.next()) {
				tmpStr.add(rs.getString(1));
			}
		} catch(Exception e) {
			// bi bok yapma
		}
		Manager.takimlar = new String[tmpStr.size()];
		i=0;
		for(String s : tmpStr) {
			Manager.takimlar[i++] = s;
		}
		tmpStr.clear();
		query = "SELECT value FROM `esneklik_tablosu` WHERE isActive = 1 AND set_name = 'mudurluk' ORDER BY value";
		rs = VT.veriAl(query);
		try {
			while (rs.next()) {
				tmpStr.add(rs.getString(1));
			}
		} catch(Exception e) {
			// bi bok yapma
		}
		Manager.mudurlukler = new String[tmpStr.size()];
		i=0;
		for(String s : tmpStr) {
			Manager.mudurlukler[i++] = s;
		}
	}
	
}
