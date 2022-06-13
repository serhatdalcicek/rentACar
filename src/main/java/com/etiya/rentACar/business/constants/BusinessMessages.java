package com.etiya.rentACar.business.constants;
public class BusinessMessages {

	public class MaintenanceMessages {
		public static final String CAR_UNDERMAINTENANCE = "CAR_UNDERMAINTENANCE";
		public static final String MAINTENANCE_ADD = "MAINTENANCE_ADD";
		public static final String MAINTENANCE_DELETED = "MAINTENANCE_DELETED";
		public static final String MAINTENANCE_UPDATED = "MAINTENANCE_UPDATED";
	}

	public class RentalMessages {
		public static final String CAR_RENTED = "CAR_RENTED";
		public static final String CAR_NOT_AVAILABLE = "CAR_NOT_AVAILABLE";
		public static final String RENTAL_RETURNED = "RENTAL_RETURNED";
		public static final String RENTAL_DELETED = "RENTAL_DELETED";
		public static final String RENTAL_UPDATE = "RENTAL_UPDATE";
		public static final String RENTAL_ADD = "RENTAL_ADD";
		public static final String RENTAL_NOT_EXIST = "RENTAL_NOT_EXIST";
	}

	public class CityMessages {
		public static final String CITY_ADD = "CITY_ADD";
		public static final String  CITY_DELETED = "CITY_DELETED";
		public static final String CITY_UPDATED = "CITY_UPDATED";
		public static final String CITY_NAME_EXIST = "CITY_NAME_EXIST";
	}

	public class BrandMessages {
		public static final String BRAND_EXIST = " bu marka daha önce kullanılmış";
		public static final String BRAND_DELETED = "Marka başarıyla silindi";
		public static final String BRAND_ADDED = "Marka ekleme işlemi başarıyla gerçekleşti";
		public static final String BRAND_UPDATED = "Marka güncelleme işlemi başarılya gerçekleşti";
	}

	public class ColorMessages {
		public static final String COLOR_EXIST = " bu renk daha önce kullanılmıştır";
		public static final String COLOR_ADD = "Renk ekleme işlemi başarıyla gerçekleşti";
		public static final String COLOR_UPDATED = "Renk güncelleme işlmei başarıya gerçekleşti";
		public static final String COLOR_DELETED = "Renk silme işlmei başarıyla gerçekleşti";
	}

	public class AdditionalServiceMessages {
		public static final String ADDITIONAL_SERVICE_ADD = "Ek hizmetler ekleme işlemi başarıyla gerçekleşti";
		public static final String ADDITIONAL_SERVICE_DELETED = "Ek hizmetler başaryıla silindi";
		public static final String ADDITIONAL_SERVICE_UPDATED = "Ek hizmelter başarıyla güncellendi";
	}

	public class CarMessages {
		public static final String CAR_ADDED = "Başarıyla eklendi";
		public static final String CAR_DELETED = "Başarıyla silindi";
		public static final String CAR_UPDATED = "Başarıyla güncellendi";
		public static final String CAR_STATE_UPDATED = "Araba Durumu güncellemesi başarıyla gerçekleşti";
	}

	public class CustomerMessages{
		public static final String CUSTOMER_ADD = "kullanıcı ekleme işlemi başarıyla eklendi";
		public static final String CUSTOMER_UPDATED = "KULLANICI GÜNCELLEME İŞMELİ BAŞARIYLA GERÇEKLEŞTİ";
		public static final String CUSTOMER_DELETED = "Kullanıcı silme işlemi başarıyla gerçekleşti";
	}

	public class DamageMessages{
		public static final String DAMAGE_ADD = "Araç hasarı ekleme başarıyla gerçekleşti";
		public static final String DAMAGE_UPDATED = "Araç hasarı güncelleme işlemi başarıyla gerçekleşti";
		public static final String DAMAGE_DELETED = "Araç hasarı silme başarıyla gerçekleşti";
	}

	public class OrderedAdditionalServiceMessages{
		public static final String OREDERED_ADDITIONAL_SERVICE_ADD = "Ek hizmetler şiparişi başarıyla eklendi";
		public static final String OREDERED_ADDITIONAL_SERVICE_DELETED = "Ek hizmetler siparişi başarıyla silindi";
		public static final String OREDERED_ADDITIONAL_SERVICE_UPDATED = "Ek hizmetler siparişi başarıyla güncellendi";
	}
	public class InvoiceMessages{
		public static final String INVOICE_ADDED = "Fatura başarıyla eklendi";
		public static final String INVOICE_DELETED = "Fatıra başarıyla silindi";
		public static final String INVOİCE_UPDATED = "Fatura başarıyla güncellendi";
	}
	public class PaymentMessages{
		public static final String PAYMENT_ADDED = "Ödeme alındı :))";
		public static final String PAYMENT_DELETED = "Ödeme silindi.";
		public static final String PAYMENT_UPDATED = "Ödeme güncellendi.";
	}
}