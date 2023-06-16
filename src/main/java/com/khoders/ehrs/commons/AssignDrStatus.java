/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khoders.ehrs.commons;

import com.khoders.resource.utilities.MsgResolver;

/**
 *
 * @author richa
 */
public enum AssignDrStatus implements MsgResolver
{
    UNATTENDED("UNATTENDED","Un Attended"),
    ATTENDED("ATTENDED","Attended");
    
    private final String code;
    private final String label;
    
    private AssignDrStatus(String code, String label){
        this.code=code;
        this.label=label;
    }

    @Override
    public String getCode()
    {
       return code;
    }

    @Override
    public String getLabel()
    {
       return label;
    }

    @Override
    public String toString()
    {
      return label;
    }
     
}
