package com.donors.service;

import java.util.List;

import com.donors.dao.DataSourceException;
import com.donors.dao.Donor;
import com.donors.dao.DonorDAO;

public class DonorService {

	private DonorDAO donorDAO = new DonorDAO();

	public Donor getDonorByID(String loginId) throws ServicesException {
		Donor donor = null;
		try {
			donor = donorDAO.getDonorByID(loginId);
		} catch (DataSourceException e) {

			throw new ServicesException(e.getMessage());
		}

		return donor;
	}

	public List<Donor> search(String location) throws ServicesException {
		List<Donor> donorList = null;
		try {
			donorList = donorDAO.search(location);
		} catch (DataSourceException e) {

			throw new ServicesException(e.getMessage());
		}

		return donorList;
	}

	public List<Donor> getAll() throws ServicesException {
		List<Donor> donorList = null;
		try {
			donorList = donorDAO.getAll();
		} catch (DataSourceException e) {

			throw new ServicesException(e.getMessage());
		}

		return donorList;
	}

	public boolean save(Donor donor) throws ServicesException {
		boolean flag = false;
		try {
			flag = donorDAO.save(donor);
		} catch (DataSourceException e) {

			throw new ServicesException(e.getMessage());
		}

		return flag;
	}

	public Donor update(Donor donor) throws ServicesException {
		try {
			donor = donorDAO.update(donor);
		} catch (DataSourceException e) {

			throw new ServicesException(e.getMessage());
		}

		return donor;
	}

}
