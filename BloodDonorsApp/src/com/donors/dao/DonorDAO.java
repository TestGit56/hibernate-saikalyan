package com.donors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DonorDAO {

	private DataSource dataSoruce = DBUtil.getDataSource();

	public Donor getDonorByID(String loginId) throws DataSourceException {
		Donor donor = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select d.Login_ID , d.MobileNo , d.BloodGroup,a.State,a.City From BloodDonors d ,"
				+ "Address a Where a.Donor_ID = d.Login_ID  and d.Login_ID = ? ";

		try {
			con = dataSoruce.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId.trim());

			rs = ps.executeQuery();

			if (rs.next()) {
				donor = new Donor();

				Address addr = new Address();
				addr.setDonorID(rs.getString("Login_ID"));
				addr.setCity(rs.getString("City"));
				addr.setState(rs.getString("State"));

				donor.setLoginId(rs.getString("Login_ID"));
				donor.setBloodGroup(rs.getString("BloodGroup"));
				donor.setMobileNo(rs.getLong("MobileNo"));
				donor.setAddress(addr);
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}
		}
		return donor;

	}

	public boolean save(Donor donor) throws DataSourceException {
		boolean flag = false;
		Connection con = null;
		PreparedStatement donorps = null;
		PreparedStatement addressps = null;
		String donorSql = "Insert into BloodDonors(Login_ID,Password,MobileNo,BloodGroup) values(?,?,?,?)";
		String addresSql = "Insert into Address(Donor_ID,State,City) values(?,?,?)";

		try {
			con = dataSoruce.getConnection();
			donorps = con.prepareStatement(donorSql);
			donorps.setString(1, donor.getLoginId());
			donorps.setString(2, donor.getPassword());
			donorps.setLong(3, donor.getMobileNo());
			donorps.setString(4, donor.getBloodGroup());

			if (donorps.executeUpdate() > 0)
				;
			{
				addressps = con.prepareStatement(addresSql);
				addressps.setString(1, donor.getLoginId());
				addressps.setString(2, donor.getAddress().getState());
				addressps.setString(3, donor.getAddress().getCity());

				if (addressps.executeUpdate() > 0)
					flag = true;

			}

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {

			if (addressps != null) {
				try {
					addressps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (donorps != null) {
				try {
					donorps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}
		}
		return flag;

	}

	public Donor update(Donor donor) throws DataSourceException {
		Connection con = null;
		PreparedStatement donorps = null;
		PreparedStatement addressps = null;
		String donorSql = "Update BloodDonors Set MobileNo = ?,BloodGroup = ? Where Login_ID = ?";
		String addresSql = "Update Address Set State = ?,City = ? Where Donor_ID = ?";

		try {
			con = dataSoruce.getConnection();
			donorps = con.prepareStatement(donorSql);
			donorps.setLong(1, donor.getMobileNo());
			donorps.setString(2, donor.getBloodGroup());
			donorps.setString(3, donor.getLoginId());

			if (donorps.executeUpdate() > 0)
				;
			{
				addressps = con.prepareStatement(addresSql);

				addressps.setString(1, donor.getAddress().getState());
				addressps.setString(2, donor.getAddress().getCity());
				addressps.setString(3, donor.getAddress().getDonorID());

				addressps.executeUpdate();

			}

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {

			if (addressps != null) {
				try {
					addressps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (donorps != null) {
				try {
					donorps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}
		}
		return donor;

	}

	public List<Donor> search(String location) throws DataSourceException {
		List<Donor> donorList = new ArrayList<Donor>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select d.Login_ID , d.MobileNo , d.BloodGroup,a.State,a.City From BloodDonors d ,"
				+ "Address a Where a.Donor_ID = d.Login_ID  and upper(a.City) like ? ";

		try {
			con = dataSoruce.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + location.trim().toUpperCase() + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				Donor donor = new Donor();

				Address addr = new Address();
				addr.setDonorID(rs.getString("Login_ID"));
				addr.setCity(rs.getString("City"));
				addr.setState(rs.getString("State"));

				donor.setLoginId(rs.getString("Login_ID"));
				donor.setBloodGroup(rs.getString("BloodGroup"));
				donor.setMobileNo(rs.getLong("MobileNo"));
				donor.setAddress(addr);

				donorList.add(donor);
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}
		}
		return donorList;

	}
	
	public List<Donor> getAll() throws DataSourceException {
		List<Donor> donorList = new ArrayList<Donor>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select d.Login_ID , d.MobileNo , d.BloodGroup,a.State,a.City From BloodDonors d ,"
				+ "Address a Where a.Donor_ID = d.Login_ID   ";

		try {
			con = dataSoruce.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Donor donor = new Donor();

				Address addr = new Address();
				addr.setDonorID(rs.getString("Login_ID"));
				addr.setCity(rs.getString("City"));
				addr.setState(rs.getString("State"));

				donor.setLoginId(rs.getString("Login_ID"));
				donor.setBloodGroup(rs.getString("BloodGroup"));
				donor.setMobileNo(rs.getLong("MobileNo"));
				donor.setAddress(addr);

				donorList.add(donor);
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException exp) {
					exp.printStackTrace();
					throw new DataSourceException(exp.getMessage());
				}
			}
		}
		return donorList;

	}

}
