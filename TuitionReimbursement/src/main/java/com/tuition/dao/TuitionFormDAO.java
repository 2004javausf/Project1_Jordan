package com.tuition.dao;

import com.tuition.beans.TuitionForm;

public interface TuitionFormDAO {
	
	public void addForm(TuitionForm form);
	public void updateForm(TuitionForm form);
	
	public TuitionForm getFormById(int user_id);

}
