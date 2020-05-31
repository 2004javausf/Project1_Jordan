package com.tuition.dao;

import java.util.List;

import com.tuition.beans.TuitionForm;

public interface TuitionFormDAO {
	
	public void addForm(TuitionForm form);
	public void updateForm(TuitionForm form);
	
	public TuitionForm getFormById(int user_id);
	
	public List<TuitionForm> getSubmittedForms();

}
