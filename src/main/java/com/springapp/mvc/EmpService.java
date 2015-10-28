package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Wajih Sid on 10/27/2015.
 */
@Component
public class EmpService
{
    private EmpDAO empDAO;

    public EmpDAO getEmpDAO()
    {
        return empDAO;
    }

    @Autowired
    public void setEmpDAO(EmpDAO empDAO)
    {
        this.empDAO = empDAO;
    }

    public void addEmp(Emp emp)
    {
        getEmpDAO().insert(emp);
    }

    public List<Emp> fetchAllEmps()
    {
        return getEmpDAO().selectAll();
    }
}
