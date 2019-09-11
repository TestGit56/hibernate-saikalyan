package com.donors.dao;

public class Address {

		private String donorID = null;
		private String state = null;
		private String city = null;
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(String donorID, String state, String city) {
			super();
			this.donorID = donorID;
			this.state = state;
			this.city = city;
		}
		public String getDonorID() {
			return donorID;
		}
		public void setDonorID(String donorID) {
			this.donorID = donorID;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		@Override
		public String toString() {
			return "Address [donorID=" + donorID + ", state=" + state + ", city=" + city + "]";
		}
		
		
}
