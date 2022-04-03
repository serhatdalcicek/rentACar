package com.etiya.rentACar.business.constants;

public class BusinessMessages {



    public class CarMaintenanceMessage{
		public  static final String CAR_MAINTENANCE_ADD="Araç bakıma eklendi";
		public  static final String CAR_MAINTENANCE_UPDATE="Araç bakımı güncellendi";
		public  static final String CAR_MAINTENANCE_DELETE="Araç bakımı silindi";

		public static final String CAR_UNDERMAİNTENANCE="Bu araç bakımda";
		public static final String CAR_NOT_EXISTS = "Böyle bir araba mevcut değil!";

	}
	public class CityMessages{
		public static final String CITY_ADD="Şehir eklendi";
		public static final String CITY_DELETE="Şehir silindi";

	}

	public class CarStateMessage {


		public static final String CAR_NOT_AVAILABLE = "Araba uygun değil!";

	}
	public class BrandMessage {
		public  static final String BRAND_ADD="Marka eklendi";
		public  static final String BRAND_UPDATE="Marka güncellendi";
		public  static final String BRAND_DELETE="Marka silindi";

		public static final String BRAND_NAME_EXISTS = "Marka zaten var!";

	}
	public class ColorMessage {
		public  static final String COLOR_ADD="Renk eklendi";
		public  static final String COLOR_UPDATE="Renk güncellendi";
		public  static final String COLOR_DELETE="Renk silindi";

		public static final String COLOR_NAME_EXISTS = "Renk zaten var!!";

	}
	public class CarMessage {
		public  static final String CAR_ADD="Araba eklendi";
		public  static final String CAR_UPDATE="Araba güncellendi";
		public  static final String CAR_DELETE="Araba silindi";

		public static final String CAR_EXISTS = "Girdiğiniz araba mevcut!";
		public static final String CAR_MAINTENANCE = "Araç bakımda!";

	}

	public class CarRentalMessage {
		public  static final String CAR_RENTAL_ADD="Kiralık araç eklendi";
		public  static final String CAR_RENTAL_UPDATE="Kiralık araç güncellendi";
		public  static final String CAR_RENTAL_DELETE="Kiralık araç silindi";
		public static final String CAR_RENTAL_NOT_ID = "Bu id ile bir kiralama gerçekleşmemiştir";
		public static final String CAR_NOT_AVAILABLE = " Araç müsait değil";
		public static final String RENTAL = "Araç Kiralama Başarılı!";

	}
	public class CarDamageMessage {
		public  static final String CARDAMAGE_ADD="Hasar eklendi.";
		public  static final String CARDAMAGE_UPDATE="Hasar güncellendi.";
		public  static final String CARDAMAGE_DELETE="Hasar silindi.";

		public static final String CAR_NOT_EXISTS = "Böyle bir araba mevcut değil!";

	}

	public class CustomerMessage {
		public  static final String CUSTOMER_ADD="Müşteri eklendi";
		public  static final String CUSTOMER_UPDATE="Müşteri güncellendi";
		public  static final String CUSTOMER_DELETE="Müşteri silindi";

		public static final String CUSTOMER = " Müşteri Kaydı Başarılı!";

	}

	public class AdditionalServiceMessage{

		public static final String ADDITIONAL_SERVICES_ADD = "Ek hizmet başarılı bir şekilde eklendi.";
		public static final String ADDITIONAL_SERVICES_UPDATE = "Ek hizmet başarılı bir şekilde güncellendi.";
		public static final String ADDITIONAL_SERVICES_DELETE = "Ek hizmet başarılı bir şekilde silindi.";
	}
	public class OrderedAdditionalMessage {

		public static final String ORDERED_ADDITIONAL_ADD = "Sipariş başarılı bir şekilde eklendi.";
		public static final String ORDERED_ADDITIONAL_UPDATE = "Sipariş başarılı bir şekilde güncellendi.";
		public static final String ORDERED_ADDITIONAL_DELETE = "Sipariş başarılı bir şekilde silindi.";
	}
}
