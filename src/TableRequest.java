
public class TableRequest {
	
	String name, query;
	String[] headers;
	boolean rightSum, bottomSum;
	public static int tblNum = 8;
	
	public TableRequest(int x) {
		if(x==0) {
			name = "BEKLEYEN PROJELERİN DURUMU";
			headers = new String[] {"Daire İsmi","Kalan İşler(adamgün)"};
			query = "SELECT talep_eden_daire,SUM(kalan_kaynak_ihtiyaci) AS kalan_kaynak_ihtiyaci FROM proje GROUP BY talep_eden_daire ORDER BY talep_eden_daire";
			rightSum = false;
			bottomSum = true;
		} else if(x==1) {
			name = "DAİRELERİN TALEP DURUMUNA GÖRE İŞ KAPASİTELERİ (adamgün)";
			headers = new String[] {"Daire İsmi","Başlamadı","Beklemede","Devam Ediyor","Test Sonrası İlave"};
			query = "SELECT talep_eden_daire AS 'Talep Eden Daire',SUM(if(talep_durumu = 'baslamadi',kalan_kaynak_ihtiyaci,0)) AS 'Baslamadi',SUM(if(talep_durumu = 'beklemede',kalan_kaynak_ihtiyaci,0)) AS 'Beklemede',SUM(if(talep_durumu = 'devam_ediyor',kalan_kaynak_ihtiyaci,0)) AS 'Devam Ediyor',SUM(if(ilave_kaynak_ihtiyaci,ilave_kaynak_ihtiyaci,0)) AS 'Test Sonrası İlave' FROM proje GROUP BY talep_eden_daire ORDER BY talep_eden_daire";
			rightSum = true;
			bottomSum = true;
		} else if(x==2) {
			name = "DAİRELERİN İŞ SAYISI";
			headers = new String[] {"Daire İsmi","Başlamadı","Beklemede","Devam Ediyor","Devrede","İptal Edildi","Tamamlandı","Testte"};
			query = "SELECT talep_eden_daire AS 'Daire İsmi',SUM(if(talep_durumu = 'baslamadi',1,0)) AS 'Baslamadi',SUM(if(talep_durumu = 'beklemede',1,0)) AS 'Beklemede',SUM(if(talep_durumu = 'devam_ediyor',1,0)) AS 'Devam Ediyor',SUM(if(talep_durumu = 'devrede',1,0)) AS 'Devrede',SUM(if(talep_durumu = 'iptal_edildi',1,0)) AS 'Iptal Edildi',SUM(if(talep_durumu = 'tamamlandi',1,0)) AS 'Tamamlandi',SUM(if(talep_durumu = 'testte',1,0)) AS 'Testte' FROM proje GROUP BY talep_eden_daire ORDER BY talep_eden_daire";
			rightSum = true;
			bottomSum = false;
		} else if(x==3) {
			name = "DAİRELERE GÖRE ÖNGÖRÜLEN ve GERÇEKLEŞEN ZAMANLAR (adamgün)";
			headers = new String[] {"Daire İsmi","Öngörülen Zamanlar","Gerçekleşen Zamanlar"};
			query = "SELECT DISTINCT talep_eden_daire,SUM(if(kaynak_ihtiyaci,kaynak_ihtiyaci,0)) AS 'Öngörülen Zamanlar',SUM(if(gerceklesen_kaynak_ihtiyaci,gerceklesen_kaynak_ihtiyaci,0)) AS 'Gerçekleşen Zamanlar' FROM proje WHERE talep_durumu IN('devrede','testte','tamamlandi') GROUP BY talep_eden_daire ORDER BY talep_eden_daire";
			rightSum = false;
			bottomSum = false;
		} else if(x==4) {
			name = "TAKIMLARA GÖRE DAĞILIM";
			headers = new String[] {"Takım İsmi","Kalan İşler(adamgün)"};
			query = "SELECT takimi,SUM(kalan_kaynak_ihtiyaci) AS kalan_kaynak_ihtiyaci FROM proje GROUP BY takimi ORDER BY takimi";
			rightSum = false;
			bottomSum = true;
		} else if(x==5) {
			name = "TAKIMLARIN TALEP DURUMUNA GÖRE İŞ KAPASİTELERİ (adamgün)";
			headers = new String[] {"Takım İsmi","Başlamadı","Beklemede","Devam Ediyor","Test Sonrası İlave"};
			query = "SELECT takimi AS 'Talep Eden Daire',SUM(if(talep_durumu = 'baslamadi',kalan_kaynak_ihtiyaci,0)) AS 'Baslamadi',SUM(if(talep_durumu = 'beklemede',kalan_kaynak_ihtiyaci,0)) AS 'Beklemede',SUM(if(talep_durumu = 'devam_ediyor',kalan_kaynak_ihtiyaci,0)) AS 'Devam Ediyor',SUM(if(ilave_kaynak_ihtiyaci,ilave_kaynak_ihtiyaci,0)) AS 'Test Sonrası İlave' FROM proje GROUP BY takimi ORDER BY takimi";
			rightSum = true;
			bottomSum = true;
		} else if(x==6) {
			name = "TAKIMLARIN İŞ SAYISI";
			headers = new String[] {"Takım İsmi","Başlamadı","Beklemede","Devam Ediyor","Devrede","İptal Edildi","Tamamlandı","Testte"};
			query = "SELECT takimi AS 'Takim Adi',SUM(if(talep_durumu = 'baslamadi',1,0)) AS 'Baslamadi',SUM(if(talep_durumu = 'beklemede',1,0)) AS 'Beklemede',SUM(if(talep_durumu = 'devam_ediyor',1,0)) AS 'Devam Ediyor',SUM(if(talep_durumu = 'devrede',1,0)) AS 'Devrede',SUM(if(talep_durumu = 'iptal_edildi',1,0)) AS 'Iptal Edildi',SUM(if(talep_durumu = 'tamamlandi',1,0)) AS 'Tamamlandi',SUM(if(talep_durumu = 'testte',1,0)) AS 'Testte' FROM proje GROUP BY takimi ORDER BY takimi";
			rightSum = true;
			bottomSum = false;
		} else if(x==7) {
			name = "TAKIMLARA GÖRE ÖNGÖRÜLEN ve GERÇEKLEŞEN ZAMANLAR (adamgün)";
			headers = new String[] {"Takım İsmi","Öngörülen Zamanlar","Gerçekleşen Zamanlar"};
			query = "SELECT DISTINCT takimi,SUM(if(kaynak_ihtiyaci,kaynak_ihtiyaci,0)) AS 'Öngörülen Zamanlar',SUM(if(gerceklesen_kaynak_ihtiyaci,gerceklesen_kaynak_ihtiyaci,0)) AS 'Gerçekleşen Zamanlar' FROM proje WHERE talep_durumu IN('devrede','testte','tamamlandi') GROUP BY takimi ORDER BY takimi";
			rightSum = false;
			bottomSum = false;
		}
	}
	
	public String toString() {
		return name;
	}
	
}
