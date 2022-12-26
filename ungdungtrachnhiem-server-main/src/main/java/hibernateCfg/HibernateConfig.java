package hibernateCfg;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;


import entity.CauHoiThi;
import entity.DapAn;
import entity.GiangVien;
import entity.KetQua;
import entity.KetQuaPK;
import entity.LoaiCauHoi;
import entity.MonHoc;
import entity.SinhVien;
import entity.TaiKhoan;
import entity.Thi;


public class HibernateConfig {
	public static SessionFactory sessionFactory = null;
	public static HibernateConfig instance = new HibernateConfig();

	public static HibernateConfig getInstance() {
		return instance;
	}

	public HibernateConfig() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(CauHoiThi.class)
				.addAnnotatedClass(DapAn.class)
				.addAnnotatedClass(GiangVien.class)
				.addAnnotatedClass(KetQua.class)
				.addAnnotatedClass(KetQuaPK.class)
				.addAnnotatedClass(LoaiCauHoi.class)
				.addAnnotatedClass(MonHoc.class)
				.addAnnotatedClass(SinhVien.class)
				.addAnnotatedClass(TaiKhoan.class)
				.addAnnotatedClass(Thi.class)
				.getMetadataBuilder().build();
		if (sessionFactory == null) {
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		SessionFactory factory= HibernateConfig.getInstance().getSessionFactory();
		
		
	}
}
